
package org.usfirst.frc.team5822.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team5822.robot.subsystems.Climber;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Intake;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
//import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {


	public static OI oi;
	
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	//public static final Sensors sensors = new Sensors();
	public static final Intake intake = new Intake();
	public static final Climber climber = new Climber();
	public static final Sensors sensors = new Sensors();
	//public static OI oi;
	
	public static NetworkTable piTable;
	Command autonomousCommand;
	SendableChooser<Command> chooser;
	public static VisionPID vision = null;
	//public static DriveTrain driveTrain = null;
//	ITableListener_WB piListen = new ITableListener_WB();
	UsbCamera cam0; 
	UsbCamera cam1; 
	Mat image;
	Mat image1; 
	CvSink cvSink; 
	CvSource cvSource;
	CvSink cvSink1; 
	CvSource cvSource1;
	
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	PWM leds3;
	 
	
	SendableChooser<String> chooseAlliance; 
	SendableChooser<String> chooseShoot; 
	SendableChooser<String> chooseGear; 
	SendableChooser<String> chooseOrder; 
	public Robot() {
		chooseAlliance = new SendableChooser<>(); 
		chooseShoot = new SendableChooser<>(); 
		chooseGear = new SendableChooser<>(); 
		chooseOrder = new SendableChooser<>(); 
		chooser = new SendableChooser<>();
	}
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		Robot.vision = new VisionPID();
		//Robot.driveTrain = new DriveTrain();
		oi = new OI();
		SmartDashboard.putData("Auto mode", chooser);

		
		chooseShoot.addObject("Cross Baseline Only", "crossOnly");
		chooseShoot.addObject("Shoot Only", "shootOnly");
		chooseShoot.addObject("Gear Only", "gearOnly");
		chooseShoot.addObject("Gear and Shoot", "gearAndShoot");
		
		chooseGear.addObject("Peg Position 1", "peg1");
		chooseGear.addObject("Peg Poistion 2", "peg2");
		chooseGear.addObject("Peg Position 3", "peg3");
		
		chooseAlliance.addObject("Red Alliance", "red");
		chooseAlliance.addObject("Blue Alliance", "blue");
		
		chooseOrder.addObject("Peg First", "pegFirst");
		chooseOrder.addObject("Shoot First", "shootFirst");
		chooseOrder.addObject("Neither", "neither");
			
		SmartDashboard.putData("Auto Gear", chooseGear);
		SmartDashboard.putData("Auto Shoot", chooseShoot);
		SmartDashboard.putData("Auto Alliance", chooseAlliance);
		SmartDashboard.putData("Auto Order", chooseOrder);
		 
		leds3 = new PWM(3); 
		
		//TODO: Add to this thread all smart dashboard values you would like updated 
		Thread updateSmartDashBoard = new Thread(() -> { 
			while(!Thread.interrupted())
			{
				piTable.putBoolean("HGVision Enabled", VisionPID.hGVision); 
				piTable.putBoolean("Gear Vision Enabled", VisionPID.gearVision); 
			}
		});
		updateSmartDashBoard.start();
		
		Thread t = new Thread(() -> {
			try {
				cam0 = new UsbCamera ("USB Camera 0", 0);
				cam0.setResolution(320,240);
				cam0.setFPS(20);
				
				cam1 = new UsbCamera ("USB Camera 1", 1);
				cam1.setResolution(320,240);
				cam1.setFPS(20);
				
				cvSink = CameraServer.getInstance().getVideo(cam0);
				cvSink.setEnabled(true);
				cvSource = CameraServer.getInstance().putVideo("Current View", 320, 240);
				image = new Mat();	 
				
				cvSink1 = CameraServer.getInstance().getVideo(cam1);
				cvSink1.setEnabled(true);
				cvSource1 = CameraServer.getInstance().putVideo("Current View 1", 320, 240);
				image1 = new Mat();	
			}
			catch (Exception e)
			{
				System.out.println(e); 
			}
			
			while(!Thread.interrupted()) 
			{
				try{
					cvSink.grabFrame(image);
					cvSource.putFrame(image);
				
					cvSink1.grabFrame(image1);
					cvSource1.putFrame(image1);
				}
				catch (Exception e){
					System.out.println(e);
				}
				
			}
		}
		);
        t.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//leds3.setRaw(255);
		JoystickFunctions.joystickDrive(DriveTrain.drive);
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
//	public static NetworkTable returnTable()
//	{
//		return piTable; 
//	}
}

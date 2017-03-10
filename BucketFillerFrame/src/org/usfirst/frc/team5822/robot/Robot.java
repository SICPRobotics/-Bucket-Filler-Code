
package org.usfirst.frc.team5822.robot;

//import org.usfirst.frc.team5822.robot.commands.AutoBlueCenterGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoBlueBoilerGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoBlueRightGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoCenterGear;
//import org.usfirst.frc.team5822.robot.commands.AutoLeftGear;
import org.usfirst.frc.team5822.robot.commands.*;
//import org.usfirst.frc.team5822.robot.commands.AutoRedCenterGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoRedLeftGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoRedBoilerGearShoot;
//import org.usfirst.frc.team5822.robot.commands.AutoRightGear;
//import org.usfirst.frc.team5822.robot.commands.AutoShootThenGearBlue;
//import org.usfirst.frc.team5822.robot.commands.AutoRedBoilerShootGear;
import org.usfirst.frc.team5822.robot.subsystems.Climber;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Intake;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	
	SendableChooser chooser;
	Command autonomousCommand;
	Command Test = new AutoRedBoilerGear();

	//System.out.println("Jack Kulevich is awesome.");
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Sensors sensors = new Sensors();
	public static final Intake intake = new Intake();
	public static final Climber climber = new Climber();
	public static OI oi;
	String defense;

	@Override
	public void robotInit() 
	{
		System.out.println("running");
		oi = new OI();
		
		chooser = new SendableChooser();
//		//chooser.initTable(NetworkTable.getTable("Defense Chooser"));
		chooser.addDefault("Center Gear", new AutoCenterGear());
		chooser.addObject("Blue Boiler Gear", new AutoBlueBoilerGear());
		chooser.addObject("Red Boiler Gear", new AutoRedBoilerGear());
		chooser.addObject("Blue RZ Gear", new AutoBlueRzGear());
		chooser.addObject("Red RZ Gear", new AutoRedRZGear());
	
		chooser.addObject("Blue Center Gear Shoot", new AutoBlueCenterGearShoot());
		chooser.addObject("Red Center Gear Shoot", new AutoRedCenterGearShoot());
		chooser.addObject("Blue Boiler Gear Shoot", new AutoBlueBoilerGearShoot());
		chooser.addObject("Red Boiler Gear Shoot", new AutoRedBoilerGearShoot());

		chooser.addObject("Shoot", new AutoShoot());
		chooser.addObject("Blue Shoot Then Gear", new AutoBlueBoilerShootGear());
		chooser.addObject("Red Shoot Then Gear", new AutoRedBoilerShootGear());
				
		chooser.addObject("Cross Baseline", new AutoCrossDaBaseline());
		
		SmartDashboard.putData("Autonomous Defense Chooser", chooser);
	}

		@Override
		public void disabledInit() 
		{

		}

		@Override
		public void disabledPeriodic() 
		{

		}

	@Override
	public void autonomousInit() 
	{
		autonomousCommand = Test;
		autonomousCommand.start();
		
	}

		@Override
		public void autonomousPeriodic() 
		{
			Scheduler.getInstance().run();
		}

	@Override
	public void teleopInit() 
	{
		//Scheduler.getInstance().removeAll();
	}

		@Override
		public void teleopPeriodic() 
		{
			//see OI for other button functions
			Scheduler.getInstance().run();
			JoystickFunctions.joystickDrive(DriveTrain.wheelz);
			//System.out.println("LEFT ENCODER: "+ Sensors.leftEncoderDistance());
			//System.out.println("RIGHT ENCODER: "+ Sensors.rightEncoderDistance());
			//Shooter.shootMotor.set(1);
			
		}

	@Override
	public void testPeriodic() 
	{

	}
}


package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.AutoBlueCenterGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoBlueLeftGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoBlueRightGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoCenterGear;
import org.usfirst.frc.team5822.robot.commands.AutoLeftGear;
import org.usfirst.frc.team5822.robot.commands.AutoRedCenterGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoRedLeftGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoRedRightGearShoot;
import org.usfirst.frc.team5822.robot.commands.AutoRightGear;
import org.usfirst.frc.team5822.robot.commands.AutoShootThenGearBlue;
import org.usfirst.frc.team5822.robot.commands.AutoShootThenGearRed;
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
		
//		chooser = new SendableChooser();
//		//chooser.initTable(NetworkTable.getTable("Defense Chooser"));
//		chooser.addDefault("Center Gear", "AutoCenterGear");
//		chooser.addObject("Left Gear", "AutoLeftGear");
//		chooser.addObject("Right Gear", "AutoRightGear");
//		
//		SmartDashboard.putData("Autonomous Defense Chooser", chooser);
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
	
//		defense = chooser.getSelected().toString();
//		if (defense.equals("AutoCenterGear"));
//		{
//			autonomousCommand = new AutoCenterGear();
//			autonomousCommand.start();
//		}
//		if (defense.equals("AutoLeftGear"));
//		{
//			autonomousCommand = new AutoLeftGear();
//			autonomousCommand.start();
//		}
//		if (defense.equals("AutoRightGear"));
//		{
//			autonomousCommand = new AutoRightGear();
//			autonomousCommand.start();
//		}
		
		autonomousCommand = new AutoCenterGear();
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
			
		}

	@Override
	public void testPeriodic() 
	{

	}
}

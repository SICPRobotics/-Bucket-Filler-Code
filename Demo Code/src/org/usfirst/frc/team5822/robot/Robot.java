package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.*;
import org.usfirst.frc.team5822.robot.subsystems.*;
import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	SmartDashboard dashboard;
	
	//subsystems
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Sensors sensors;
	public static Climber climber;
	public static GearIntake gearIntake;
	
	//cameras
	UsbCamera cam0; 
	UsbCamera cam1; 

	@Override
	public void robotInit() 
	{
		dashboard = new SmartDashboard();
		driveTrain = new DriveTrain();
		climber = new Climber();
		sensors = new Sensors();
		oi = new OI();		
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void autonomousInit() 
	{

	}

	@Override
	public void autonomousPeriodic() 
	{
	}

	@Override
	public void teleopInit() 
	{
		dashboard.putNumber("Angle", sensors.gyroAngle());
	}

	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run(); //runs all button functions from the OI
		JoystickFunctions.joystickDrive(DriveTrain.drive);
	}

	@Override
	public void testPeriodic() 
	{
		LiveWindow.run();
	}

}

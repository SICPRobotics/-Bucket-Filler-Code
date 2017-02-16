package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.SICPRobotDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem 
{

	
	//static SICPRobotDrive drive;
	static RobotDrive drive;
	
	public DriveTrain()
	{
		drive = new RobotDrive(0,1,2,3);
	}
		
	public static void driveForward()
	{
		drive.drive(0.15, 0.0);
	}
	
	public static void driveBackward()
	{
		drive.drive(-0.15, 0.0);
	}
	
	public static void turnLeftSlow()
	{
		//turn left real slow boi
		drive.setLeftRightMotorOutputs(-.2, .2);
	
	}
	
	public static void turnLeftFast()
	{
		//turn left real fast boi
		drive.drive(0.3, -1);
	}
	
	public static void turnRightSlow()
	{
		//turn right super duper slowly maaaaaan
		drive.setLeftRightMotorOutputs(0.15, -.15);
	}
	
	public static void turnRightFast()
	{
		//turn right super duper fast boiiiii
		drive.drive(0.3, 1);
		
	}
	
	/*public static double returnSpeed()
	{
		drive.
	}*/
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}

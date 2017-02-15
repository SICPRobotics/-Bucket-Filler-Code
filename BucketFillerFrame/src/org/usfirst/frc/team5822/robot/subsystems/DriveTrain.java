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
		System.out.println("driving forward method");
	}
	
	public static void driveBackward()
	{
		drive.drive(-0.15, 0.0);
	}
	
	public static void turnLeft()
	{
		//turn left
		drive.drive(0.15, -1);
	}
	
	public static void turnRight()
	{
		//turn right
		drive.drive(0.2, 1);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}

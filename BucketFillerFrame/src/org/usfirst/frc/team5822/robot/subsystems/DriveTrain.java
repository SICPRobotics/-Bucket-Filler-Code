package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.SICPRobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem 
{

	
	static SICPRobotDrive drive;
	
	public DriveTrain()
	{
		drive = new SICPRobotDrive(0,1,2,3);
	}
	
	
	
	public static void driveForward()
	{
		drive.drive(0.5, 0.0);
	}
	
	public static void driveBackward()
	{
		drive.drive(-0.5, 0.0);
	}
	
	public static void turnLeft()
	{
		//turn left
		drive.drive(0.5, 1);
	}
	
	public static void turnRight()
	{
		//turn right
		drive.drive(0.5, -1);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}

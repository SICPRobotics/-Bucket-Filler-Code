package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

/**
 *
 */
public class DriveForward extends Command 
{
	int distance;
	
	
	public DriveForward(int encoderDistance) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		distance = encoderDistance;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		Robot.leftEncoder.reset();
		Robot.rightEncoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		DriveTrain.driveForward();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{

		if (Robot.leftEncoder.getDistance() < distance && Robot.rightEncoder.getDistance() < distance)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		
	}
}

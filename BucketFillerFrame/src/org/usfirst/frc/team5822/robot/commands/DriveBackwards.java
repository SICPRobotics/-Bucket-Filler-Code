package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

/**
 *
 */
public class DriveBackwards extends Command {
	
	double encoderDistance2;
	public DriveBackwards(double encoderDistance) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		encoderDistance2 = encoderDistance;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		//Robot.leftEncoder.reset();
		//Robot.rightEncoder.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		DriveTrain.driveBackward();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (Robot.leftEncoder.getDistance() > encoderDistance2 && Robot.rightEncoder.getDistance() > encoderDistance2)
			return true;
		return false;
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

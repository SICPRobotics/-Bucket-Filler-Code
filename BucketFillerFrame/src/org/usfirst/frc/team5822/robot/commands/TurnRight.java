package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;

/**
 *
 */
public class TurnRight extends Command {
	
	int turnAngle;

	
	public TurnRight(int desiredAngle) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		turnAngle = desiredAngle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		DriveTrain.turnRight();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{

		if (turnAngle < Robot.gyro.getAngle())
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
	protected void interrupted() {
		
	}
}

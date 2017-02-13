package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;

/**
 *
 */
public class LineUpGear extends Command {
	
	Timer timer = new Timer();
	
	public LineUpGear() 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		System.out.println("Line Up Gear init");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		System.out.println("lining up with gear");
		//write code that lines up here
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (timer.get() < 5)
			return false;
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		System.out.println("Ending line up with gear.");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
}

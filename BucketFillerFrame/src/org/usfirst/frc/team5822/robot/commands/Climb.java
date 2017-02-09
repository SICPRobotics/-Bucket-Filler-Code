package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {

	Timer climbTimer;
	
	public Climb() 
	{	
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		climbTimer = new Timer();
		climbTimer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		//spin the climber motor		
		System.out.println("climbing");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (climbTimer.get() > 2.0)
			return true;
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		System.out.println("done climbing");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
	}
}

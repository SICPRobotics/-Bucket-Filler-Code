package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	Timer shootTimer;
	
	public Shoot() 
	{	
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		shootTimer = new Timer();
		shootTimer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		//spin the shooter motors
		System.out.println("Shooting");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (shootTimer.get() > 2.0)
			return true;
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		System.out.println("done shooting");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
	}
}

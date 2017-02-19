package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

/**
 *
 */
public class AutoShoot extends Command {
	
	Timer auto;
	
	public AutoShoot() 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
		auto = new Timer();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		Shooter.init();
		auto.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{
		Shooter.shoot();
		System.out.println("Shooting");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() 
	{
		if (auto.get() < 10)
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

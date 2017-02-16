package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5822.robot.Robot;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;

/**
 *
 */
public class DriveForward extends Command 
{
	int distance;
	Timer timer = new Timer();
	
	public DriveForward(int encoderDistance) 
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensors);
		distance = encoderDistance;

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() 
	{
		//Sensors.resetEncoders();
		System.out.println("Drive Forward init");
		timer.start();
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
		if (Sensors.sonarDistance() > distance)
		{
			System.out.println(Sensors.sonarDistance());
			return false;
		}
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() 
	{
		System.out.println("Correct distance. Ending command.");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		
	}
}

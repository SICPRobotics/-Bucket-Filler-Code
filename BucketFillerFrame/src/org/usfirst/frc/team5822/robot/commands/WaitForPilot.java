package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitForPilot extends Command {

	Timer timer = new Timer();
	protected void initialize() 
	{

		timer.start();
	}
	protected void execute()
	{
		//do nothing until the pilot removes the gear
		//i don't know how we're going to figure out if the gear is gone
		//but we need to find a way to
		System.out.println("Waiting for Pilot.");
		System.out.println(timer.get());
	}
	
	@Override
	protected boolean isFinished() {
		if (timer.get() < 3)
			return false;
		return true;
	}

}

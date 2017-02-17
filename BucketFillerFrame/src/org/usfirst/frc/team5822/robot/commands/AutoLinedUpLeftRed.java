package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpLeftRed extends CommandGroup
{
	public AutoLinedUpLeftRed()
	{
		addSequential(new DriveForward(1,0));
		addSequential(new TurnRightFast(1));
		addSequential(new TurnLeftSlow(1)); //angle to airship
		addSequential(new DriveForward(1,0));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackward(1));
		addSequential(new TurnRightFast(1)); //angle from airship to boiler
		addSequential(new TurnLeftSlow(1));
		addSequential(new DriveForward(1, 0 ));
		addSequential(new TurnRightSlow(1)); //coming off straight to boiler
		//addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1,0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

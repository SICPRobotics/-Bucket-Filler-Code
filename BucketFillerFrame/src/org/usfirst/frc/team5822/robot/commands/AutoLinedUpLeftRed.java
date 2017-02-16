package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpLeftRed extends CommandGroup
{
	public AutoLinedUpLeftRed()
	{
		addSequential(new DriveForward(1,0));
		//addSequential(new TurnRight(1));
		addSequential(new DriveForward(1,0));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(1));
		///addSequential(new TurnRight(1));
		addSequential(new DriveForward(1, 0 ));
		//addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1,0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

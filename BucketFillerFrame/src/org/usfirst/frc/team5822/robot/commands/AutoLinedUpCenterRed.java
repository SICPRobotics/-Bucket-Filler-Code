package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpCenterRed extends CommandGroup
{
	public AutoLinedUpCenterRed()
	{
		addSequential(new DriveForward(1));
		addSequential(new LineUpGear());
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(1));
		addSequential(new TurnRight(1));
		addSequential(new DriveForward(1));
		addSequential(new TurnRight(1));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

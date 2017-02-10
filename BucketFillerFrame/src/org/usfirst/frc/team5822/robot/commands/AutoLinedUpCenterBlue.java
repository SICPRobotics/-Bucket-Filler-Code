package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpCenterBlue extends CommandGroup
{
	public AutoLinedUpCenterBlue()
	{
		addSequential(new DriveForward(1));
		addSequential(new LineUpGear());
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(1));
		addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1));
		addSequential(new TurnLeft(1));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

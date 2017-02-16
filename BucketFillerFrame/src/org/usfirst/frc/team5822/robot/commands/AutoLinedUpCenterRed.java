package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpCenterRed extends CommandGroup
{
	public AutoLinedUpCenterRed()
	{
		addSequential(new DriveForward(20,0));
		addSequential(new LineUpGear());
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(20));
		addSequential(new TurnRightFast(90));
		addSequential(new TurnLeftSlow(90));
		addSequential(new DriveForward(30,0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

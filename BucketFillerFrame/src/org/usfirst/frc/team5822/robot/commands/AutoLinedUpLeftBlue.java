package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpLeftBlue extends CommandGroup
{
	public AutoLinedUpLeftBlue()
	{
		addSequential(new DriveForward(1));
		addSequential(new TurnRightFast(1)); //angle to the airship
		addSequential(new TurnLeftSlow(1));
		addSequential(new DriveForward(1));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackward(1));
		addSequential(new TurnLeftFast(1)); //almost 180, turn around to the boiler
		addSequential(new DriveForward(1));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

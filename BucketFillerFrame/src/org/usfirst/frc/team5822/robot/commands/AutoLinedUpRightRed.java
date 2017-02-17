package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpRightRed extends CommandGroup
{
	public AutoLinedUpRightRed()
	{
		addSequential(new DriveForward(1, 0));
		addSequential(new TurnLeftFast(1));
		addSequential(new TurnRightSlow(1));
		addSequential(new LineUpGear());
		//addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1, 0 ));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackward(1));
		addSequential(new TurnLeftFast(1)); //almost 180. turning around to boiler
		addSequential(new DriveForward(1, 0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
		
	}
}

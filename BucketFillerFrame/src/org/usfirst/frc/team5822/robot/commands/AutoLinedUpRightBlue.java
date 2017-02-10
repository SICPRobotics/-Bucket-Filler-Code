package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpRightBlue extends CommandGroup
{
	public AutoLinedUpRightBlue()
	{
		addSequential(new DriveForward(1));
		addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(1));
		addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1));
		addSequential(new TurnRight(1));
		addSequential(new DriveForward(1));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
		
	}
}

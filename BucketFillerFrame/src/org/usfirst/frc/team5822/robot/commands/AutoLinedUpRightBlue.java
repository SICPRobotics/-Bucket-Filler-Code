package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpRightBlue extends CommandGroup
{
	public AutoLinedUpRightBlue()
	{
		addSequential(new DriveForward(1, 0 ));
		addSequential(new TurnLeftFast(1));
		addSequential(new TurnRightSlow(1));
		addSequential(new LineUpGear());
		//addSequential(new TurnLeft(1));
		addSequential(new DriveForward(1, 0));
		addSequential(new WaitForPilot());
		addSequential(new DriveBackward(1));
		addSequential(new TurnLeftFast(1));
		addSequential(new TurnRightSlow(1));
		addSequential(new DriveForward(1, 0));
		addSequential(new TurnLeftSlow(1));
		addSequential(new DriveForward(1 ,0 ));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
		
	}
}

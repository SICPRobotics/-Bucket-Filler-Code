package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpCenterBlue extends CommandGroup
{
	public AutoLinedUpCenterBlue()
	{
		addSequential(new DriveForward(30, 0)); //currently based on sonar distance, change this to encoder distance later
		addSequential(new LineUpGear());
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(30));
		addSequential(new TurnLeftFast(-65));
		addSequential(new TurnRightSlow(-65));
		addSequential(new DriveForward(30, 0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

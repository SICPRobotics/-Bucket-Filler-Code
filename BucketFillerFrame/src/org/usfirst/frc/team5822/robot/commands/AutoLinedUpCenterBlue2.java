package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLinedUpCenterBlue2 extends CommandGroup
{
	public AutoLinedUpCenterBlue2()
	{
		addSequential(new DriveForward(30,0)); //currently based on sonar distance, change this to encoder distance later
		addSequential(new LineUpGear());
		addSequential(new WaitForPilot());
		addSequential(new DriveBackwards(30));
		addSequential(new TurnLeftFast(-90));
		addSequential(new TurnRightSlow(-90));
		addSequential(new DriveForward(30,0));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

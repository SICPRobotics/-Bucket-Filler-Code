package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBlueCenterGearShoot extends CommandGroup
{
	public AutoBlueCenterGearShoot()
	{
		 addSequential(new DriveForward(82.55)); //input is encoder distance until start line up
	     addSequential(new LineUpGear());
	     addSequential(new DriveForward(1)); //small distance, until gear is on peg
	     addSequential(new WaitForPilot(3));
	     addSequential(new DriveForward(.5)); //very very very small distance
	     addSequential(new WaitForPilot(10));  //change this time
	
		addSequential(new DriveBackward(39.57));
		addSequential(new TurnLeftFast(-46.57));
		addSequential(new TurnRightSlow(-46.57));
		addSequential(new DriveForward(160.55));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

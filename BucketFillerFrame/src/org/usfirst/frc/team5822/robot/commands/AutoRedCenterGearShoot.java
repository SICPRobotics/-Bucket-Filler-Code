package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRedCenterGearShoot extends CommandGroup
{
	public AutoRedCenterGearShoot()
	{
		 addSequential(new DriveForward(1)); //input is encoder distance until start line up
	     addSequential(new LineUpGear());
	     addSequential(new DriveForward(1)); //small distance, until gear is on peg
	     addSequential(new WaitForPilot(3));
	     addSequential(new DriveForward(1)); //very very very small distance
	     addSequential(new WaitForPilot(10));  //change this time
	
		addSequential(new DriveBackward(20));
		addSequential(new TurnRightFast(90));
		addSequential(new TurnLeftSlow(90));
		addSequential(new DriveForward(30));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
	}
}

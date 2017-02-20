package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRedCenterGearShoot extends CommandGroup
{
	public AutoRedCenterGearShoot()
	{
		 addSequential(new DriveBackward(82.55)); //input is encoder distance until start line up
	     addSequential(new LineUpGear());
//	     addSequential(new DriveForward(1)); //small distance, until gear is on peg
	     addSequential(new WaitForPilot(3));
//	     addSequential(new DriveForward(.5)); //very very very small distance
//	     addSequential(new WaitForPilot(10));  //change this time
	
		addSequential(new DriveForward(2)); //36 in
		addSequential(new TurnRightFast(46.57));
		addSequential(new TurnLeftSlow(46.57));
		addSequential(new DriveBackward(160.55)); //141.66 in
		//addSequential(new LineUpBoiler());
		//addSequential(new Shoot());
	}
}

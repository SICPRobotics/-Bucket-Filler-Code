package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRedBoilerGearShoot extends CommandGroup
{
	public AutoRedBoilerGearShoot()
	{
		addSequential(new DriveForward(62.95));
		addSequential(new TurnLeftFast(-59.42));
		addSequential(new TurnRightSlow(-59.42));
		addSequential(new DriveForward(83.48));
//	    addSequential(new LineUpGear());
//	    addSequential(new DriveForward(1)); //small distance, until gear is on peg
//	    addSequential(new WaitForPilot(3));
//	    addSequential(new DriveForward(1)); //very very very small distance
	    addSequential(new WaitForPilot(5));  
			
		addSequential(new DriveBackward(18.5));
		addSequential(new TurnLeftFast(-59.42)); //almost 180, turn around to the boiler
		addSequential(new TurnRightSlow(-59.42));
		addSequential(new DriveBackward(96.38));
		addSequential(new TurnRightFast(74.79));
		addSequential(new TurnLeftSlow(74.79));
		addSequential(new DriveBackward(27));
		//addSequential(new LineUpBoiler());
		//addSequential(new Shoot());
	}
}

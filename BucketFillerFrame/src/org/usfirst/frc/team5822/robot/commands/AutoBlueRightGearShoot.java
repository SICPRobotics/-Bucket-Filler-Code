package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoBlueRightGearShoot extends CommandGroup
{
	public AutoBlueRightGearShoot()
	{
        addSequential(new DriveForward(1)); //input is encoder distance until start line up
        addSequential(new TurnLeftFast(-65)); //input is angle we want to turn
        addSequential(new TurnRightSlow(-65)); //have to figure out distance
        addSequential(new LineUpGear());
        addSequential(new DriveForward(1)); //small distance, until gear is on peg
        addSequential(new WaitForPilot(3)); //input is number of seconds
        addSequential(new DriveForward(1)); //very very very small distance
        addSequential(new WaitForPilot(10)); 
        
		addSequential(new DriveBackward(1));
		addSequential(new TurnLeftFast(1));
		addSequential(new TurnRightSlow(1));
		addSequential(new DriveForward(1));
		addSequential(new TurnLeftSlow(1));
		addSequential(new DriveForward(1));
		addSequential(new LineUpBoiler());
		addSequential(new Shoot());
		
	}
}

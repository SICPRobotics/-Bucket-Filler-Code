package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootThenGearRed extends CommandGroup {

    public AutoShootThenGearRed() 
    {
      	addSequential(new DriveBackward(1));
    	addSequential(new TurnLeftSlow(1)); //find angle to get it lined up with boiler
    	addSequential(new DriveForward(1));
    	addSequential(new Shoot());
    	addSequential(new TurnLeftFast(1));
    	addSequential(new TurnRightSlow(1));
    	addSequential(new DriveForward(1)); //Heads to the Peg
    	addSequential(new TurnLeftSlow(1));
    	addSequential(new LineUpGear());
    	addSequential(new DriveForward(1));
    	addSequential(new WaitForPilot());
    }
}

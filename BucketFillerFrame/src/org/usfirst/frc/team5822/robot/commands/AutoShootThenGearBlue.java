package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootThenGearBlue extends CommandGroup {

    public AutoShootThenGearBlue() 
    {
    	addSequential(new DriveBackward(1));
    	addSequential(new TurnRightSlow(1)); //find angle to get it lined up with boiler
    	addSequential(new DriveForward(1));
    	addSequential(new Shoot());
    	addSequential(new TurnRightFast(1));
    	addSequential(new TurnLeftSlow(1));
    	addSequential(new TurnRightFast(1));
    	addSequential(new TurnLeftSlow(1));
    	//addSequential(new TurnRight180(1)); //Code for this later if easier but we already essentially have this code.
    	addSequential(new DriveForward(1)); //Heads to the Peg
    	//addSequential(new Turn) // This is for later, when we know what angles are
    	addSequential(new DriveForward(1));
    	addSequential(new WaitForPilot());
    }
}

package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueBoilerShootGear extends CommandGroup {

    public AutoBlueBoilerShootGear() 
    {
    	addSequential(new AutoShoot());
    	addSequential(new DriveBackward(10.43));
    	addSequential(new TurnRightFast(74.79));
    	addSequential(new TurnLeftSlow(74.79));
    	addSequential(new DriveBackward(78.72)); //Heads to the Peg
    	addSequential(new TurnLeftFast(-59.42));
    	addSequential(new TurnRightSlow(-59.42));
    	addSequential(new DriveBackward(21.5));
 
//    	addSequential(new LineUpGear());
//    	addSequential(new DriveForward(1));
//    	addSequential(new WaitForPilot(1));
    }
}

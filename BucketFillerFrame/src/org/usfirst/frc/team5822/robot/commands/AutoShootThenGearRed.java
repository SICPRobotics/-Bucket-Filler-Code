package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootThenGearRed extends CommandGroup {

    public AutoShootThenGearRed() 
    {
    	addSequential(new AutoShoot());
    	addSequential(new DriveBackward(1));
    	addSequential(new TurnLeftFast(1));
    	addSequential(new TurnRightSlow(1));
    	addSequential(new DriveForward(1)); //Heads to the Peg
 
    	addSequential(new LineUpGear());
    	addSequential(new DriveForward(1));
    	addSequential(new WaitForPilot(1));
    }
}

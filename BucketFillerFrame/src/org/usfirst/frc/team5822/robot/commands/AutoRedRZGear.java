package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedRZGear extends CommandGroup {

    public AutoRedRZGear() 
    {
    	addSequential(new DriveBackward(53.67));
    	addSequential(new TurnRightFast(59.42));
    	addSequential(new TurnLeftSlow(59.42));
    	addSequential(new DriveBackward(102));
    }
}

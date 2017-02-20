package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossDaBaseline extends CommandGroup {

    public AutoCrossDaBaseline() 
    {
    	addSequential(new DriveBackward(150));
    }
}

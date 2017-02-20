package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueRzGear extends CommandGroup {

    public AutoBlueRzGear() 
    {
    	addSequential(new DriveBackward(53.67));
    	addSequential(new TurnLeftFast(-59.42));
    	addSequential(new TurnRightSlow(-59.42));
    	addSequential(new DriveBackward(102));
    }
}

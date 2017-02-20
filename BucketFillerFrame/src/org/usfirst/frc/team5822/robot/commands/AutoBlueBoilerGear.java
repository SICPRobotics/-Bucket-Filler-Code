package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBlueBoilerGear extends CommandGroup {

    public AutoBlueBoilerGear()
    {
    	addSequential(new DriveForward(62.95));
    	addSequential(new TurnRightFast(59.42));
    	addSequential(new TurnLeftSlow(59.42));
    	addSequential(new DriveForward(83.48));
    }
}

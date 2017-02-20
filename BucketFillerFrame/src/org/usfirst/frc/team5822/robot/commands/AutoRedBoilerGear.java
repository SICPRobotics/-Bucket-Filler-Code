package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRedBoilerGear extends CommandGroup {

    public AutoRedBoilerGear()
    {
     addSequential(new DriveForward(62.95));
     addSequential(new TurnLeftFast(-59.42));
     addSequential(new TurnRightSlow(-59.42));
     addSequential(new DriveForward(83.48));
     //Need the stuff that lets the human player take up gear
    }
}

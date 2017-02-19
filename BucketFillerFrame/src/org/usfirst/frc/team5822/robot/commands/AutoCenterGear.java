package org.usfirst.frc.team5822.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenterGear extends CommandGroup {

    public AutoCenterGear() 
    {
        addSequential(new DriveForward(1)); //input is encoder distance until start line up
        addSequential(new LineUpGear());
        addSequential(new DriveForward(1)); //small distance, until gear is on peg
        addSequential(new WaitForPilot(3));
        addSequential(new DriveForward(1)); //very very very small distance
        addSequential(new WaitForPilot(10));        
    }
}

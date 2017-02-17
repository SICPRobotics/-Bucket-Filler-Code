package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.VisionPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HGVision extends Command {

		
    public HGVision() 
    {
        requires (Robot.vision); 
      
        
       }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	if (VisionPID.hGVision)
    		Robot.vision.enable(); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	System.out.println("RUNNING HG VISION");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	
        if (!VisionPID.hGVision)
        		return true; 
        
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.vision.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.JoystickFunctions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class InvertMotors extends Command {

	private int x = 1;
	
    public InvertMotors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	JoystickFunctions.invertMotors(); 
    	x += x;
    	if (x%2 ==0)
    	{
    	   	SmartDashboard.putBoolean("Inverted Motors?", true);
    	}
    	else
    	   	SmartDashboard.putBoolean("Inverted Motors?", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

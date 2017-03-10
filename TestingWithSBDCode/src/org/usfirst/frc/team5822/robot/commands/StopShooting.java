package org.usfirst.frc.team5822.robot.commands;

import org.usfirst.frc.team5822.robot.Robot;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class StopShooting extends Command {

    public StopShooting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    //	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putBoolean("Shooting", false);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Shooter.stopShooting();
    	System.out.println("Stop shooting.");
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

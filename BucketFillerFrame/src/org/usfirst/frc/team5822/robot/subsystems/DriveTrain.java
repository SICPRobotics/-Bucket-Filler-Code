package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.SICPRobotDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem 
{

	
	//static SICPRobotDrive drive;
	public static SICPRobotDrive wheelz;
	ADXRS450_Gyro gyro;
	static double setpoint; 
	
	public DriveTrain()
	{

		super("DriveTrain", .2, .000, 0);// The constructor passes a name for the subsystem and the P, I and D constants that are sueed when computing the motor output
		setAbsoluteTolerance(0.001);
		getPIDController().setContinuous(false);
		wheelz = new SICPRobotDrive(0,1,2,3);
		gyro = new ADXRS450_Gyro();
		gyro.reset();
		setpoint = 0; 
	}
		
	public static double pidAt(double set)
	{
		setpoint = set;  
		return setpoint; 
	}
	
	protected double returnPIDInput() 
	{
    	
		return gyro.getAngle() - setpoint; // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
    	wheelz.setLeftRightMotorOutputs(.3 + output, .3 - output);; // this is where the computed output value fromthe PIDController is applied to the motor
    }
	
	public static void driveForward()
	{
		wheelz.drive(0.15 , 0.0);
	}
	
	public static void driveBackward()
	{
		wheelz.drive(-0.15, 0.0);
	}
	
	public static void turnLeftSlow()
	{
		wheelz.setLeftRightMotorOutputs(-.2, .2);
	}
	
	public static void turnLeftFast()
	{
		wheelz.drive(0.3, -1);
	}
	
	public static void turnRightSlow()
	{
		wheelz.setLeftRightMotorOutputs(0.15, -.15);
	}
	
	public static void turnRightFast()
	{
		wheelz.drive(0.3, 1);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}

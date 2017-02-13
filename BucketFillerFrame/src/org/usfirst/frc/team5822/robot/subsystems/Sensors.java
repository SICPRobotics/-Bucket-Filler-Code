package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem 
{
	static ADXRS450_Gyro gyro;
	static Encoder leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //I don't know if this is the right way to construct this but it's what Martin had
	static Encoder rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //Check this later because I don't have time right now
	AnalogInput sonar = new AnalogInput(0); //fill in based on which port it is plugged in
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static void resetEncoders()
	{
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public static double leftEncoderDistance()
	{
		return leftEncoder.getDistance();
	}
	
	public static double rightEncoderDistance()
	{
		return rightEncoder.getDistance();
	}
	
	public static void resetGyro()
	{
		gyro.reset();
	}
	
	public static double gyroAngle()
	{
		return gyro.getAngle();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


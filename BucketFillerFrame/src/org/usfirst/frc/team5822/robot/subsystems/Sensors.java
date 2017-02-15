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
	//static Encoder leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //I don't know if this is the right way to construct this but it's what Martin had
	//static Encoder rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //Check this later because I don't have time right now
	static AnalogInput ultra; //fill in based on which port it is plugged in
	
	public Sensors()
	{
		gyro  = new ADXRS450_Gyro();
		ultra = new AnalogInput(1);
	}
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static double sonarDistance()
	{
		double voltage = ultra.getAverageVoltage(); // reads the range on the ultrasonic sensor
		double sensitivity = 10;
		double range = voltage * sensitivity * 4.1898; //4.1898 from excel equation
		return range;
	}
	
	public static void resetEncoders()
	{
		//leftEncoder.reset();
		//rightEncoder.reset();
	}
	
//	public static double leftEncoderDistance()
//	{
//		return leftEncoder.getDistance();
//	}
//	
//	public static double rightEncoderDistance()
//	{
//		return rightEncoder.getDistance();
//	}
	
	public static void resetGyro()
	{
		System.out.println("haylo");
		gyro.reset();
	}
	
	public static double gyroAngle()
	{
		System.out.println("We're here rn");
		double x = gyro.getAngle();
		System.out.println("We made it to here");
		return gyro.getAngle();
	}
	
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


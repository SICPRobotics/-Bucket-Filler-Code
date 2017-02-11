
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	SICPRobotDrive wheelz;
	AnalogSonar ultra;
	public static ADXRS450_Gyro gyro;
	public static Encoder leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //I don't know if this is the right way to construct this but it's what Martin had
	public static Encoder rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X); //Check this later because I don't have time right now
	public static AnalogInput sonar = new AnalogInput(0); //fill in based on which port it is plugged in
	
	private final static int SONAR_PORT = 1;

	@Override
	public void robotInit() 
	{
		wheelz = new SICPRobotDrive(0, 1, 2, 3);
		ultra = new AnalogSonar(SONAR_PORT);
		SmartDashboard.putNumber("Sonar Distance", ultra.RangeInInches());
		gyro = new ADXRS450_Gyro();
		SmartDashboard.putNumber("Gyro Distance", gyro.getAngle());
		
	}

		@Override
		public void disabledInit() 
		{
			//hi
		}

		@Override
		public void disabledPeriodic() 
		{

		}

	@Override
	public void autonomousInit() 
	{

	}

		@Override
		public void autonomousPeriodic() 
		{

		}

	@Override
	public void teleopInit() 
	{

	}

		@Override
		public void teleopPeriodic() 
		{
	
			XboxFunctions.intake();
			JoystickFunctions.joystickDrive(wheelz);

		}

	@Override
	public void testPeriodic() 
	{

	}
}

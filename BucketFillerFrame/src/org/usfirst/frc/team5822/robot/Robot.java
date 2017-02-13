
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static Sensors sensors;
	SICPRobotDrive wheelz;
	AnalogSonar ultra;
	ADXRS450_Gyro gyro;
	
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
			JoystickFunctions.joystickDrive(wheelz);
		}

	@Override
	public void testPeriodic() 
	{

	}
}

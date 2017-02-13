
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterBlue;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static Sensors sensors;
	SICPRobotDrive wheelz;
	ADXRS450_Gyro gyro;
	Command autonomousCommand;

	@Override
	public void robotInit() 
	{
		wheelz = new SICPRobotDrive(0, 1, 2, 3);
		//SmartDashboard.putNumber("Sonar Distance", ultra.RangeInInches());
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
		autonomousCommand = new AutoLinedUpCenterBlue();
		autonomousCommand.start();
	}

		@Override
		public void autonomousPeriodic() 
		{
			Scheduler.getInstance().run();
		}

	@Override
	public void teleopInit() 
	{

	}

		@Override
		public void teleopPeriodic() 
		{
			//see OI for other button functions
			JoystickFunctions.joystickDrive(wheelz);
		}

	@Override
	public void testPeriodic() 
	{

	}
}

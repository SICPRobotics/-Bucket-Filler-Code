
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterBlue;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot 
{
	Command autonomousCommand;
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Sensors sensors = new Sensors();
	//RobotDrive wheelz;
	ADXRS450_Gyro gyro;
	

	@Override
	public void robotInit() 
	{
		//wheelz = new RobotDrive(0, 1, 2, 3);
		//SmartDashboard.putNumber("Sonar Distance", ultra.RangeInInches());
		gyro = new ADXRS450_Gyro();
		SmartDashboard.putNumber("Gyro Distance", gyro.getAngle());

		//autonomousCommand = new AutoLinedUpCenterBlue();
				
	}

		@Override
		public void disabledInit() 
		{
			
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
			Scheduler.getInstance().run();
			//JoystickFunctions.joystickDrive(wheelz);
			gyro.reset();
			System.out.println("gyro reset");
			System.out.println(gyro.getAngle());
		}

	@Override
	public void testPeriodic() 
	{

	}
}

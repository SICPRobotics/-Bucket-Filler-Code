
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterBlue;
import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterRed;
import org.usfirst.frc.team5822.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5822.robot.subsystems.Intake;
import org.usfirst.frc.team5822.robot.subsystems.Sensors;
import org.usfirst.frc.team5822.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
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
	public static final Intake intake = new Intake();
	//public static AnalogInput ultra;
	SICPRobotDrive wheelz;
//	ADXRS450_Gyro gyro;
	

	@Override
	public void robotInit() 
	{
		wheelz = new SICPRobotDrive(0, 1, 2, 3);
		//SmartDashboard.putNumber("Sonar Distance", ultra.RangeInInches());
//		gyro = new ADXRS450_Gyro();
//		SmartDashboard.putNumber("Gyro Distance", gyro.getAngle());

		//autonomousCommand = new AutoLinedUpCenterBlue();
				System.out.println("Robot Init");
				//ultra = new AnalogInput(1);
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
		System.out.println("Hello Jacob");
	}

		@Override
		public void autonomousPeriodic() 
		{
			Scheduler.getInstance().run();
		}

	@Override
	public void teleopInit() 
	{
		Scheduler.getInstance().removeAll();
	}

		@Override
		public void teleopPeriodic() 
		{
			//see OI for other button functions
			Scheduler.getInstance().run();
			JoystickFunctions.joystickDrive(wheelz);
			//gyro.reset();
			//System.out.println("gyro reset");
			//System.out.println(gyro.getAngle());
			//double voltage = ultra.getAverageVoltage(); // reads the range on the ultrasonic sensor
			//double sensitivity = 10;
			//double range = voltage * sensitivity * 4.1898; //4.1898 from excel equation
			//System.out.println(range);
		}

	@Override
	public void testPeriodic() 
	{

	}
}

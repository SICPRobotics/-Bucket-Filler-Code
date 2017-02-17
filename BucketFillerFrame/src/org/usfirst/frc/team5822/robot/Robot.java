
package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterBlue;
import org.usfirst.frc.team5822.robot.commands.AutoLinedUpCenterRed;
import org.usfirst.frc.team5822.robot.subsystems.Climber;
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
	public static final Climber climber = new Climber();

	@Override
	public void robotInit() 
	{

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
		Scheduler.getInstance().removeAll();
	}

		@Override
		public void teleopPeriodic() 
		{
			//see OI for other button functions
			Scheduler.getInstance().run();
			JoystickFunctions.joystickDrive(DriveTrain.wheelz);
		}

	@Override
	public void testPeriodic() 
	{

	}
}

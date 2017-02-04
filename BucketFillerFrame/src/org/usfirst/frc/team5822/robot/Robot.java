
package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot 
{
	RobotDrive wheelz;
	
	@Override
	public void robotInit() 
	{
		wheelz = new RobotDrive(0, 1, 2, 3);
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
			XboxFunctions.xboxButtons();
			JoystickFunctions.joystickDrive(wheelz);
			JoystickFunctions.visionLineUp(wheelz);
		}

	@Override
	public void testPeriodic() 
	{

	}
}

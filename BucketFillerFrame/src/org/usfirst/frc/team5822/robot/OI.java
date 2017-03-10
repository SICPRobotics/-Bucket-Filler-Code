package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.Climb;
import org.usfirst.frc.team5822.robot.commands.OuttakeSlow;
import org.usfirst.frc.team5822.robot.commands.Swallow;
import org.usfirst.frc.team5822.robot.commands.Shoot;
import org.usfirst.frc.team5822.robot.commands.StopClimb;
import org.usfirst.frc.team5822.robot.commands.StopIntake;
import org.usfirst.frc.team5822.robot.commands.StopShooting;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{
	Joystick xboxCtr = new Joystick(1);

	Button buttonA = new JoystickButton(xboxCtr, 1); 
	Button buttonB = new JoystickButton(xboxCtr, 2);
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonY = new JoystickButton(xboxCtr, 4); 

	public OI()
	{
		buttonA.whenActive(new Swallow()); 		
		buttonA.whenInactive(new StopIntake());
		
		buttonB.whenActive(new OuttakeSlow());
		buttonB.whenInactive(new StopIntake());
		
		buttonX.whenActive(new Shoot());
		buttonX.whenInactive(new StopShooting());
		
		buttonY.whenActive(new Climb());
		buttonY.whenInactive(new StopClimb());
	}
}

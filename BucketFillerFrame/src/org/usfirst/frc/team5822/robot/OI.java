package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.Climb;
import org.usfirst.frc.team5822.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{
	Joystick xboxCtr = new Joystick(1);
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonY = new JoystickButton(xboxCtr, 4);

	public OI()
	{
		buttonX.whenPressed(new Shoot());
		buttonY.whenPressed(new Climb());
	}
}

package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.Climb;
import org.usfirst.frc.team5822.robot.commands.Swallow;
import org.usfirst.frc.team5822.robot.commands.Outtake;
import org.usfirst.frc.team5822.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{
	Joystick xboxCtr = new Joystick(1);

	Button buttonY = new JoystickButton(xboxCtr, 4);
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonA = new JoystickButton(xboxCtr, 1); 
	Button buttonB = new JoystickButton(xboxCtr, 2);

	public OI()
	{
		buttonX.whileHeld(new Shoot());
		buttonY.whileHeld(new Climb());
		buttonA.whileHeld(new Swallow()); 
		buttonB.whileHeld(new Outtake()); 		
	}
}

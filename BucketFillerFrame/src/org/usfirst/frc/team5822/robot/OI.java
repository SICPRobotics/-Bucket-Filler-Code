package org.usfirst.frc.team5822.robot;

import org.usfirst.frc.team5822.robot.commands.Climb;
import org.usfirst.frc.team5822.robot.commands.GearLineUp;
import org.usfirst.frc.team5822.robot.commands.GearVisionEnable;
import org.usfirst.frc.team5822.robot.commands.HighGoalAngle;
import org.usfirst.frc.team5822.robot.commands.HighGoalDistance;
import org.usfirst.frc.team5822.robot.commands.HighGoalVisionEnable;
import org.usfirst.frc.team5822.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI 
{
	Joystick xboxCtr = new Joystick(1);
	Joystick joystick = new Joystick(0);
	Button button7 = new JoystickButton(joystick, 7);
	Button button8 = new JoystickButton(joystick, 8);
	Button button9 = new JoystickButton(joystick, 9);	
	Button button10 = new JoystickButton(joystick, 10);
	Button button11 = new JoystickButton(joystick, 11);
	Button buttonY = new JoystickButton(xboxCtr, 4 );
	Button buttonX = new JoystickButton(xboxCtr, 3);

	public OI()
	{
		buttonX.whenPressed(new Shoot());
		buttonY.whenPressed(new Climb());
		buttonX.whileHeld(new Shoot());
		buttonY.whenPressed(new Climb());
		button7.whenPressed(new GearLineUp());
		button8.whenPressed(new GearVisionEnable());
		button9.whenPressed(new HighGoalAngle());
		button10.whenPressed(new HighGoalDistance());
		button11.whenPressed(new HighGoalVisionEnable());
		
		
	}
}

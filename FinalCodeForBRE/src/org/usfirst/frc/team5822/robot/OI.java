package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5822.robot.commands.GearCG;
import org.usfirst.frc.team5822.robot.commands.GearVision;
import org.usfirst.frc.team5822.robot.commands.HGVision;
import org.usfirst.frc.team5822.robot.commands.HighGoalCG;
import org.usfirst.frc.team5822.robot.commands.ToggleGear;
import org.usfirst.frc.team5822.robot.commands.ToggleHG;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick xboxCtr;
	Joystick joystick;
	
	Button j1;
	Button j2;
	Button j11;
	Button j12;
	
	Button button7;
	Button button8;
	Button button9;
	Button button10;
	Button buttonY;
	Button buttonX;
	Button buttonA;
	Button buttonB;

	public OI() 
	{
		xboxCtr = new Joystick(1);
		joystick = new Joystick(0);
		
		j1 = new JoystickButton(joystick, 1); 
		j2 = new JoystickButton(joystick, 2); 
		j11 = new JoystickButton(joystick, 11);
		j12 = new JoystickButton(joystick, 12);
		
		button7 = new JoystickButton(joystick, 7);
		button8 = new JoystickButton(joystick, 8);
		button9 = new JoystickButton(joystick, 9);	
		button10 = new JoystickButton(joystick, 10);
		
		buttonY = new JoystickButton(xboxCtr, 4 );
		buttonX = new JoystickButton(xboxCtr, 3);
		buttonA = new JoystickButton(xboxCtr, 1);
		buttonB = new JoystickButton(xboxCtr, 2);

		//j1.whileHeld(new HighGoalCG());
		j11.whenActive(new GearCG());
		j12.whenActive(new HighGoalCG());
			
		j11.whenInactive(new GearCG());
		j12.whenInactive(new HighGoalCG());
		
		
		
	}
}

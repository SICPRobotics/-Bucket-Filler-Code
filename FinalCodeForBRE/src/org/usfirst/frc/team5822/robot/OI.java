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

	Joystick xboxCtr = new Joystick(1);
	Joystick joystick = new Joystick(0);
	
	Button j1 = new JoystickButton(joystick, 1); 
	Button j2 = new JoystickButton(joystick, 2); 
	
	Button button7 = new JoystickButton(joystick, 7);
	Button button8 = new JoystickButton(joystick, 8);
	Button button9 = new JoystickButton(joystick, 9);	
	Button button10 = new JoystickButton(joystick, 10);
	Button button11 = new JoystickButton(joystick, 11);
	Button button12 = new JoystickButton(joystick, 12);
	Button buttonY = new JoystickButton(xboxCtr, 4 );
	Button buttonX = new JoystickButton(xboxCtr, 3);
	Button buttonA = new JoystickButton(xboxCtr, 1);
	Button buttonB = new JoystickButton(xboxCtr, 2);

	public OI() 
	{
		//j1.whileHeld(new HighGoalCG());
		button11.whenActive(new GearCG());
		button12.whenActive(new HighGoalCG());
			
		button11.whenInactive(new GearCG());
		button12.whenInactive(new HighGoalCG());
		
		
		
	}
}

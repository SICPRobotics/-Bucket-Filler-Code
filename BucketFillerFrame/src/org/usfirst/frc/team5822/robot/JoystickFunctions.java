package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickFunctions 
{
	
	static Joystick discoStick = new Joystick(1); //joystick object
	static double moveValue;
	static double rotateValue;	
	
	public static void joystickDrive(SICPRobotDrive wheelz)
	{
		double scale = discoStick.getRawAxis(3)*-1;
		scale = ((scale+1)/5)+0.6; 

		//gets the x and y axis values from the joystick 
		moveValue = discoStick.getRawAxis(1);
		rotateValue = discoStick.getRawAxis(0); 

		//dead zone on y axis value
		if (Math.abs(moveValue)<0.005)
			moveValue = 0; 

		//creates a dead zone on x axis value only if the y axis value is small 
		if (Math.abs(rotateValue)<0.005 && Math.abs(moveValue)<0.1)
			rotateValue = 0;

		//scale down the values 
		moveValue = moveValue*scale*-1; 
		rotateValue = rotateValue*-0.6; //rotation scale factor used last year (2016), can change 
		
		wheelz.arcadeDrive(moveValue, rotateValue, true);
		
	}
}

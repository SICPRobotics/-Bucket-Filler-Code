package org.usfirst.frc.team5822.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.XboxController;

public class XboxFunctions 
{
	
	private static CANTalon ballBlaster = new CANTalon(4); //Shoot
	private static CANTalon intake = new CANTalon(5); //Intake
	private static CANTalon soHigh = new CANTalon(6); //Climb
	static XboxController milesXD = new XboxController(1); //xbox controller object
	
	public static void xboxButtons ()
	{
		
		if(milesXD.getAButton() == true) 
		{
			//ballBlaster.set(1.0); //sets motor power for shooting
			System.out.println("SHOOOOOOOOOOT");
		}
		
		if(milesXD.getYButton() == true) 
		{
			//soHigh.set(1.0); //sets motor power for climbing
			System.out.println("TO INFINITY, AND BEYOND");
		}
		
		double intakeAxis = milesXD.getRawAxis(5); 

		//intake.set(intakeAxis);
		System.out.println(intakeAxis);
		
		
	}
}

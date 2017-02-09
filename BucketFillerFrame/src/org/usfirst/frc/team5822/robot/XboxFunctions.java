package org.usfirst.frc.team5822.robot;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.XboxController;

public class XboxFunctions 
{

	static XboxController milesXD = new XboxController(0); //xbox controller object
	
	public static void xboxButtons()
	{

		double intakeAxis = milesXD.getRawAxis(5); 

		//intake.set(intakeAxis);
		System.out.println(intakeAxis);
		
		
	}
}

package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.XboxController;

public class XboxFunctions 
{

	static XboxController milesXD = new XboxController(0); //xbox controller object
	
	public static void intake()
	{

		double intakeAxis = milesXD.getRawAxis(5); 

		//intake.set(intakeAxis);
		System.out.println(intakeAxis);
				
	}
}

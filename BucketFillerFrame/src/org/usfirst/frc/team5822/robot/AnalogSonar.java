package org.usfirst.frc.team5822.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogSonar 
{
	AnalogInput ultra;
	
	public AnalogSonar(int x)
	{
		ultra = new AnalogInput(x);
	}
	

	public double RangeInInches()
	{
		double voltage = ultra.getAverageVoltage(); // reads the range on the ultrasonic sensor
		double sensitivity = 10;
		double range = voltage * sensitivity * 4.1898; //4.1898 from excel equation
		return range;
	}
}

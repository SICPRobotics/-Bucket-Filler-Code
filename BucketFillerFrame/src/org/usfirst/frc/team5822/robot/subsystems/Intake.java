package org.usfirst.frc.team5822.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon cacaw = new CANTalon(4);
	
	public void takeIn()
	{
		cacaw.set(.75);
	}
	
	public void eject()
	{
		cacaw.set(-0.75);
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


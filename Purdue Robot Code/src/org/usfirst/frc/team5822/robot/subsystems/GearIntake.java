package org.usfirst.frc.team5822.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearIntake extends Subsystem 
{
	Compressor c;
	DoubleSolenoid hanSolo;
	CANTalon intake;

	public GearIntake()
	{
		c = new Compressor(0);
		c.setClosedLoopControl(true);
		
		hanSolo = new DoubleSolenoid(0,1);
		hanSolo.set(DoubleSolenoid.Value.kReverse);
		
		intake = new CANTalon(4);
		intake.enableLimitSwitch(true, true);
		
	}
	
    public void initDefaultCommand() 
    {
    }//edit
    
    public void forward()
    {
    	hanSolo.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse()
    {
    	hanSolo.set(DoubleSolenoid.Value.kReverse);
    }

    public void off()
    {
		hanSolo.set(DoubleSolenoid.Value.kOff);
    }

    public boolean lSwitch()
    {
    	return intake.isFwdLimitSwitchClosed();
    }
    
    public void intake()
    {
    	intake.set(.75);
    }

	public void stop() 
	{
		intake.set(0);
	}
}
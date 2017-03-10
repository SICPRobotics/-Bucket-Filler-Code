package org.usfirst.frc.team5822.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

	static CANTalon shootMotor;
	static Timer tele;
	static boolean flag;
	static VictorSP indexer;
	//public static PowerDistributionPanel panel;
	
    public Shooter()
    {
		shootMotor = new CANTalon(2); 
		shootMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
		shootMotor.setPID(1.3, .001, 35, 0.001, 0, 0, 0);
		shootMotor.reverseSensor(true); 
		tele = new Timer();
		indexer = new VictorSP(7);
		//panel = new PowerDistributionPanel();
	
    }

    public static void init()
    {
    	shootMotor.changeControlMode(TalonControlMode.PercentVbus);
       	shootMotor.enable();
    	tele.reset();
		tele.start();
    }
    
    public static void index()
    {
    	indexer.set(1);
    }
    
    public static void shoot()
	{
		if (tele.get()<1)
    	{
			System.out.println("CONTROL MODE: " + shootMotor.getControlMode());
			
    		shootMotor.set(.65);
    	}
		else 
			flag = true; 
		
		if (flag)
		{
			shootMotor.changeControlMode(TalonControlMode.Speed);
			shootMotor.set(8850); 
			shootMotor.reverseSensor(true); 
			shootMotor.enableControl(); //Enable PID control on the talon
			flag = false;
			SmartDashboard.putNumber("Speed", shootMotor.getSpeed());
		}
		


			
		//write the code to run the shooter here
	}
    
    public void stopShooting()
    {
    	shootMotor.disable();
    	shootMotor.set(0);
    	indexer.set(0);
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


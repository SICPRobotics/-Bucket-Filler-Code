/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.ITableListener_WB;
import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The elevator subsystem uses PID to go to a given height. Unfortunately, in
 * it's current state PID values for simulation are different than in the real
 * world do to minor differences.
 */
public class VisionPID extends PIDSubsystem {
	
	static NetworkTable piTable;
	ITableListener_WB piListen = new ITableListener_WB();
	

	//ITableListener_WB piListen = new ITableListener_WB();
	public static boolean gearVision, hGVision; 
	static boolean noVision; 
	double center, tolerance, distance; 
	
	public VisionPID() {
		super(20, 0, 0);
		//setAbsoluteTolerance(0.005);
		
		gearVision = false; 
		hGVision = false; 
		noVision = true;
		//piTable.putBoolean("HGVision Enabled", hGVision); 
		//piTable.putBoolean("Gear Vision Enabled", gearVision); 
		center = 0; 
		tolerance = 0; 
		distance = 0; 

		
	}

	@Override
	public void initDefaultCommand() 
	{
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() 
	{
		
	}

	/**
	 * Use the potentiometer as the PID sensor. This method is automatically
	 * called by the subsystem.
	 */
	@Override
	protected double returnPIDInput()
	{
		/*if (gearVision)
			return piTable.getNumber("Center Gear", 10); 
		else if (hGVision)
			return piTable.getNumber("Center HG", 10); 
		else 
			return 0; */
		System.out.println("USING PID INPUT");
		return 30; 
	}

	public void writeTable()
	{
		NetworkTable.setServerMode();
		piTable = NetworkTable.getTable("piTable"); 
		NetworkTable.setUpdateRate(0.01);
		piListen.setCount(0);
		piTable.addTableListener(piListen, true);
	}
	
	/**
	 * Use the motor as the PID output. This method is automatically called by
	 * the subsystem.
	 */
	@Override
	protected void usePIDOutput(double output) 
	{
		System.out.println("OUTPUT: " + output);
		DriveTrain.setOuts(.2, .2);
		/*
		if (hGVision)
		{
		
			Math.abs(piTable.getNumber("Center HG",10));
			tolerance = (1000/piTable.getNumber("Width HG", 10)); 
			
			if (-tolerance<=center && center<=tolerance)
				drive.setLeftRightMotorOutputs(0, 0);
		
			else 
				drive.setLeftRightMotorOutputs(-.15-(.15*output), -.15+(.15*output));
		}
		
		if (gearVision)
		{
			drive.drive(output, 0);
			System.out.println("Should be driving");
			center =center = Math.abs(piTable.getNumber("Center G",10));
			distance = piTable.getNumber("Distance G",10);
			tolerance = 25+(2*piTable.getNumber("Width G",10)); 
					
			piTable.getBoolean("HG", false);  
			
			if (10<distance && distance<20)
			{
				drive.setLeftRightMotorOutputs(0, 0);
			}
			else if (distance>20)
			{
				drive.setLeftRightMotorOutputs(-.15-(.15*output), -.15+(.15*output));
				System.out.println("FORWARD!");
			}
			
			else if (distance<10)
			{
				drive.setLeftRightMotorOutputs(.15, .15);
				System.out.println("BACKWARD!");
			}*/
			
						
			/*else
			{
				myRobot.setLeftRightMotorOutputs(-.15-(.25)*output, -.15+(.25)*output);
				System.out.println("NOT CENTERED: " +output);
			}*/	
		//}
	}
	
	public static boolean toggleGear()
	{
		gearVision = !gearVision;
		noVision = !noVision; 
		hGVision = false; 
		piTable.putBoolean("HGVision Enabled", hGVision); 
		piTable.putBoolean("Gear Vision Enabled", gearVision); 
		return gearVision; 
	}
	
	public static boolean toggleHG()
	{
		hGVision = !hGVision; 
		noVision = !noVision; 
		gearVision = false; 
		piTable.putBoolean("HGVision Enabled", hGVision); 
		piTable.putBoolean("Gear Vision Enabled", gearVision); 
		return hGVision; 
	}
}


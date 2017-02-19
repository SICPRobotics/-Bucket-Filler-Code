/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5822.robot.subsystems;

import org.usfirst.frc.team5822.robot.ITableListener_WB;
import org.usfirst.frc.team5822.robot.Robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Preferences;
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
	ITableListener_WB piListen;

	public static boolean gearVision, hGVision; 
	static boolean noVision; 
	double center, tolerance, distance; 
	
	public VisionPID() {
		super(.2, 0, 0);
		piListen = new ITableListener_WB();
		setAbsoluteTolerance(0.005);
		
		NetworkTable.setServerMode();
		piTable = NetworkTable.getTable("piTable"); 
		NetworkTable.setUpdateRate(0.01);
		piListen.setCount(0);
		piTable.addTableListener(piListen, true);
		
		gearVision = false; 
		hGVision = false; 
		noVision = true;
		piTable.putBoolean("HGVision Enabled", hGVision); 
		piTable.putBoolean("Gear Vision Enabled", gearVision); 
		center = 0; 
		tolerance = 0; 
		distance = 0; 
		
		Preferences prefs; 
		prefs = Preferences.getInstance(); 
		prefs.putInt("Top H Gear", 0);
		prefs.putInt("Top S Gear", 0);
		prefs.putInt("Top V Gear", 0);
		prefs.putInt("Bottom H Gear", 0);
		prefs.putInt("Bottom S Gear", 0);
		prefs.putInt("Bottom V Gear", 0);
		
		prefs.putInt("Top H HG", 0);
		prefs.putInt("Top S HG", 0);
		prefs.putInt("Top V HG", 0);
		prefs.putInt("Bottom H HG", 0);
		prefs.putInt("Bottom S HG", 0);
		prefs.putInt("Bottom V HG", 0);
		
		/*Thread updateSmartDashBoard = new Thread(() -> { 
		while(!Thread.interrupted())
		{
			piTable.putBoolean("HGVision Enabled", hGVision); 
			piTable.putBoolean("Gear Vision Enabled", gearVision);
			piTable.putNumber("Top H HG", prefs.getInt("Top H HG", 0)); 
			piTable.putNumber("Top S HG", prefs.getInt("Top S HG", 0));
			piTable.putNumber("Top V HG", prefs.getInt("Top V HG", 0));
			piTable.putNumber("Bottom H HG", prefs.getInt("Bottom H HG", 0)); 
			piTable.putNumber("Bottom S HG", prefs.getInt("Bottom S HG", 0));
			piTable.putNumber("Bottom V HG", prefs.getInt("Bottom V HG", 0));
			
			piTable.putNumber("Top H Gear", prefs.getInt("Top H Gear", 0)); 
			piTable.putNumber("Top S Gear", prefs.getInt("Top S Gear", 0));
			piTable.putNumber("Top V Gear", prefs.getInt("Top V Gear", 0));
			piTable.putNumber("Bottom H Gear", prefs.getInt("Bottom H Gear", 0)); 
			piTable.putNumber("Bottom S Gear", prefs.getInt("Bottom S Gear", 0));
			piTable.putNumber("Bottom V Gear", prefs.getInt("Bottom V Gear", 0));
			System.out.println("Running Prefs Thread");
			System.out.println("H for Gear: " + prefs.getInt("Bottom H Gear", 0));
		}
	});
	updateSmartDashBoard.start();*/
	}

	@Override
	public void initDefaultCommand() 
	{
	}

	public void log() 
	{
		
	}

	@Override
	protected double returnPIDInput()
	{
		System.out.println("USING PID INPUT");
		if (gearVision)
		{
			System.out.println("INPUT TO CONTROLLER: " + piTable.getNumber("Center Gear", 0));
			return piTable.getNumber("Center Gear", 0);
		}
		else if (hGVision)
			return piTable.getNumber("Center HG",0); 
		else 
			return 0; 
		
		
	}

		
	/**
	 * Use the motor as the PID output. This method is automatically called by
	 * the subsystem.
	 */
	@Override
	protected void usePIDOutput(double output) 
	{
		System.out.println("OUTPUT: " + output);
		
		/*if (hGVision)
		{
		
			Math.abs(piTable.getNumber("Center HG", 0));
			tolerance = (1000/piTable.getNumber("Width HG", 0)); 
			
			if (-tolerance<=center && center<=tolerance)
				DriveTrain.drive.setLeftRightMotorOutputs(0, 0);
		
			else 
				DriveTrain.drive.setLeftRightMotorOutputs(-(.15*output), +(.15*output));
		} */
		
		if (gearVision)
		{
			//DriveTrain.drive.drive(output, 0);
			
			System.out.println("Should be driving for Gear");
			
			
			center = Math.abs(piTable.getNumber("Center Gear",0));
			distance = piTable.getNumber("Distance Gear",0);
			tolerance = 25+(2*piTable.getNumber("Width Gear",0)); 
			System.out.println("Center: " + center + "; Distance: " + distance + "; Tolerance: " + tolerance);
					
			piTable.getBoolean("HG", false);  
			
			if (10<distance && distance<20)
			{
				DriveTrain.drive.setLeftRightMotorOutputs(0, 0);
			}
			else if (distance>20)
			{
				DriveTrain.drive.setLeftRightMotorOutputs(-.15-(.15*output), -.15+(.15*output));
				System.out.println("FORWARD!");
			}
			
			else if (distance<10)
			{
				DriveTrain.drive.setLeftRightMotorOutputs(.15, .15);
				System.out.println("BACKWARD!");
			}
		}
			
						
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
		System.out.println("TOGGLED GEAR VISION!");
		piTable.putBoolean("HGVision Enabled", hGVision); 
		piTable.putBoolean("Gear Vision Enabled", gearVision);
		piTable.putNumber("Top H HG", Robot.prefs.getInt("Top H HG", 0)); 
		piTable.putNumber("Top S HG", Robot.prefs.getInt("Top S HG", 0));
		piTable.putNumber("Top V HG", Robot.prefs.getInt("Top V HG", 0));
		piTable.putNumber("Bottom H HG", Robot.prefs.getInt("Bottom H HG", 0)); 
		piTable.putNumber("Bottom S HG", Robot.prefs.getInt("Bottom S HG", 0));
		piTable.putNumber("Bottom V HG", Robot.prefs.getInt("Bottom V HG", 0));
		
		piTable.putNumber("Top H Gear", Robot.prefs.getInt("Top H Gear", 0)); 
		piTable.putNumber("Top S Gear", Robot.prefs.getInt("Top S Gear", 0));
		piTable.putNumber("Top V Gear", Robot.prefs.getInt("Top V Gear", 0));
		piTable.putNumber("Bottom H Gear", Robot.prefs.getInt("Bottom H Gear", 0)); 
		piTable.putNumber("Bottom S Gear", Robot.prefs.getInt("Bottom S Gear", 0));
		piTable.putNumber("Bottom V Gear", Robot.prefs.getInt("Bottom V Gear", 0));
		System.out.println("Running Prefs Thread");
		System.out.println("H for Gear: " + Robot.prefs.getInt("Bottom H Gear", 0));
		return gearVision; 
	}
	
	public static boolean toggleHG()
	{
		hGVision = !hGVision; 
		noVision = !noVision; 
		gearVision = false; 
		
		System.out.println("TOGGLED GEAR VISION!");
		piTable.putBoolean("HGVision Enabled", hGVision); 
		piTable.putBoolean("Gear Vision Enabled", gearVision);
		piTable.putNumber("Top H HG", Robot.prefs.getInt("Top H HG", 0)); 
		piTable.putNumber("Top S HG", Robot.prefs.getInt("Top S HG", 0));
		piTable.putNumber("Top V HG", Robot.prefs.getInt("Top V HG", 0));
		piTable.putNumber("Bottom H HG", Robot.prefs.getInt("Bottom H HG", 0)); 
		piTable.putNumber("Bottom S HG", Robot.prefs.getInt("Bottom S HG", 0));
		piTable.putNumber("Bottom V HG", Robot.prefs.getInt("Bottom V HG", 0));
		
		piTable.putNumber("Top H Gear", Robot.prefs.getInt("Top H Gear", 0)); 
		piTable.putNumber("Top S Gear", Robot.prefs.getInt("Top S Gear", 0));
		piTable.putNumber("Top V Gear", Robot.prefs.getInt("Top V Gear", 0));
		piTable.putNumber("Bottom H Gear", Robot.prefs.getInt("Bottom H Gear", 0)); 
		piTable.putNumber("Bottom S Gear", Robot.prefs.getInt("Bottom S Gear", 0));
		piTable.putNumber("Bottom V Gear", Robot.prefs.getInt("Bottom V Gear", 0));
		System.out.println("Running Prefs Thread");
		System.out.println("H for Gear: " + Robot.prefs.getInt("Bottom H Gear", 0));
		return hGVision; 
	}
}


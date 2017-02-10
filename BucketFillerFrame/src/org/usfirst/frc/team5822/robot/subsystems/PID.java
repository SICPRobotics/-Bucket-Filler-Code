/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5822.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The elevator subsystem uses PID to go to a given height. Unfortunately, in
 * it's current state PID values for simulation are different than in the real
 * world do to minor differences.
 */
public class PID extends PIDSubsystem {
	private SpeedController motor;
	private Potentiometer pot;

	private static final double kP_real = 4, kI_real = 0.07;

	public PID() {
		super(kP_real, kI_real, 0);
		setAbsoluteTolerance(0.005);
		motor = new Victor(5);

		// Conversion value of potentiometer varies between the real world and
		// simulation
		pot = new AnalogPotentiometer(2, -2.0 / 5);
		

		// Let's show everything on the LiveWindow
		LiveWindow.addActuator("Elevator", "Motor", (Victor) motor);
		LiveWindow.addSensor("Elevator", "Pot", (AnalogPotentiometer) pot);
		LiveWindow.addActuator("Elevator", "PID", getPIDController());
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
		SmartDashboard.putData("Wrist Pot", (AnalogPotentiometer) pot);
	}

	/**
	 * Use the potentiometer as the PID sensor. This method is automatically
	 * called by the subsystem.
	 */
	@Override
	protected double returnPIDInput()
	{
		return pot.get();
	}

	/**
	 * Use the motor as the PID output. This method is automatically called by
	 * the subsystem.
	 */
	@Override
	protected void usePIDOutput(double d) 
	{
		motor.set(d);
	}
}


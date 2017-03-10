package org.usfirst.frc.team5822.robot;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class SICPRobotDrive extends RobotDrive implements MotorSafety
{

  /**
   * Constructor for RobotDrive with 2 motors specified with channel numbers.
   * Set up parameters for a two wheel drive system where the left and right
   * motor pwm channels are specified in the call. This call assumes Victors for
   * controlling the motors.
   *$
   * @param leftMotorChannel The PWM channel number that drives the left motor.
   * @param rightMotorChannel The PWM channel number that drives the right
   *        motor.
   */
	
	//uses the CANTalons 2.10.17
	
	static VictorSP leftFront, leftRear, rightFront, rightRear; 
	
  public SICPRobotDrive(final int leftMotorChannel, final int rightMotorChannel) 
  {
	  super(new VictorSP (leftMotorChannel), new VictorSP (rightMotorChannel));
	  leftFront = new VictorSP (leftMotorChannel); 
	  rightFront = new VictorSP (rightMotorChannel);
  }

  /**
   * Constructor for RobotDrive with 4 motors specified with channel numbers.
   * Set up parameters for a four wheel drive system where all four motor pwm
   * channels are specified in the call. This call assumes VictorSPs for
   * controlling the motors.
   *$
   * @param frontLeftMotor Front left motor channel number
   * @param rearLeftMotor Rear Left motor channel number
   * @param frontRightMotor Front right motor channel number
   * @param rearRightMotor Rear Right motor channel number
   */
  
  //this passes VictorSPs to the RobotDrive Class! Greta 1.28 
  
  public SICPRobotDrive(final int frontLeftMotor, final int rearLeftMotor, final int frontRightMotor,
      final int rearRightMotor) {

      super(new VictorSP (frontLeftMotor), new VictorSP (rearLeftMotor), new VictorSP (frontRightMotor), new VictorSP (rearRightMotor)); 
      leftFront = new VictorSP (frontLeftMotor);
      rightFront = new VictorSP (frontRightMotor);
      leftRear = new VictorSP (rearLeftMotor);
      rightRear = new VictorSP (rearRightMotor);
   //   setUpMotors(); 
   
  }
//  
//  public void setUpMotors()
//  {
//	  leftFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//	  rightFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//	  leftRear.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//	  rightRear.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//  }

  


}
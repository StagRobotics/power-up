/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import org.usfirst.frc.team1997.robot.Robot;
import org.usfirst.frc.team1997.robot.commands.DriveStraight;
import org.usfirst.frc.team1997.robot.commands.TankDriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	
	private static final double WHEEL_DIAMETER = 7.5;
	private static final double DEADBAND = 0.20;
	
	private SpeedController leftMotor = new Spark(1);
	private SpeedController rightMotor = new Spark(0);
		
	private Encoder leftEncoder = new Encoder(2,3,false, Encoder.EncodingType.k4X);
	private Encoder rightEncoder = new Encoder(0,1,false, Encoder.EncodingType.k4X);
	
	public Gyro gyro = new AnalogGyro(1);
	
	public Timer turningTimer = new Timer();
	
	public DriveTrain() {
		super();

		leftEncoder.setMaxPeriod(1);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(0.00275);
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(7);
		leftEncoder.reset();
		
		rightEncoder.setMaxPeriod(1);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(0.00275);
		rightEncoder.setReverseDirection(false);
		rightEncoder.setSamplesToAverage(7);
		rightEncoder.reset();
				
		//rightMotor.setInverted(true);
		leftMotor.setInverted(true);

		gyro.reset();
		// Let's name the sensors on the LiveWindow
		addChild("Left Encoder", leftEncoder);
		addChild("Right Encoder", rightEncoder);
	}

	/**
	 * When no other command is running let the operator drive around using the
	 * PS3 joystick.
	 */
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Turn test", gyro.getAngle());
		SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
		SmartDashboard.putNumber("Left Inches", getLeftInches());
		SmartDashboard.putNumber("Right Inches", getRightInches());
		SmartDashboard.putNumber("Encoder Difference", leftEncoder.getDistance() - rightEncoder.getDistance());
		
	}

	/**
	 * Tank style driving for the DriveTrain.
	 *
	 * @param left
	 *            Speed in range [-1,1]
	 * @param right
	 *            Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		leftMotor.set(left);
		rightMotor.set(right);
		SmartDashboard.putNumber("Left Wheel Speed", left);
		SmartDashboard.putNumber("Right Wheel Speed", right);
		SmartDashboard.putNumber("Distance", Robot.m_drivetrain.getDistance());
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
		gyro.reset();
	}

	/**
	 * Get the average distance of the encoders since the last reset.
	 *
	 * @return The distance driven (average of left and right encoders).
	 */
	
	public double getDistance() {
		return (((getLeftInches() + getRightInches())) / 2);
		
	}
	
	public double getLeftInches() {
		return leftEncoder.getDistance()*Math.PI*WHEEL_DIAMETER;
	}
	
	public double getRightInches() {
		return rightEncoder.getDistance()*Math.PI*WHEEL_DIAMETER;
	}

	public double getRightDistance() {
		return rightEncoder.getDistance();
	}

	public double getLeftDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
}

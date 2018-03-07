/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot.subsystems;

import org.usfirst.frc.team1997.robot.Robot;
import org.usfirst.frc.team1997.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

	private static final double WHEEL_DIAMETER = 7.5;

	public SpeedController leftMotor = new Spark(5);
	public SpeedController rightMotor = new Spark(4);

	private Encoder leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	private Encoder rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);

	public ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

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

		rightMotor.setInverted(true);
		leftMotor.setInverted(false);

		gyro.reset();

		addChild("Left Encoder", leftEncoder);
		addChild("Right Encoder", rightEncoder);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
	}

	public void log() {
		SmartDashboard.putNumber("SPI Gyro Get Angle", gyro.getAngle());
		SmartDashboard.putNumber("SPI Gyro Get Rate", gyro.getRate());
		SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
		SmartDashboard.putNumber("Left Inches", getLeftInches());
		SmartDashboard.putNumber("Right Inches", getRightInches());
		SmartDashboard.putNumber("Encoder Difference", leftEncoder.getDistance() - rightEncoder.getDistance());
	}

	public void drive(double left, double right) {
		leftMotor.set(left);
		rightMotor.set(right);
		SmartDashboard.putNumber("Left Wheel Speed", left);
		SmartDashboard.putNumber("Right Wheel Speed", right);
		SmartDashboard.putNumber("Distance", Robot.m_drivetrain.getDistance());
	}

	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
		gyro.reset();
	}

	public double getDistance() {
		return (((getLeftInches() + getRightInches())) / 2);
	}

	public double getLeftInches() {
		return leftEncoder.getDistance() * Math.PI * WHEEL_DIAMETER;
	}

	public double getRightInches() {
		return rightEncoder.getDistance() * Math.PI * WHEEL_DIAMETER;
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

	public double getRate() {
		return gyro.getRate();
	}

	public void invertLeftMotor(boolean invertLeftMotor) {
		leftMotor.setInverted(invertLeftMotor);

	}

	public void invertRightMotor(boolean invertRightMotor) {
		rightMotor.setInverted(invertRightMotor);
	}
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot;

import org.usfirst.frc.team1997.robot.commands.AutonomousCenter;
import org.usfirst.frc.team1997.robot.commands.AutonomousDriveStraight;
import org.usfirst.frc.team1997.robot.commands.AutonomousLeft;
import org.usfirst.frc.team1997.robot.commands.AutonomousLeftOnly;
import org.usfirst.frc.team1997.robot.commands.AutonomousNoAuto;
import org.usfirst.frc.team1997.robot.commands.AutonomousRight;
import org.usfirst.frc.team1997.robot.commands.AutonomousRightOnly;
import org.usfirst.frc.team1997.robot.commands.Wait;
import org.usfirst.frc.team1997.robot.subsystems.Arm;
import org.usfirst.frc.team1997.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1997.robot.subsystems.LED;
import org.usfirst.frc.team1997.robot.subsystems.Wing;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	Command autoCommand = new Wait(15);
	SendableChooser<Command> autoChooser = new SendableChooser<Command>();
	public static DriveTrain m_drivetrain;
	public static Wing m_wing;
	public static Arm m_arm;
	public static LED m_led;
	public static OI m_oi;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Initialize all subsystems

		m_drivetrain = new DriveTrain();
		m_wing = new Wing();
		m_arm = new Arm();
		m_led = new LED();
		m_oi = new OI();

		autoChooser.addDefault("Do Nothing", new AutonomousNoAuto());
		autoChooser.addObject("Cross Auto Line ONLY", new AutonomousDriveStraight());
		autoChooser.addObject("Left Auto (try for either plate)", new AutonomousLeft());
		autoChooser.addObject("Right Auto (try for either plate)", new AutonomousRight());
		autoChooser.addObject("Left Auto (try for left plate or cross)", new AutonomousLeftOnly());
		autoChooser.addObject("Right Auto (try for right plate or cross)", new AutonomousRightOnly());
		autoChooser.addObject("Center Auto", new AutonomousCenter());

		SmartDashboard.putData(autoChooser);

		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData(m_drivetrain);
		m_drivetrain.gyro.calibrate();
		CameraServer.getInstance().startAutomaticCapture();

		// setting pneumatics off to begin
		m_arm.lowerArm();
		m_arm.kickerIn();
		m_arm.jawDown();

	}

	@Override
	public void autonomousInit() {
		autoCommand = autoChooser.getSelected();
		autoCommand.start();

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		if (autoCommand.isRunning())
			autoCommand.cancel();
	}

	/**
	 * This function is called periodically during teleoperated mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void robotPeriodic() {

	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	private void log() {
		m_drivetrain.log();
	}
}

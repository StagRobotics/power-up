/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1997.robot.commands.AutonomousNoAuto;
import org.usfirst.frc.team1997.robot.commands.AutonomousDriveStraight;
import org.usfirst.frc.team1997.robot.commands.AutonomousTestLeft;
import org.usfirst.frc.team1997.robot.commands.AutonomousTestRight;
import org.usfirst.frc.team1997.robot.subsystems.Arm;
import org.usfirst.frc.team1997.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1997.robot.subsystems.Wing;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	Command autoCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<Command>();
	public static DriveTrain m_drivetrain;
	public static Wing m_wing;
	public static Arm m_arm;
	public static OI m_oi;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Initialize all subsystems
	
		m_drivetrain = new DriveTrain();
		m_wing = new Wing();
		m_arm = new Arm();
		m_oi = new OI();

		autoChooser.addDefault("Do Nothing", new AutonomousNoAuto());
		autoChooser.addObject("Cross Auto Line ONLY", new AutonomousDriveStraight());
		autoChooser.addObject("Left Auto", new AutonomousTestLeft());
		autoChooser.addObject("Right Auto", new AutonomousTestRight());
		
		SmartDashboard.putData(autoChooser);
		
		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData(m_drivetrain);
		m_drivetrain.gyro.calibrate();
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
		//m_autonomousCommand.cancel();
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

package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InvertMotors extends Command {

	public InvertMotors() {
		requires(Robot.m_drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.m_drivetrain.rightMotor.getInverted()) {
			Robot.m_drivetrain.rightMotor.setInverted(false);
			Robot.m_drivetrain.leftMotor.setInverted(true);
		} else {
			Robot.m_drivetrain.rightMotor.setInverted(true);
			Robot.m_drivetrain.leftMotor.setInverted(false);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

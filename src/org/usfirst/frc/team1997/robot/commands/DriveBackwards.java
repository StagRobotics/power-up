package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveBackwards extends Command {

	double driveTimer = 0;
	double driveSpeed = 0;
	private Timer Timer = new Timer();

	public DriveBackwards(double speed, double time) {
		requires(Robot.m_drivetrain);
		driveSpeed = speed;
		driveTimer = time;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Timer.reset();
		Timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.m_drivetrain.leftMotor.set(-driveSpeed);
		Robot.m_drivetrain.rightMotor.set(-driveSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Timer.get() > driveTimer) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	private Timer timer = new Timer();

	private double leftDriveSpeed = .42;
	private double rightDriveSpeed = .40;

	private double driveDistance = 0.0;
	private double encoderDifference = 0.0;
	private double leftCorrectionRatio = 1.0;
	private double rightCorrectionRatio = 1.0;

	public DriveStraight(double distance) {
		requires(Robot.m_drivetrain);
		driveDistance = distance;
	}

	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.m_drivetrain.reset();
		timer.reset();
		timer.start();
	}

	protected void execute() {

		Robot.m_drivetrain.drive(leftDriveSpeed * leftCorrectionRatio, rightDriveSpeed * rightCorrectionRatio);

		encoderDifference = Robot.m_drivetrain.getLeftDistance() - Robot.m_drivetrain.getRightDistance();

		if (encoderDifference > 0.0) {

			leftCorrectionRatio = Robot.m_drivetrain.getRightDistance() / Robot.m_drivetrain.getLeftDistance();
			rightCorrectionRatio = 1.0;

		} else if (encoderDifference < 0.0) {

			rightCorrectionRatio = Robot.m_drivetrain.getLeftDistance() / Robot.m_drivetrain.getRightDistance();
			leftCorrectionRatio = 1.0;

		} else {
			leftCorrectionRatio = 1.0;
			rightCorrectionRatio = 1.0;
		}
	}

	protected boolean isFinished() {
		return Robot.m_drivetrain.getDistance() >= driveDistance;
	}

	protected void end() {
		Robot.m_drivetrain.drive(0.0, 0.0);
		Robot.m_drivetrain.reset();
	}

	protected void interrupted() {
		Robot.m_drivetrain.drive(0.0, 0.0);
	}
}

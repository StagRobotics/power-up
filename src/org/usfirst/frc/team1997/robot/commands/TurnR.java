package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnR extends Command {

	private double turnAngle;

	private double leftTurnSpeed = 1.0;
	private double rightTurnSpeed = 1.0;
	private double leftCorrectionRatio = 1.0;
	private double rightCorrectionRatio = 1.0;
	private double workAngle = 0.0;

	public TurnR(double Angle) {
		requires(Robot.m_drivetrain);
		turnAngle = Angle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.m_drivetrain.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.m_drivetrain.drive(leftTurnSpeed * leftCorrectionRatio, -(rightTurnSpeed * rightCorrectionRatio));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		workAngle = Robot.m_drivetrain.getAngle();

		if (Math.abs(workAngle) > (Math.abs(turnAngle * 0.80)) && rightTurnSpeed > 0.3 && leftTurnSpeed > 0.3) {
			leftTurnSpeed = leftTurnSpeed - 0.1;
			rightTurnSpeed = rightTurnSpeed - 0.1;

		}

		if (Math.abs(workAngle) < Math.abs(turnAngle)) {
			return false;
		} else {
			return true;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0.0, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0.0, 0.0);
	}
}

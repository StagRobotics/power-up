package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleArm extends Command {

	public ToggleArm() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.m_arm.getArmState().equals("lifted")) {
			Robot.m_arm.lowerArm();
			Robot.m_arm.toggleArmState();
		} else if (Robot.m_arm.getArmState().equals("lowered")) {
			Robot.m_arm.liftArm();
			Robot.m_arm.toggleArmState();
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

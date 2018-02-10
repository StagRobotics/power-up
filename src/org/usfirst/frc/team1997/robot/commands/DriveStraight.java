package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1997.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class DriveStraight extends Command {

	private Timer timer = new Timer();
	private int count = 0;
	
	private double leftDriveSpeed = .39;
	private double rightDriveSpeed = .35;
	
	private double driveDistance = 0;
	private double encoderDifference = 0;
	private double leftCorrectionRatio = 1;
	private double rightCorrectionRatio = 1;
	
	public DriveStraight(double distance) {
		requires(Robot.m_drivetrain);
		driveDistance = distance;
	}

	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.m_drivetrain.reset();
		timer.reset();
		timer.start();
		count = 0;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected void execute() {
	
		Robot.m_drivetrain.drive(leftDriveSpeed * leftCorrectionRatio, rightDriveSpeed * rightCorrectionRatio);
		
		encoderDifference = Robot.m_drivetrain.getLeftDistance() - Robot.m_drivetrain.getRightDistance();
		
		if(encoderDifference > 0) {
			
			leftCorrectionRatio = Robot.m_drivetrain.getRightDistance()/Robot.m_drivetrain.getLeftDistance();
			rightCorrectionRatio = 1.0;
			
		}else if(encoderDifference < 0) {
			
			rightCorrectionRatio = Robot.m_drivetrain.getLeftDistance()/Robot.m_drivetrain.getRightDistance();
			leftCorrectionRatio = 1.0;
			
		}else {
    		leftCorrectionRatio = 1;
    		rightCorrectionRatio= 1;
    	}
		
		
	}
	
	protected boolean isFinished() {
		return Robot.m_drivetrain.getDistance() >= driveDistance;
	}
	
	protected void end() {
		// Stop PID and the wheels
		//Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0, 0);
		Robot.m_drivetrain.reset();
	}
	protected void interrupted() {
    	//Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0, 0);
    }
}

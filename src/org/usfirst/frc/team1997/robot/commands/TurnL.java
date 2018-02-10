package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnL extends Command {

	private double turnAngle;
	
	private double encoderTotal = 0;
	private double leftTurnSpeed = .35;
	private double rightTurnSpeed = .36;
	private double leftCorrectionRatio = 1;
	private double rightCorrectionRatio = 1; 
	
		public TurnL(double Angle) {
			requires(Robot.m_drivetrain);
			turnAngle = Angle;
       }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.m_drivetrain.reset();
    	Robot.m_drivetrain.turningTimer.reset();
    	Robot.m_drivetrain.turningTimer.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Turning Left", -Robot.m_drivetrain.getAngle());
    	SmartDashboard.putNumber("Encoder total", encoderTotal);
    	SmartDashboard.putNumber("Left Distance turn", Robot.m_drivetrain.getLeftDistance());
    	
    	Robot.m_drivetrain.drive(-(leftTurnSpeed*leftCorrectionRatio), rightTurnSpeed*rightCorrectionRatio);
    	encoderTotal = Robot.m_drivetrain.getLeftDistance()+Robot.m_drivetrain.getRightDistance();
    	
    	SmartDashboard.putNumber("Rotation", Robot.m_drivetrain.gyro.getRate()*Robot.m_drivetrain.turningTimer.get());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(turnAngle > 0) {
    		return -Robot.m_drivetrain.getAngle() >= turnAngle;
    	}
    	else if (turnAngle < 0) {
    		return Robot.m_drivetrain.getAngle() >= turnAngle;
    	} else {
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.m_drivetrain.reset();
		Robot.m_drivetrain.drive(0, 0);
    }
}

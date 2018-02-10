package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {

	
	private Timer wait_timer = new Timer();
	private double stopTime = 0;
    // Called just before this Command runs the first time
    
	public Wait(double seconds) {
		stopTime = seconds;
	}
	
	protected void initialize() {
    	wait_timer.reset();
    	wait_timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return wait_timer.get() >= stopTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

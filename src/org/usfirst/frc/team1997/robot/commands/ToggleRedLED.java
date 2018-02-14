package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRedLED extends Command {

    public ToggleRedLED() {
       requires(Robot.m_led);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.m_led.getRedLEDState() == "off") {
    		Robot.m_led.redLEDON();
    		Robot.m_led.toggleRedLEDState();
    	}else if (Robot.m_led.getRedLEDState() == "on") {
    		Robot.m_led.redLEDOFF();
    		Robot.m_led.toggleRedLEDState();
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

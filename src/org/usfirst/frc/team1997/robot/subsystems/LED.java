package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LED extends Subsystem {

	private Relay redLED = new Relay(0);
	private Relay blueLED = new Relay(1);
	
	private String stateOfRedLED = "off";
	private String stateOfBlueLED = "on";
	
	public void redLEDON() {
		redLED.set(Relay.Value.kForward);
	}
	public void redLEDOFF() {
		redLED.set(Relay.Value.kOff);
	}
	public void toggleRedLEDState() {
		if(stateOfRedLED == "off") {
			stateOfRedLED = "on";
		}
		else if(stateOfRedLED == "on") {
			stateOfRedLED = "off";
		}
	}
	public void blueLEDON() {
		blueLED.set(Relay.Value.kForward);
	}
	public void blueLEDOFF() {
		blueLED.set(Relay.Value.kOff);
	}
	public void toggleBlueLEDState() {
		if(stateOfBlueLED == "off") {
			stateOfBlueLED = "on";
		}
		else if(stateOfBlueLED == "on") {
			stateOfBlueLED = "off";
		}
	}
	public String getBlueLEDState() {
		return stateOfBlueLED;
	}
	
	
	
	public String getRedLEDState() {
		return stateOfRedLED;
	}
    public void initDefaultCommand() {
        
    }
}


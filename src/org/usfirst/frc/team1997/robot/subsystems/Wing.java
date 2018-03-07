package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wing extends Subsystem {

	private DoubleSolenoid wing = new DoubleSolenoid(6, 7);
	private Relay latch = new Relay(3);

	public void initDefaultCommand() {

	}

	public void wingOut() {
		wing.set(DoubleSolenoid.Value.kForward);
	}

	public void off() {
		wing.set(DoubleSolenoid.Value.kOff);
	}

	public void wingIn() {
		wing.set(DoubleSolenoid.Value.kReverse);
	}

	public void latch() {
		latch.set(Relay.Value.kForward);
	}

	public void unlatch() {
		latch.set(Relay.Value.kReverse);
	}

	public void latchOff() {
		latch.set(Relay.Value.kOff);
	}

}
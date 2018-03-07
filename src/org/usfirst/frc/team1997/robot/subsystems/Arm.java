package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {

	private DoubleSolenoid arm = new DoubleSolenoid(0, 1);
	private DoubleSolenoid jaw = new DoubleSolenoid(4, 5);
	private DoubleSolenoid kicker = new DoubleSolenoid(2, 3);

	private String jawState = "down";
	private String kickerState = "in";
	private String armState = "lowered";

	public void toggleJawState() {
		if (jawState.equals("up")) {
			jawState = "down";
		} else if (jawState.equals("down")) {
			jawState = "up";
		}
	}

	public void toggleArmState() {
		if (armState.equals("lifted")) {
			armState = "lowered";
		} else if (armState.equals("lowered")) {
			armState = "lifted";
		}
	}

	public void toggleKickState() {
		if (kickerState.equals("in")) {
			kickerState = "out";
		} else if (kickerState.equals("out")) {
			kickerState = "in";
		}
	}

	public String getArmState() {
		return armState;
	}

	public String getKickerState() {
		return kickerState;
	}

	public String getJawState() {
		return jawState;
	}

	public void liftArm() {
		arm.set(DoubleSolenoid.Value.kForward);
	}

	public void lowerArm() {
		arm.set(DoubleSolenoid.Value.kReverse);
	}

	public void disArm() {
		arm.set(DoubleSolenoid.Value.kOff);
	}

	public void kickerOut() {
		kicker.set(DoubleSolenoid.Value.kForward);
	}

	public void kickerIn() {
		kicker.set(DoubleSolenoid.Value.kReverse);
	}

	public void kickerOff() {
		kicker.set(DoubleSolenoid.Value.kOff);
	}

	public void jawDown() {
		jaw.set(DoubleSolenoid.Value.kForward);
	}

	public void jawUp() {
		jaw.set(DoubleSolenoid.Value.kReverse);
	}

	public void jawOff() {
		jaw.set(DoubleSolenoid.Value.kOff);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}

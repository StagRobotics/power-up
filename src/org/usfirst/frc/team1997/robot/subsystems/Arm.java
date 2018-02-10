package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    private DoubleSolenoid armLift = new DoubleSolenoid(6,7);
    private DoubleSolenoid armTop = new DoubleSolenoid(4,5);
    private DoubleSolenoid armKick = new DoubleSolenoid(2,3);
    
    private String armState = "up";
    
    public void toggleState() {
    	if(armState.equals("up")) {
    		armState = "down";
    	}
    	else if(armState.equals("down")) {
    		armState = "up";
    	}
    }
    
    public String getState() {
    	return armState;
    }
    
    public void liftArm() {
    	armLift.set(DoubleSolenoid.Value.kReverse);
    }
    public void lowerArm() {
    	armLift.set(DoubleSolenoid.Value.kForward);
    }
    public void kickOut() {
    	armKick.set(DoubleSolenoid.Value.kForward);
    }
    public void kickIn() {
    	armKick.set(DoubleSolenoid.Value.kReverse);
    }
    public void topDown() {
    	armTop.set(DoubleSolenoid.Value.kForward);
    }
    public void topUp() {
    	armTop.set(DoubleSolenoid.Value.kReverse);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    
    
}


package org.usfirst.frc.team1997.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wing extends Subsystem {

   private DoubleSolenoid wing = new DoubleSolenoid(6, 7);
   
    public void initDefaultCommand() {
    	off();
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
}


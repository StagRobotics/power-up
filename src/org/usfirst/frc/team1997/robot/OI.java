/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1997.robot.commands.AutonomousTestLeft;
import org.usfirst.frc.team1997.robot.commands.AutonomousTestRight;
import org.usfirst.frc.team1997.robot.commands.DriveStraight;
import org.usfirst.frc.team1997.robot.commands.Kick;
import org.usfirst.frc.team1997.robot.commands.KickIn;
import org.usfirst.frc.team1997.robot.commands.KickOut;
import org.usfirst.frc.team1997.robot.commands.LiftArm;
import org.usfirst.frc.team1997.robot.commands.LowerArm;
import org.usfirst.frc.team1997.robot.commands.ToggleBlueLED;
import org.usfirst.frc.team1997.robot.commands.ToggleRedLED;
import org.usfirst.frc.team1997.robot.commands.ToggleTop;
import org.usfirst.frc.team1997.robot.commands.TurnL;
import org.usfirst.frc.team1997.robot.commands.TurnR;
import org.usfirst.frc.team1997.robot.commands.WingLift;
import org.usfirst.frc.team1997.robot.commands.WingOut;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	private Joystick leftJoystick = new Joystick(0);
	private Joystick rightJoystick = new Joystick(1);
	private Joystick auxJoystick = new Joystick(2);
	
	public double speed = 0.25;
	
	public double getSpeed() {return speed;}

	public OI() {
		
		SmartDashboard.putData("Drive 5 Feet", new DriveStraight(60));
		SmartDashboard.putData("Drive 10 Feet", new DriveStraight(120));
		SmartDashboard.putData("Drive 20 Feet", new DriveStraight(240));
		SmartDashboard.putData("Drive train Left", new AutonomousTestLeft());
		SmartDashboard.putData("Drive train Right", new AutonomousTestRight());
		SmartDashboard.putData("WingOut", new WingOut());
		SmartDashboard.putData("WingIn", new WingLift());
		SmartDashboard.putData("Kick", new Kick());
		SmartDashboard.putData("Lift Arm", new LiftArm());
		SmartDashboard.putData("Lower Arm", new LowerArm());
		SmartDashboard.putData("Kicker In", new KickOut());
		SmartDashboard.putData("ToggleTop", new ToggleTop());
		
		
		JoystickButton WingIn = new JoystickButton(leftJoystick, 1);
		JoystickButton WingOut = new JoystickButton(rightJoystick, 1);
		
		JoystickButton armToggle = new JoystickButton(auxJoystick, 1);
		JoystickButton upperArm = new JoystickButton(auxJoystick, 2);
		JoystickButton kick = new JoystickButton(auxJoystick, 3);
		
		JoystickButton redLEDToggle = new JoystickButton(auxJoystick, 5);
		JoystickButton blueLEDToggle = new JoystickButton(auxJoystick,6);
		
		redLEDToggle.whenPressed(new ToggleRedLED());
		blueLEDToggle.whenPressed(new ToggleBlueLED());
		
		WingOut.whenPressed(new WingOut());
		WingIn.whenPressed(new WingLift());
		
		upperArm.whenPressed(new ToggleTop());
		
		kick.whenPressed(new Kick());
		
		if(armToggle.get() && auxJoystick.getY() > 0.4 ) {
			new LiftArm();
		}
		if(armToggle.get() && auxJoystick.getY() < -0.4) {
			new LowerArm();
		}		
	}
	
	public Joystick getLeftJoystick( ) {
		return leftJoystick;
	}
	
	public Joystick getRightJoystick() {
		return rightJoystick;
	}
	
}

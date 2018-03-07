/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1997.robot;

import org.usfirst.frc.team1997.robot.commands.AutonomousLeft;
import org.usfirst.frc.team1997.robot.commands.AutonomousRight;
import org.usfirst.frc.team1997.robot.commands.DriveStraight;
import org.usfirst.frc.team1997.robot.commands.InvertMotors;
import org.usfirst.frc.team1997.robot.commands.KickIn;
import org.usfirst.frc.team1997.robot.commands.Latch;
import org.usfirst.frc.team1997.robot.commands.LatchOff;
import org.usfirst.frc.team1997.robot.commands.LiftArm;
import org.usfirst.frc.team1997.robot.commands.LowerArm;
import org.usfirst.frc.team1997.robot.commands.ToggleArm;
import org.usfirst.frc.team1997.robot.commands.ToggleJaw;
import org.usfirst.frc.team1997.robot.commands.ToggleKick;
import org.usfirst.frc.team1997.robot.commands.WingLift;
import org.usfirst.frc.team1997.robot.commands.WingOut;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	private Joystick leftJoystick = new Joystick(0);
	private Joystick rightJoystick = new Joystick(1);
	private Joystick auxJoystick = new Joystick(2);

	public double speed = 0.25;

	public double getSpeed() {
		return speed;
	}

	public OI() {

		SmartDashboard.putData("Drive 5 Feet", new DriveStraight(60));
		SmartDashboard.putData("Drive 10 Feet", new DriveStraight(120));
		SmartDashboard.putData("Drive 20 Feet", new DriveStraight(240));
		SmartDashboard.putData("Drive train Left", new AutonomousLeft());
		SmartDashboard.putData("Drive train Right", new AutonomousRight());
		SmartDashboard.putData("WingOut", new WingOut());
		SmartDashboard.putData("WingIn", new WingLift());
		SmartDashboard.putData("Lift Arm", new LiftArm());
		SmartDashboard.putData("Lower Arm", new LowerArm());
		SmartDashboard.putData("Kicker In", new KickIn());
		SmartDashboard.putData("ToggleTop", new ToggleJaw());
		SmartDashboard.putData("TO INVERT MOTORS PRESS START", new InvertMotors());

		CameraServer.getInstance().startAutomaticCapture();

		JoystickButton WingIn = new JoystickButton(rightJoystick, 1);
		JoystickButton WingOut = new JoystickButton(leftJoystick, 1);
		JoystickButton latch = new JoystickButton(rightJoystick, 4);

		JoystickButton armToggle = new JoystickButton(auxJoystick, 1);
		JoystickButton upperArm = new JoystickButton(auxJoystick, 2);
		JoystickButton kickToggle = new JoystickButton(auxJoystick, 3);

		WingOut.whenPressed(new WingOut());
		WingIn.whenPressed(new WingLift());

		latch.whenPressed(new Latch());
		latch.whenInactive(new LatchOff());

		upperArm.whenPressed(new ToggleJaw());
		kickToggle.whenPressed(new ToggleKick());
		armToggle.whenPressed(new ToggleArm());

	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}

}

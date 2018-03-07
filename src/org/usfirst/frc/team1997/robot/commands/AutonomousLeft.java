package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeft extends CommandGroup {
	public AutonomousLeft() {

		DriverStation driverStation = DriverStation.getInstance();
		String gameMessage = driverStation.getGameSpecificMessage();

		if (gameMessage.charAt(0) == 'L') {
			addSequential(new DriveStraight(126.0));
			addSequential(new TurnR(90.0));
			addSequential(new Drive(0.5, 0.2));
			addSequential(new Wait(1.5));
			addSequential(new DropCube());
		} else {
			addSequential(new DriveStraight(180.0));
			addSequential(new TurnR(90.0));
			addSequential(new DriveStraight(135.0));
			addSequential(new TurnR(90.0));
			addSequential(new DriveStraight(12.0));
			addSequential(new DropCube());
		}
	}
}
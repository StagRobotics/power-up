package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCenter extends CommandGroup {

	public AutonomousCenter() {
		DriverStation driverStation = DriverStation.getInstance();
		String gameMessage = driverStation.getGameSpecificMessage();
		if (gameMessage.charAt(0) == 'L') {
			addSequential(new TurnL(20.0));
			addSequential(new DriveStraight(30.0));
			addSequential(new TurnL(90.0));
			addSequential(new DriveStraight(45.0));
			addSequential(new TurnR(90.0));
			addSequential(new DriveStraight(45.0));
			addSequential(new DropCube());
		} else {
			addSequential(new DriveStraight(84.0));
			addSequential(new DropCube());
		}
	}
}

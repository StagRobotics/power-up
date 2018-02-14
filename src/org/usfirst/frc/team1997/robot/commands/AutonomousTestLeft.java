package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestLeft extends CommandGroup {
   public AutonomousTestLeft() {
	DriverStation driverStation = DriverStation.getInstance();
	String gameMessage = driverStation.getGameSpecificMessage();
	
	if(gameMessage.charAt(0) == 'L') {
		addSequential(new DriveStraight(132));
    	addSequential(new Wait(1));
    	addSequential(new TurnR(20));
    	addSequential(new Wait(1));
    	addSequential(new DriveStraight(12));
	}else {
		addSequential(new DriveStraight(180));
    	addSequential(new Wait(1));
    	addSequential(new TurnR(20));
    	addSequential(new Wait(1));
    	addSequential(new DriveStraight(121));
    	addSequential(new Wait(1));
    	addSequential(new TurnR(20));
		addSequential(new Wait(1));	
	}
   }
}
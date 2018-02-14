package org.usfirst.frc.team1997.robot.commands;

import org.usfirst.frc.team1997.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousTestRight extends CommandGroup {
    public AutonomousTestRight() {
    	
    	DriverStation driverStation = DriverStation.getInstance();
    	String gameMessage = driverStation.getGameSpecificMessage();
    	
    	if(gameMessage.charAt(0) == 'R') {
    		addSequential(new DriveStraight(132));
        	addSequential(new Wait(1));
        	addSequential(new TurnL(20));
        	addSequential(new Wait(1));
        	addSequential(new DriveStraight(12));
    	}else {
    		addSequential(new DriveStraight(180));
        	addSequential(new Wait(1));
        	addSequential(new TurnL(20));
        	addSequential(new Wait(1));
        	addSequential(new DriveStraight(121));
        	addSequential(new Wait(1));
        	addSequential(new TurnL(20));
    		addSequential(new Wait(1));	
    	}
    }
}
package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTestLeft extends CommandGroup {

    public AutonomousTestLeft() {
    	addSequential(new DriveStraight(132));
    	addSequential(new Wait(1));
    	addSequential(new TurnR(25));
    	addSequential(new Wait(1));
    	addSequential(new DriveStraight(12));
    }

	
}

package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveStraight extends CommandGroup {
    public AutonomousDriveStraight() {
    	addSequential(new DriveStraight(130));
    }
}

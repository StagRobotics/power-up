package org.usfirst.frc.team1997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropCube extends CommandGroup {

	public DropCube() {
		addSequential(new ToggleJaw());
		addSequential(new Wait(1.5));
		addSequential(new ToggleKick());
		addSequential(new Wait(2.0));
		addSequential(new ToggleKick());
	}
}

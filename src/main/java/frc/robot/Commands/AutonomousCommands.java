package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.Autonomous.MeasuredRotate;
import frc.robot.Commands.misc.UpdateDashValues;

public class AutonomousCommands extends CommandGroup {
    public AutonomousCommands(){
        addSequential(new MeasuredRotate(180));
        addSequential(new MeasuredRotate(0));

    }
}

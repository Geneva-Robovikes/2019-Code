package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.misc.UpdateDashValues;

public class AlwaysOn extends CommandGroup {
    public AlwaysOn(){
        addParallel(new UpdateDashValues());
    }
}

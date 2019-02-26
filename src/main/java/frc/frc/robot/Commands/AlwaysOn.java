package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.misc.UpdateDashValues;
import frc.robot.Commands.misc.lightTest;

public class AlwaysOn extends CommandGroup {
    public AlwaysOn(){
        addParallel(new UpdateDashValues());
        addParallel(new lightTest());
    }
}

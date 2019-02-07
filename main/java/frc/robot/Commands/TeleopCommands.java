package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Commands.drive.driveOmniPowered;
import frc.robot.Commands.misc.UpdateDashValues;

public class TeleopCommands extends CommandGroup {
    public TeleopCommands(){
        //System.out.println("TeleopCommannds started");
        addParallel(new driveOmniPowered());
        //System.out.println("driveOmniPowered created");
    }
}

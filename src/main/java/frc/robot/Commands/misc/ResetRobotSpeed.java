package frc.robot.Commands.misc;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;

import static frc.robot.Robot.dash;

public class ResetRobotSpeed extends Command {
    @Override
    protected void initialize() {
        dash.sbTeleSpeed.setDouble(Constants.kDefaultTeleSpeed);
        dash.sbTurnSpeed.setDouble(Constants.kDefaultTurnSpeed);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}

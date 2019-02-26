package frc.robot.Commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Subsystems.Drive;
import static frc.robot.Constants.*;
import static frc.robot.Robot.*;

public class driveTank extends Command {
    public double TeleSpeed, TurnSpeed;
    public driveTank(){
        requires(drive);
    }
    @Override
    protected void initialize() {
        TeleSpeed = dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        TurnSpeed = dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
    }
    @Override
    protected void execute() {
        TeleSpeed = dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        TurnSpeed = dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
        drive.talLF.set(TeleSpeed * -stick.getDY() + TurnSpeed * stick.getDZ());
        drive.talLB.set(TeleSpeed * -stick.getDY() + TurnSpeed * stick.getDZ());
        drive.talLF.set(TeleSpeed * stick.getDY() + TurnSpeed * stick.getDZ());
        drive.talRB.set(TeleSpeed * stick.getDY() + TurnSpeed * stick.getDZ());
    }
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override

    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        super.end();
    }
}

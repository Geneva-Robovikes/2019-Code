package frc.robot.Commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Subsystems.Drive;

import static frc.robot.Constants.*;
import static frc.robot.Robot.*;

public class driveOmniPowered extends Command {
    public double TeleSpeed, TurnSpeed;
    public driveOmniPowered(){
        super("driveOmniPowered");
        requires(drive);
        //System.out.println("hggdsfsddlfjsdjfdlk");
    }
    @Override
    protected void initialize() {
        TeleSpeed = dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        TurnSpeed = dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
        //System.out.println("driveOmniPowered started");
    }
    @Override
    protected void execute() {
        TeleSpeed = dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        TurnSpeed = dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
        //drive.driveOmni();
        drive.talLF.set(TeleSpeed * -stick.getDY());
        drive.talLB.set(TeleSpeed * -stick.getDY() + TurnSpeed * stick.getDZ());
        drive.talRF.set(TeleSpeed * stick.getDY());
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

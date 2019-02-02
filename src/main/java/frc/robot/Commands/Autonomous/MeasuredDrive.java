package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;

import static frc.robot.Robot.dash;
import static frc.robot.Robot.drive;

public class MeasuredDrive extends Command {
    public MeasuredDrive(){
        super("MeasuredRotate");
        requires(drive);
    }
    @Override
    protected void initialize() {

    }
    @Override
    protected void execute() {

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

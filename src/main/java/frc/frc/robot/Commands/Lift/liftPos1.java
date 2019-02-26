package frc.robot.Commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.*;

public class liftPos1 extends Command {
    public liftPos1(){
        super("liftPos1");
        requires(lift);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        super.execute();
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

package frc.robot.Commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.*;

public class liftPivot extends Command {
    public liftPivot(){
        super("liftPivot");
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
        super.interrupted();
    }

    @Override
    protected void end() {
        super.end();
    }
}

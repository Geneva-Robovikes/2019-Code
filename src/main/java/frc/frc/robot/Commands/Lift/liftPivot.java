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
    }

    @Override
    protected void execute() {
        lift.liftPivotSol.set(!lift.liftPivotSol.get());
    }

    @Override
    protected boolean isFinished() {
        return true;
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

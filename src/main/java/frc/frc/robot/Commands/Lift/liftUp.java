package frc.robot.Commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import static frc.robot.Robot.*;

public class liftUp extends Command {

    private double liftSpeed;
    private int x;

    public liftUp(){
        super("liftUp");
        requires(lift);

    }

    @Override
    protected void initialize() {
        x=0;
        liftSpeed = stick.getSlider();
    }

    @Override
    protected void execute(){
        x++;
        lift.liftTalonStage1.set(liftSpeed);
        lift.liftTalonStage2.set(liftSpeed);

    }

    @Override
    protected boolean isFinished(){
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

package frc.robot.Commands.Grabber;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.*;
public class grabberOpen extends Command {
    public grabberOpen(){
        super("grabberOpen");
        requires(grabber);
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

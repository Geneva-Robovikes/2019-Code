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
        grabber.grabberSol1.set(true);
        grabber.grabberSol2.set(true);
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

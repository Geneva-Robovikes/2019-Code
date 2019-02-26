package frc.robot.Commands.Grabber;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.*;
public class grabberClose extends Command {
    public grabberClose(){
        super("grabberClose");
        requires(grabber);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        grabber.grabberSol1.set(false);
        grabber.grabberSol2.set(false);
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

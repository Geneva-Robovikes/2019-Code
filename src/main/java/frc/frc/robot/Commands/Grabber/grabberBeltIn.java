package frc.robot.Commands.Grabber;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;

import static frc.robot.Robot.*;

public class grabberBeltIn extends Command {
    private double speed;

    public grabberBeltIn(){
        super("grabberBeltIn");
        requires(grabber);
    }

    @Override
    protected void initialize() {
        speed = Constants.kGrabberSpeed;
    }

    @Override
    protected void execute() {
        grabber.grabberTalon.set(speed);
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

package frc.robot.Commands.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;

import static frc.robot.Robot.dash;
import static frc.robot.Robot.drive;

public class MeasuredRotate extends Command {
    private boolean finished;
    private int endDegrees;
    private double startDegrees;
    private double dist;
    public double TurnSpeed;
    public MeasuredRotate(int targetDegrees){
        super("MeasuredRotate");
        requires(drive);
        endDegrees = targetDegrees;
        finished = false;
        startDegrees = drive.getGyroAngle();
        dist = endDegrees - startDegrees;
    }
    @Override
    protected void initialize() {

    }
    @Override
    protected void execute() {
        TurnSpeed = dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
        if((dist > 180) || ((-180 < dist) && (dist < 0)) ){
            //rotate counter-clockwise
            if(Math.round(endDegrees) != Math.round(drive.getGyroAngle())){
                System.out.println("Spinning counter-clockwise with target:  " + endDegrees);
                drive.talLB.set(-.3);
                drive.talRB.set(-.3);
            } else{
                finished = true;
            }

        } else {
            //rotate clockwise
            if (Math.round(endDegrees) != Math.round(drive.getGyroAngle())) {
                System.out.println("Spinning clockwise with target:  " + endDegrees);
                drive.talLB.set(.3);
                drive.talRB.set(.3);
            } else {
                finished = true;
            }
        }

    }
    @Override
    protected boolean isFinished() {
        return finished;
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

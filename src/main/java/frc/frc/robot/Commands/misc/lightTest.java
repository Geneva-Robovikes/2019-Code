package frc.robot.Commands.misc;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.lights;

public class lightTest extends Command {
    int x = 1;
    boolean g = true;
    int direction = 1;
    public lightTest(){
        requires(lights);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        lights.setVal(x);
        x+=direction;
        if (x==0 || x==255){
            direction *= -1;
        }
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

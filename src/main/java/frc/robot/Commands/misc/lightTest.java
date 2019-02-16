package frc.robot.Commands.misc;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.lights;

public class lightTest extends Command {
    int x = 1;
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
        lights.red_light.setRaw(0);
 /*       lights.red_light.setRaw(x);
        x+=direction;
        if (x==255 || x==0){
            direction *= -1;
        }
    }
    */
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

package frc.robot.Commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import static frc.robot.Robot.drive;

public class emergencyBrake extends Command {
    private int x;
    public emergencyBrake(){
        super("emergencyBrake");
        requires(drive);
    }
    @Override
    protected void initialize() {
        x = 0;
        super.initialize();
    }

    @Override
    protected void execute() {
        x++;
        drive.setDriveTalons(0,0,-0,-0);
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        if(x<50){
            return false;
        }
        else{
            return true;
        }
    }

}

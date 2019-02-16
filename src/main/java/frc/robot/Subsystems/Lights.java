package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Lights extends Subsystem {
    public PWM red_light;

    public Lights(){
        red_light = new PWM(Constants.kPWM_PORT_LIGHT_R);
    }

    @Override
    protected void initDefaultCommand() {

    }
}

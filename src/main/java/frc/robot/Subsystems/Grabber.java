package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Grabber extends Subsystem {
    public Talon grabberTalon;
    public Grabber(){
        grabberTalon = new Talon(Constants.kTALON_PORT_GRABBER);
    }
    public void initDefaultCommand(){

    }
}

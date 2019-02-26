package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Grabber extends Subsystem {
    public Talon grabberTalon;
    public Solenoid grabberSol1, grabberSol2;

    public Grabber(){

        grabberTalon = new Talon(Constants.kTALON_PORT_GRABBER);
        grabberSol1 = new Solenoid(Constants.kSOL_PORT_GRABBER1);
        grabberSol2 = new Solenoid(Constants.kSOL_PORT_GRABBER2);
    }
    public void initDefaultCommand(){

    }
}

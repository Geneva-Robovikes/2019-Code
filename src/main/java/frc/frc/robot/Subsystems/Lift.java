package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Commands.Lift.liftPivot;
import frc.robot.Constants;

public class Lift extends Subsystem {
    public Talon liftTalonStage1, liftTalonStage2;
    public Solenoid liftPivotSol;


    public Lift(){
        liftTalonStage1 = new Talon(Constants.kTALON_PORT_LIFT1);
        liftTalonStage2= new Talon(Constants.kTALON_PORT_LIFT2);
        liftPivotSol = new Solenoid(Constants.kSOL_PORT_LIFT);
        /*
        LIMIT SWITCHES?
         */
    }
    public void initDefaultCommand(){
        setDefaultCommand(new liftPivot());
    }
}

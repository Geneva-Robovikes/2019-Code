package frc.robot.Commands.misc;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

import static frc.robot.Robot.dash;
import static frc.robot.Robot.drive;

public class UpdateDashValues extends CommandGroup {
    public UpdateDashValues(){
        super("UpdateDashValues");
    }

    @Override
    protected void initialize() {
        //System.out.println("UpdateDashValues started");
    }

    @Override
    protected void execute() {
        drive.updateGyroAngle();
        //System.out.println("Gyro angle Updated");
        dash.sbGyroAngle.setDouble(Double.parseDouble(dash.df.format(drive.getGyroAngle())));
        //System.out.println(drive.gyroAngle);
        //dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        //dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }


}

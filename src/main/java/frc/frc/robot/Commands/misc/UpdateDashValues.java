package frc.robot.Commands.misc;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

import static frc.robot.Robot.*;

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
        dash.sbTeleSpeed.getDouble(Constants.kDefaultTeleSpeed);
        dash.sbTurnSpeed.getDouble(Constants.kDefaultTurnSpeed);
        dash.sbRedLight.setDouble(lights.redVal);
        dash.sbGreenLight.setDouble(lights.greenVal);
        dash.sbBlueLight.setDouble(lights.blueVal);
        dash.sbRate.setDouble(lights.rate);
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

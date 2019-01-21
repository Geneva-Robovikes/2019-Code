package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class RobotInstance {
    RobotStick stick;
    Talon talonfl;
    Talon talonfr;
    Talon talonbl;
    Talon talonbr;
    ADXRS450_Gyro gyro;
    private double gyroAngle;
    private double TeleSpeed;
    private double TurnSpeed;
    NetworkTableEntry sbGyroAngle, sbTeleSpeed,sbTurnSpeed;
    public RobotInstance() { // Instantiate joystick, talons, encoders, limit switches, etc...
        stick = new RobotStick(5);
        talonfl = new Talon(0);
        talonbl = new Talon(1);
        talonfr = new Talon(2);
        talonbr = new Talon(3);
        gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
        TeleSpeed = .75;
        TurnSpeed = .5;
        gyroAngle = 0;
    }
    public void startDash(){
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 400, 300, 15 );
        camera.setExposureAuto();
        VideoSource video = camera;

        //sbCameraRate = Shuffleboard.getTab("Main").add("CameraRate", video.getActualDataRate()).getEntry();
        sbGyroAngle = Shuffleboard.getTab("Main").add("Gyro", getGyroAngle()).getEntry();

        Shuffleboard.getTab("Main").add("Camera Stream", video);
        System.out.println(CameraServer.kBasePort);
        sbTeleSpeed = Shuffleboard.getTab("Main")
                .add("TeleSpeed", .75).getEntry();
        sbTurnSpeed = Shuffleboard.getTab("Main")
                .add("TurnSpeed", .5).getEntry();

        Shuffleboard.selectTab("Main");

    }
    public void resetValues() { // Clears gyro angle
        gyroAngle = 0;

    }
    public double getGyroAngle() { // Gets and sets gyro angle simultaneously -- !!ONLY RUN ONCE PER CYCLE!!
        Timer.delay(.001); // Sets a uniform delay for calculation
        if (gyro.getRate() >= 2 || gyro.getRate() <= -2) { // Deadzone; prevents slight input
            gyroAngle += (gyro.getRate() * .001) * 20;

            //System.out.println(gyroAngle + "    " + SmartDashboard.getNumber("gyroAngle", 699));// Increments gyroAngle by rate * time
        }
        return gyroAngle; // Returns the current gyro angle
    }

    public void update() { // What runs in teleopPeriodic
        //driveOmni();
        driveOmniPowered();
        getGyroAngle();
        TeleSpeed = sbTeleSpeed.getDouble(.75);
        TurnSpeed = sbTurnSpeed.getDouble(.5);
        sbGyroAngle.setDouble(gyroAngle);
    }

    private void driveOmni () {
        talonbl.set(TeleSpeed * -stick.getDY() + TurnSpeed * stick.getDZ());
        talonbr.set(TeleSpeed * stick.getDY() + TurnSpeed * stick.getDZ());
    }

    private void driveOmniPowered(){
        talonfl.set(TeleSpeed * -stick.getDY());
        talonbl.set(TeleSpeed * -stick.getDY() + TurnSpeed * stick.getDZ());
        talonfr.set(TeleSpeed * stick.getDY());
        talonbr.set(TeleSpeed * stick.getDY() + TurnSpeed * stick.getDZ());
    }
}

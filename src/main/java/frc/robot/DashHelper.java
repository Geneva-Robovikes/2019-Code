package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import java.text.DecimalFormat;

import static frc.robot.Constants.*;

public class DashHelper {
    public ShuffleboardTab mainTab;
    public DecimalFormat df;
    public NetworkTableEntry sbGyroAngle, sbTeleSpeed,sbTurnSpeed;
    public void startDash(){
        mainTab = Shuffleboard.getTab("Main");
        df = new DecimalFormat("###.#");
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 400, 300, 15 );
        camera.setExposureAuto();
        VideoSource video = camera;

        //sbCameraRate = Shuffleboard.getTab("Main").add("CameraRate", video.getActualDataRate()).getEntry();
        sbGyroAngle = mainTab.add("Gyro", 0).getEntry();

        mainTab.add("Camera Stream", video);
        System.out.println(CameraServer.kBasePort);
        sbTeleSpeed = mainTab.add("TeleSpeed", kDefaultTeleSpeed).getEntry();
        sbTurnSpeed = mainTab.add("TurnSpeed", kDefaultTurnSpeed).getEntry();
        Shuffleboard.selectTab("Main");

    }
}

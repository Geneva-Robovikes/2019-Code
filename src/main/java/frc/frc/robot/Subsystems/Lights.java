package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class Lights extends Subsystem {
    public DigitalOutput red_light, green_light, blue_light;
    public int redVal, greenVal, blueVal;
    public final double rate = 5;
    private double redms, greenms, bluems;
    public Lights(){
        red_light = new DigitalOutput(Constants.kDIO_PORT_LIGHT_R);
        green_light = new DigitalOutput(Constants.kDIO_PORT_LIGHT_G);
        blue_light = new DigitalOutput(Constants.kDIO_PORT_LIGHT_B);
        redVal = 0;
        blueVal = 0;
        greenVal = 0;
    }

    @Override
    protected void initDefaultCommand() {

        red_light.set(false);
        green_light.set(false);
        blue_light.set(false);

    }

    public void powerLights() {
        new Thread(() -> {
            redms = ((double)redVal) / 255.0 * rate;
            while (true) {
                    red_light.set(true);
                    Timer.delay((redms) / 1000.0);
                    red_light.set(false);
                    Timer.delay((rate - redms) / 1000.0);
            }
        }).start();
        /*new Thread(() -> {
            greenms = (double) greenVal / 255.0 * rate;
            while (true) {
                green_light.set(true);
                Timer.delay((greenms) / 1000.0);
                green_light.set(false);
                Timer.delay((rate - greenms) / 1000.0);
            }
        }).start();
        new Thread(() -> {
            bluems = (double) blueVal / 255.0 * rate;
            while (true) {
                blue_light.set(true);
                Timer.delay((bluems) / 1000.0);
                blue_light.set(false);
                Timer.delay((rate - bluems) / 1000.0);
                System.out.println(bluems);
            }
        }).start();
        */
    }
    public void setVal(int color){
        redms = ((double)color) / 255.0 * rate;
    }
}

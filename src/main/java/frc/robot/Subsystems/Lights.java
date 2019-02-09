package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import java.util.Random;
public class Lights extends Subsystem {
    @Override
    protected void initDefaultCommand() {
        int x = 1;
        DigitalOutput light = new DigitalOutput(0);
        light.enablePWM(0.2);
        try{
            while (x<2) {
                light.setPWMRate(1);
                Thread.sleep(1000);
                light.setPWMRate(0);
                Thread.sleep(1000);
                System.out.println("Loop" + x);
                x++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

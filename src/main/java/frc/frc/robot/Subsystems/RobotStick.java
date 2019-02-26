package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.Grabber.*;
import frc.robot.Commands.Lift.*;
import frc.robot.Commands.drive.emergencyBrake;
import frc.robot.Commands.misc.ResetRobotSpeed;


public class RobotStick extends Joystick { // Defines the joystick
    //double dead;
    //boolean buttonState[];
    SmartDashboard Dash;



    public RobotStick(int port) { //The states of all the buttons on the joystick in an array
        super(port);

        JoystickButton  button1 = new JoystickButton(this, 1),
                        button2 = new JoystickButton(this, 2),
                        button3 = new JoystickButton(this, 3),
                        button4 = new JoystickButton(this, 4),
                        button5 = new JoystickButton(this, 5),
                        button6 = new JoystickButton(this, 6),
                        button7 = new JoystickButton(this, 7),
                        button8 = new JoystickButton(this, 8),
                        button9 = new JoystickButton(this, 9),
                        button10 = new JoystickButton(this, 10),
                        button11 = new JoystickButton(this, 11),
                        button12 = new JoystickButton(this, 12);

        button1.whenPressed(new grabberClose());
        button2.whenPressed(new grabberOpen());
        //button3.whileHeld(new liftDown());
        button4.whileHeld(new grabberBeltIn());
        //button5.whileHeld(new liftUp());
        button6.whileHeld(new grabberBeltOut());
        button7.whenPressed(new liftPos1());
        button9.whenPressed(new liftPos2());
        button10.whenPressed(new liftPivot());
        button11.whenPressed(new liftPos3());
        button12.whenPressed(new grabberOpenSlow());






        /*buttonState = new boolean[12];

        for(int i=0; i < buttonState.length; i++) {
            buttonState[i] = false;
        }*/

    }

    public double deadZone(double input, double dead) { // Deadzone for all joystick input

        if (input < dead && input > -dead) {
            return 0;
        }
        else {
            return input;
        }
    }

    public double getDX() { // Gets joystick X input (left/right)
        return deadZone(this.getRawAxis(0), .20);
    }

    public double getDY() { // Gets joystick Y input (forward/backward)
        return deadZone(this.getRawAxis(1), .20);
    }

    public double getDZ() { // Gets joystick Z input (twist)
        return deadZone(this.getRawAxis(2), .2);
    }

    public int getNub() { // Input for POV stick
        return this.getPOV();
    }

    public double getSlider() {
        return (1 - this.getRawAxis(3)) / 2;
    }

    /*public boolean getButton(int button) { // Continuous input while button is pressed
        return this.getRawButton(button);
    }
    public boolean getButtonToggle(int button) { // Toggle input on press
        buttonState[button] = !buttonState[button];
        return buttonState[button];
    }

    public boolean getButtonPress(int button) { // Executes once when button is pressed
        return this.getRawButtonPressed(button);
    }

    public double getStickDegree() { // Returns the angle that the joystick is at in degrees
        return Math.toDegrees(Math.asin(getDY()/(Math.pow((Math.pow(getDX(),2)+Math.pow(getDY(),2)),0.5))));
    }*/
}
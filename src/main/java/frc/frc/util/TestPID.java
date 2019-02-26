package frc.util;

public class TestPID {
    private double last_p_error, last_time, current_position, current_time, target_position, output;
    public final double kP = 0.5;
    public final double kD = -0.1;
    private boolean isInterrupted = false;

    public TestPID(){

        current_position = 0;
        target_position = 15;
    }
    public void stop(){
        isInterrupted = true;
    }
    public void run(){
        last_p_error = 0;
        last_time = 0;
        isInterrupted = false;
        current_time = 0;
        double p_error, d_error;
        while (!isInterrupted){
            current_time += 0.05;
            p_error = current_position - target_position;
            d_error = (p_error - last_p_error)/(current_time - last_time);
            last_p_error = p_error;
            last_time = current_time;
            output = p_error*kP + d_error*kD;


        }
    }
}

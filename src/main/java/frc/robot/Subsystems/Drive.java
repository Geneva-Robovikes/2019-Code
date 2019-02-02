
package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Commands.drive.driveOmniPowered;
import frc.robot.Commands.misc.UpdateDashValues;
import frc.robot.Constants;

import static frc.robot.Robot.dash;
import static frc.robot.Robot.drive;


public class Drive extends Subsystem {
        public Talon talLF, talRF, talLB, talRB;
        //public Encoder LeftEnc, RightEnc;
        public ADXRS450_Gyro gyro;
        public double gyroAngle;
        public Drive(){
            talLF      = new Talon(Constants.kTALON_PORT_LF); //0
            talLB      = new Talon(Constants.kTALON_PORT_LB); //1
            talRF      = new Talon(Constants.kTALON_PORT_RF); //2
            talRB      = new Talon(Constants.kTALON_PORT_RB); //3

            //LeftEnc  = new Encoder(4,5,true, CounterBase.EncodingType.k4X);
            //RightEnc = new Encoder(6,7,false, CounterBase.EncodingType.k4X);

            gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
            gyro.reset();

            gyroAngle = 0;
        }
        public void initDefaultCommand() {
            /*talLF      = new Talon(Constants.kTALON_PORT_LF); //0
            talLB      = new Talon(Constants.kTALON_PORT_LB); //1
            talRF      = new Talon(Constants.kTALON_PORT_RF); //2
            talRB      = new Talon(Constants.kTALON_PORT_RB); //3

            //LeftEnc  = new Encoder(4,5,true, CounterBase.EncodingType.k4X);
            //RightEnc = new Encoder(6,7,false, CounterBase.EncodingType.k4X);

            gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
            gyro.reset();

            gyroAngle = 0;*/
            setDefaultCommand(new driveOmniPowered());
        }

        public void updateGyroAngle() { // Gets and sets gyro angle simultaneously -- !!ONLY RUN ONCE PER CYCLE!!
            Timer.delay(.001); // Sets a uniform delay for calculation
            if (gyro.getRate() >= 2 || gyro.getRate() <= -2) { // Deadzone; prevents slight input
                gyroAngle += (gyro.getRate() * .001) * 20;

            }
            if (Math.abs(gyroAngle % 360) > (360-(gyro.getRate()*.02))
                    || Math.abs(gyroAngle % 360) < (0+(gyro.getRate() * .02))){ //wrap back to 0
                gyroAngle = 0;
            }
            if (gyroAngle < 0){ // avoid negative values
                gyroAngle = 360 + gyroAngle;
            }
            //dash.sbGyroAngle.setDouble(Double.parseDouble(dash.df.format(drive.gyroAngle)));

        }
        public double getGyroAngle(){
            return gyroAngle;
        }
        public void resetGyro() { // Clears gyro angle
            gyroAngle = 0;
        }
    }

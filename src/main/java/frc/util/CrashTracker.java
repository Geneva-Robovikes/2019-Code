package frc.util;
import java.io.*;
import java.util.*;

public class CrashTracker {
    public static void logAutoInit(){
        writeToLog("AutoInit");
    }
    public static void logRobotInit(){
        writeToLog("RobotInit");
    }
    public static void logThrowable(Throwable th){
        writeToLog("Exception", th);
    }
    private static void writeToLog(String type){
        writeToLog(type, null);
    }

    private static void writeToLog(String type, Throwable exception){

        String crashLogLocation = "\\home\\crashlog.txt";
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(crashLogLocation,true))){
            logWriter.print(new Date().toString()+": "+type+": ");
            if(exception!=null){
                exception.printStackTrace(logWriter);
            }
            logWriter.println();
        }
        catch(IOException e){
            try {
                File logFile = new File(crashLogLocation);
                logFile.createNewFile();
                try (PrintWriter logWriter = new PrintWriter(new FileWriter(crashLogLocation,true))){
                    logWriter.print(new Date().toString()+": "+type+": ");
                    if(exception!=null){
                        exception.printStackTrace(logWriter);
                    }
                    logWriter.println();
                }
            }
            catch(IOException g){
                g.printStackTrace();
            }
        }
    }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Add your docs here.
 */
public class AUTO {
    public static boolean isAuto = false;
    private static Ultrasonic us = new Ultrasonic(Constants.port_US_PING, Constants.port_US_ECHO);
    private static Timer t = new Timer();

    public static void resetTimer(){
        t.reset();
    }

    public static void START_AUTO(byte num_TEAM){
        resetTimer();
        isAuto = true;
        double distance = us.getRangeInches();

        if(num_TEAM == 1){
            while(distance >= 0.2){
                DriveTrain.geri(0.5);
            }
            DriveTrain.STOP();
            Timer.delay(0.1);
            Dropper.open_panel(); 
            Timer.delay(3);
            Dropper.close_panel();
            Timer.delay(0.1);
            while(distance <= 30){
                DriveTrain.ileri(0.5);
            }
        } else if(num_TEAM == 2) {
            
        } else if(num_TEAM == 3) {

        } else {
            DriveTrain.STOP();
        }
    }

    public static boolean until_DISTANCE(double edge){
        if(us.getRangeInches() < edge) {
            return true;
        } else {
            return false;
        }
    }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * frc 2020 otonom kod için ultrasonic sensör kodu
 */
public class Ultrasonic {
    ///////ilk önce ultrasoniğimizi tanımlayalım///////
    private static AnalogInput us = new AnalogInput(Constants.port_Ultrasonic);

    ///////ultrasonicden değer alabilmek için gerekli metodumuz///////
    public static int getDistance() {
        return us.getValue();
    }

    ///////ultrasonicden gelen değeri SmartDashboarda yazdırmak için metodumuz///////
    public static void putData(){
        SmartDashboard.putNumber("Ultrasonic value", getDistance());
    }
}

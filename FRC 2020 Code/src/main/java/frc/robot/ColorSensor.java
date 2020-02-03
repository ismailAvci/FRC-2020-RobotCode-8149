/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.*;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

/*
frc 2020 için color sensor kodu
*/
public class ColorSensor {
    private static ColorSensorV3 renkSensor = new ColorSensorV3(I2C.Port.kOnboard);
    private static ColorMatch matcher = new ColorMatch();

    private static Color mavi = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private static Color kirmizi = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private static Color yesil = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private static Color sari = ColorMatch.makeColor(0.361, 0.524, 0.113);

    public ColorSensor(){
        matcher.addColorMatch(mavi);
        matcher.addColorMatch(kirmizi);
        matcher.addColorMatch(yesil);
        matcher.addColorMatch(sari);
    }

    public static String ReturnColor(){
        Color detectedColor = renkSensor.getColor();
        String color = "";
        ColorMatchResult result = matcher.matchClosestColor(detectedColor);

        if(result.color == mavi){
            color = "MAVI";
        }
        else if(result.color == kirmizi){
            color = "KIRMIZI";
        }
        else if(result.color == yesil){
            color = "YESIL";
        }
        else if(result.color == sari){
            color = "SARI";
        }
        else{
            color = "UNDEFINED";
        }

        return color;
    }

    public static void putColor(){
        String c = ReturnColor();
        switch(c){
            case "MAVI": SmartDashboard.putString("Network Table Tree", "mavi");
                break;
            
            case "KIRMIZI": SmartDashboard.putString("Network Table Tree", "kirmizi");
                break;

            case "YESIL": SmartDashboard.putString("Network Table Tree", "yeşil");
                break;

            case "SARI": SmartDashboard.putString("Network Table Tree", "sarı");
                break;

            default: SmartDashboard.putString("Network Table Tree", "TANIMSIZ");
        }
    }
}
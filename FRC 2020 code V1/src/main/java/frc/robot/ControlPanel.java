/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * FRC 2020 oyunu "INFINITE RECHARGE" için kontrol paneli kodları
 */
public class ControlPanel extends ColorSensor {

    ///////kontrol paneli için gerekli olan aktüatörları tanımlayalım///////
    private static PWMVictorSPX WheelMotor;
    private static Servo turn;

    ///////tüm metodları statik olarak kullanacağımız için constructer yerine init metodu tanımlıyoruz///////
    public static void init(){
        ColorSensor.init();

        WheelMotor = new PWMVictorSPX(Constants.portVictor_ControlPanel);
        turn = new Servo(Constants.port_Servo);
    }

    ///////rotasyon kontrolü için gerekli metodu yazıyoruz///////
    ///////UYARI!!!: Bu metodun ardarda birden fazla çalıştırılması metodun istenildiği gibi çalışmasını engelleyecektir///////
    public static void setRotationControl(){
        String renk = ColorSensor.getRenk();
        
        byte sayac = 0;

        turn.setAngle(90);
        WheelMotor.set(0.5);

        while(true){
            String renk2 = ColorSensor.getRenk();
            if(renk.equals(renk2)) {
                sayac++;
            } else if(sayac == 8) {
                break;
            } else {
                continue;
            }
        }

        WheelMotor.stopMotor();
        turn.setAngle(0);
    }

    ///////pozisyon kontrolü için kullanacağımız kodu yazıyoruz///////
    public static void PositionControl(){
        String renk = ColorSensor.getRenk();
        String givenColor = SmartDashboard.getString("FMS", "UNDEFINED");
        givenColor.toUpperCase();

        if(getManuelColor().equals(givenColor)) {
            if(givenColor.equals("BLUE")) setPositionControl_BLUE(renk);
            else if(givenColor.equals("RED")) setPositionControl_RED(renk);
            else if(givenColor.equals("GREEN")) setPositionControl_GREEN(renk);
            else if(givenColor.equals("YELLOW")) setPositionControl_YELLOW(renk);
        }
    }

    ///////manuel olarak renkleri kontrol edebilmek için gerekli olan 4 metodu yazıyoruz///////
    private static void setPositionControl_BLUE(String renk) {
        boolean isBlue = false;

        turn.setAngle(90);
        WheelMotor.set(0.5);

        while(!isBlue) {
            if(renk.equals("KIRMIZI")) {
                isBlue = true;
            } else continue;
        }

        WheelMotor.stopMotor();
        turn.setAngle(0);
    }

    private static void setPositionControl_RED(String renk) {
        boolean isRed = false;

        turn.setAngle(90);
        WheelMotor.set(0.5);

        while(!isRed) {
            if(renk.equals("MAVI")) {
                isRed = true;
            } else continue;
        }

        WheelMotor.stopMotor();
        turn.setAngle(0);
    }

    private static void setPositionControl_YELLOW(String renk) {
        boolean isYellow = false;

        turn.setAngle(90);
        WheelMotor.set(0.5);

        while(!isYellow) {
            if(renk.equals("YESIL")) {
                isYellow = true;
            } else continue;
        }

        WheelMotor.stopMotor();
        turn.setAngle(0);
    }

    private static void setPositionControl_GREEN(String renk) {
        boolean isGreen = false;

        turn.setAngle(90);
        WheelMotor.set(0.5);

        while(!isGreen) {
            if(renk.equals("SARI")) {
                isGreen = true;
            } else continue;
        }

        WheelMotor.stopMotor();
        turn.setAngle(0);
    }

    ///////js'den veri almak için yazdığımız metod///////
    private static String getManuelColor() {
        String renk = "";
        
        if(INPUT.xbox_X.get()) renk = "MAVI";
        else if(INPUT.xbox_Y.get()) renk = "SARI";
        else if(INPUT.xbox_A.get()) renk = "YESIL";
        else if(INPUT.xbox_B.get()) renk = "KIRMIZI";
        else renk = "TANIMSIZ";

        return renk;
    }
}
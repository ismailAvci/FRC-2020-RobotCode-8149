/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * FRC 2020 oyunu "INFINITE RECHARGE" için top bırakma sistemi kodu
 */
public class Dropper {
    ///////Dropper'ı pnömatik ile kontrol edeceğimizden dolayı ilk önce gerekli nesnelerimizi oluşturuyoruz///////
    private static DoubleSolenoid solenoid = new DoubleSolenoid(Constants.portSolenoid_frw,
                                                                Constants.portSolenoid_rev);

    private static Compressor c = new Compressor(Constants.num_PCM);

    private static boolean comp_status = false;
    private static String solenoid_status = "";

    ///////Solenoid'i kontrol etmek için temel kodları yazıyoruz///////
    public static void open_hatch(){
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public static void close_hatch(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public static DoubleSolenoid.Value getHatchStatus(){
        return solenoid.get();
    }

    ///////compressor için enkapsülasyon kodlarını yazıyoruz///////
    public static void setComp(boolean status){
        comp_status = status;
    }

    public static boolean getComp(){
        return comp_status;
    }
    ///////Solenoid'in davranışını belirleyecek ana metodumuzu yazıyoruz///////
    public static void setSolenoid(){
        c.setClosedLoopControl(false);

        if(INPUT.js_but7.get()) {
            setComp(true);
        } else if(INPUT.js_but9.get()) {
            open_hatch();
        } else if(INPUT.js_but11.get()) {
            close_hatch();
        } else {
            setComp(false);
        }
    }

    ///////Solenoid'in durumunu yazdıran metodu yazıyoruz///////
    public static void putData(){
        if(getHatchStatus() == Value.kForward) {
            solenoid_status = "FORWARD";
        } else if(getHatchStatus() == Value.kReverse) {
            solenoid_status = "REVERSE";
        } else {
            solenoid_status = "OFF";
        }

        SmartDashboard.putBoolean("Compressor Data", getComp());
        SmartDashboard.putString("Solenoid Data", solenoid_status);
    }
}

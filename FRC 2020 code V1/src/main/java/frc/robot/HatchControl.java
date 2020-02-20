/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * FRC 2020 oyunu "INFINITE RACHARGE" için hazne kontrol kodu
 */
public class HatchControl extends Dropper {
    ///////başta robotun alış sistemi için gerekli olan motoru tanılıyoruz///////
    private static PWMVictorSPX intake = new PWMVictorSPX(Constants.portVictor_INTAKE);

    /**
     * burada haznede kaç top olduğunu bulabilmek için basit bir algoritma yazacağız:
     * 
     * TODO:
     *  alış mekanizması için kullanılacak motoru son hız döndürmeye başla;
     *  ultrasoniği servoyu kullanarak hazneye yönelt;
     *  ultrasoniği başlat;
     *  hazneye gelen toplar ultrasoniğin altından geçerken ultrasonik belli bir değerden aşağı değer alırsa sayacı 1 arttırsın;
     *  eğer sayac == 5 ise o zaman intake'i durdur ve sayacı sıfırla;
     */

    ///////alış motorumuz için enkapsülasyon kodu///////
    public static void setIntake(byte status){
        intake.set(status);
    }

    public static double getIntake(){
        return intake.get();
    }

    ///////haznenin ///////
}

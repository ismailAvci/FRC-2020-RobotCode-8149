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

/**
 * FRC 2020 oyunu "INFINITE RECHARGE" için renk sensörü kodu
 */
public class ColorSensor {
    ///////Renk Sensörümüzü tanımlıyoruz///////
    private static ColorSensorV3 sensor = new ColorSensorV3(I2C.Port.kOnboard);

    ///////Renkleri eşleştirecek sınıfı tanımlıyoruz///////
    private static ColorMatch es = new ColorMatch();

    ///////renklerimizi tanımlıyoruz///////
    private static Color mavi = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private static Color kirmizi = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private static Color yesil = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private static Color sari = ColorMatch.makeColor(0.361, 0.524, 0.113);

    ///////rengimizin string degerini tutacak String değişkenini tanımlıyoruz///////
    private static String renk = "TANIMSIZ";
    
    ///////sınıfı tamamen statik olarak kullanacağımızdan dolayı bir constrctor yerine ayrı bir metod tanımlıyoruz//////
    public static void init(){
        es.addColorMatch(mavi);
        es.addColorMatch(kirmizi);
        es.addColorMatch(yesil);
        es.addColorMatch(sari);
    }

    ///////kodun en önemli metodu: rengimizi enkapsülasyon yöntemiyle alıyoruz///////
    public static String getRenk(){
        Color deger = sensor.getColor();

        ColorMatchResult sonuc = es.matchClosestColor(deger);

        if(sonuc.color == mavi) renk = "MAVI";
        else if(sonuc.color == kirmizi) renk = "KIRMIZI";
        else if(sonuc.color == yesil) renk = "YESIL";
        else if(sonuc.color == sari) renk = "SARI";
        else renk = "TANIMSIZ";

        return renk;
    }

    ///////rengimizi gösterebilmek için SmartDashboard'a rgb degerini ve rengi yazdırıyoruz//////
    public static void putData(){
        SmartDashboard.putNumber("value_R", sensor.getRed());
        SmartDashboard.putNumber("value_G", sensor.getGreen());
        SmartDashboard.putNumber("value_B", sensor.getBlue());
        SmartDashboard.putString("RENK", renk);
    }
}

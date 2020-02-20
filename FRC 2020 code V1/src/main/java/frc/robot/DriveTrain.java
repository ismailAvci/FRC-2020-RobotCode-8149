/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * FRC 2020 oyunu "INFINITE RECHARGE" için Drive Train kodu
 */
public class DriveTrain {
    ////////teleopu kontrol için/////////
    private static boolean isTELEOP = false;

    ///////motorları taımladık////////
    private static final PWMVictorSPX victor_FR = new PWMVictorSPX(Constants.portVictor_FR);
    private static final PWMVictorSPX victor_FL = new PWMVictorSPX(Constants.portVictor_FL);
    private static final PWMVictorSPX victor_BR = new PWMVictorSPX(Constants.portVictor_BR);
    private static final PWMVictorSPX victor_BL = new PWMVictorSPX(Constants.portVictor_BL);

    ////////motorları ayrıştırdık////////
    private static final SpeedControllerGroup victor_R = new SpeedControllerGroup(victor_FR, victor_BR);
    private static final SpeedControllerGroup victor_L = new SpeedControllerGroup(victor_FL, victor_BL);

    ////////drive train'i oluşturduk///////
    public static final DifferentialDrive drive = new DifferentialDrive(victor_L, victor_R);

    ////////"isTeleop" için enkapsülasyon metodlarını oluşturduk////////
    public static void SET_TELEOP_STATUS(boolean status){
        isTELEOP = status;
    }

    public static boolean GET_TELEOP_STATUS(){
        return isTELEOP;
    }

    ///////teleop'da robotun driveTrain'i///////
    public static void START_TELEOP(Object o){
        drive.setDeadband(Constants.deadband);
        if(isTELEOP){
            if(o instanceof Joystick){
                drive.arcadeDrive(INPUT.js.getY(), INPUT.js.getX());
            } else if(o instanceof XboxController){
                drive.tankDrive(INPUT.xbox.getRawAxis(Constants.axis_xbox_LY),
                                INPUT.xbox.getRawAxis(Constants.axis_xbox_RY));
            }
            else drive.stopMotor();
        }
    }

    ///////manuel kontrol için temel kodlar///////
    public static void ILERI(double hiz){
        drive.tankDrive(hiz, hiz);
    }

    public static void GERI(double hiz){
        drive.tankDrive(-hiz, -hiz);
    }

    public static void SAGA_DON(double hiz){
        drive.arcadeDrive(0, hiz);
    }

    public static void SOLA_DON(double hiz){
        drive.arcadeDrive(0, -hiz);
    }

    public static void DUR(){
        drive.stopMotor();
    }

    ///////Smart Dashboard'a hızlarımızı yazdırıyoruz///////
    public static void putData(){
        SmartDashboard.putNumber("Motor Left", victor_L.get());
        SmartDashboard.putNumber("Motor Right", victor_R.get());
    }
}

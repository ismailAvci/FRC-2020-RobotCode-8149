/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/*
DriveTrain kodu
*/
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
    //DriveTrain için motorları koda tanıtalım
    private static PWMVictorSPX victor_FR = new PWMVictorSPX(Constants.port_FR);
    private static PWMVictorSPX victor_FL = new PWMVictorSPX(Constants.port_FL);
    private static PWMVictorSPX victor_BR = new PWMVictorSPX(Constants.port_BR);
    private static PWMVictorSPX victor_BL = new PWMVictorSPX(Constants.port_BL);

    private static SpeedControllerGroup victor_R;
    private static SpeedControllerGroup victor_L;

    private static DifferentialDrive RobotDrive;

    public DriveTrain(){
        victor_R = new SpeedControllerGroup(victor_FR, victor_BR);
        victor_L = new SpeedControllerGroup(victor_FL, victor_BL);

        RobotDrive = new DifferentialDrive(victor_L, victor_R);

        RobotDrive.setDeadband(Constants.driveTrain_DEADBAND);
    }

    public static void START(Object o){
        if(o instanceof Joystick){
            Joystick js = new Joystick(Constants.port_JS);
            RobotDrive.arcadeDrive(js.getRawAxis(Constants.axis_X_JS), 
                                   js.getRawAxis(Constants.axis_Y_JS), 
                                   true);
        }
        else if(o instanceof XboxController){
            XboxController xbox = new XboxController(Constants.port_XBOX);
            RobotDrive.tankDrive(xbox.getRawAxis(Constants.axis_LX_XBOX),
                                 xbox.getRawAxis(Constants.axis_RX_XBOX),
                                 true);
        }
        else{
            STOP();
        }
    }

    public static void ileri(double hiz){
        RobotDrive.tankDrive(hiz * 0.5, hiz * 0.5);
    }

    public static void geri(double hiz){
        RobotDrive.tankDrive(-hiz * 0.5, -hiz * 0.5);
    }

    public static void saga_don(double hiz){
        RobotDrive.tankDrive(hiz * 0.5, -hiz * 0.5);
    }

    public static void sola_don(double hiz){
        RobotDrive.tankDrive(-hiz * 0.5, hiz * 0.5);
    }

    public static void STOP(){
        RobotDrive.tankDrive(0, 0);
    }
}

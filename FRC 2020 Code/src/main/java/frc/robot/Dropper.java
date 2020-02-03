/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class Dropper {
    private static DoubleSolenoid solenoid;
    private static Compressor C;

    public Dropper() {
        solenoid = new DoubleSolenoid(Constants.port_SOLENOID_FORWARD,
                                        Constants.port_SOLENOID_REVERSE);
        C = new Compressor(Constants.num_PCM);

        C.setClosedLoopControl(true);
    }

    public static void open_panel(){
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public static void close_panel(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public static void solenoid_off(){
        solenoid.set(DoubleSolenoid.Value.kOff);
    }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final byte portVictor_FL = 4,
                             portVictor_FR = 1,
                             portVictor_BL = 3,
                             portVictor_BR = 2,
                             portVictor_LIFT = 5,
                             portVictor_ControlPanel = 6,
                             portVictor_INTAKE = 7,

                             port_JS = 0,
                             port_XBOX = 1,

                             axis_js_X = 0,
                             axis_js_Y = 1,
                             axis_js_Z = 2,

                             axis_xbox_LX = 0,
                             axis_xbox_LY = 1,
                             axis_xbox_LT = 2,
                             axis_xbox_RT = 3,
                             axis_xbox_RX = 4,
                             axis_xbox_RY = 5,

                             portSolenoid_frw = 4,
                             portSolenoid_rev = 5,

                             num_PCM = 14,

                             port_Servo = 8,

                             port_Ultrasonic = 0;

    public static final float deadband = 0.1f;
}

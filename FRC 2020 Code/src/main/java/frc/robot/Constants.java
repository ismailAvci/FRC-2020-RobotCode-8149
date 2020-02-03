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
    public static final int port_FR = 3;
    public static final int port_FL = 2;
    public static final int port_BR = 0;
    public static final int port_BL = 1;
    public static final float driveTrain_DEADBAND = 0.2f;

    public static final int port_JS = 0;
    public static final int port_XBOX = 1;

    public static final int axis_X_JS = 0;
    public static final int axis_Y_JS = 1;
    public static final int axis_Z_JS = 2;

    public static final int axis_LX_XBOX = 0;
    public static final int axis_LY_XBOX = 1;
    public static final int axis_RX_XBOX = 4;
    public static final int axis_RY_XBOX = 5;

    public static final int num_PCM = 14;
    public static final int port_SOLENOID_FORWARD = 0;
    public static final int port_SOLENOID_REVERSE = 0;

    public static final int port_US_PING = 0;
    public static final int port_US_ECHO = 1;
    public static final double distance_DROPPER_EDGE = 0;

    public static final byte num_TEAM = 1;
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Input's of robot
 */
public class INPUT {
    ///////Controllerlarımızı oluşturuyoruz///////
    public static final Joystick js = new Joystick(Constants.port_JS);
    public static final XboxController xbox = new XboxController(Constants.port_XBOX);

    ///////Controllerlarımızın butonlarını tanımlıyorum///////
    public static final JoystickButton js_but1 = new JoystickButton(js, 1);
    public static final JoystickButton js_but2 = new JoystickButton(js, 2);
    public static final JoystickButton js_but3 = new JoystickButton(js, 3);
    public static final JoystickButton js_but4 = new JoystickButton(js, 4);
    public static final JoystickButton js_but5 = new JoystickButton(js, 5);
    public static final JoystickButton js_but6 = new JoystickButton(js, 6);
    public static final JoystickButton js_but7 = new JoystickButton(js, 7);
    public static final JoystickButton js_but8 = new JoystickButton(js, 8);
    public static final JoystickButton js_but9 = new JoystickButton(js, 9);
    public static final JoystickButton js_but10 = new JoystickButton(js, 10);
    public static final JoystickButton js_but11 = new JoystickButton(js, 11);
    public static final JoystickButton js_but12 = new JoystickButton(js, 12);

    public static final JoystickButton xbox_A = new JoystickButton(xbox, 1);
    public static final JoystickButton xbox_B = new JoystickButton(xbox, 2);
    public static final JoystickButton xbox_X = new JoystickButton(xbox, 3);
    public static final JoystickButton xbox_Y = new JoystickButton(xbox, 4);
    public static final JoystickButton xbox_LB = new JoystickButton(xbox, 5);
    public static final JoystickButton xbox_RB = new JoystickButton(xbox, 6);
    public static final JoystickButton xbox_BACK = new JoystickButton(xbox, 7);
    public static final JoystickButton xbox_START = new JoystickButton(xbox, 8);
    public static final JoystickButton xbox_LjsB = new JoystickButton(xbox, 9);
    public static final JoystickButton xbox_RjsB = new JoystickButton(xbox, 10);
}

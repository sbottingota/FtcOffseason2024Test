package org.firstinspires.ftc.teamcode.opModes.test;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.arm.ArmLowerCommand;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmRaiseCommand;
import org.firstinspires.ftc.teamcode.subsystems.arm.ArmSubsystem;

@TeleOp
public class ArmTester extends OpMode {
    private ArmSubsystem arm;
    private GamepadEx gamepad;
    @Override
    public void init() {
        arm = new ArmSubsystem(hardwareMap, "arm_motor", "arm_limit_switch", 1000, 0);

        gamepad = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        gamepad.readButtons();

        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new ArmRaiseCommand(arm));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new ArmLowerCommand(arm));
    }
}

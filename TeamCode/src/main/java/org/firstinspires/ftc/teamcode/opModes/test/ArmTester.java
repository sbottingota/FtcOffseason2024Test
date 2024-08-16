package org.firstinspires.ftc.teamcode.opModes.test;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.components.arm.ArmLowerCommand;
import org.firstinspires.ftc.teamcode.components.arm.ArmRaiseCommand;
import org.firstinspires.ftc.teamcode.components.arm.ArmSubsystem;

@TeleOp
public class ArmTester extends CommandOpMode {
    @Override
    public void initialize() {
        ArmSubsystem arm = new ArmSubsystem(hardwareMap, "arm_motor", "arm_limit_switch");
        register(arm);

        GamepadEx gamepad = new GamepadEx(gamepad1);

        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new ArmRaiseCommand(arm));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new ArmLowerCommand(arm));
    }
}

package org.firstinspires.ftc.teamcode.opModes.test;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.components.intake.IntakeBackwardCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeForwardCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeSubsystem;

@TeleOp
public class IntakeTester extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        IntakeSubsystem intake = new IntakeSubsystem(hardwareMap, "intake_motor");
        register(intake);

        gamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new IntakeForwardCommand(intake))
                .whenReleased(new IntakeStopCommand(intake));
        gamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new IntakeBackwardCommand(intake))
                .whenReleased(new IntakeStopCommand(intake));
    }
}

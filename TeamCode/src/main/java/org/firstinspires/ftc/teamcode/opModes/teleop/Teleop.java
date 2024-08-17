package org.firstinspires.ftc.teamcode.opModes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.components.arm.ArmLowerCommand;
import org.firstinspires.ftc.teamcode.components.arm.ArmRaiseCommand;
import org.firstinspires.ftc.teamcode.components.arm.ArmSubsystem;
import org.firstinspires.ftc.teamcode.components.deposit.DepositCloseCommand;
import org.firstinspires.ftc.teamcode.components.deposit.DepositOpenCommand;
import org.firstinspires.ftc.teamcode.components.deposit.DepositSubsystem;
import org.firstinspires.ftc.teamcode.components.drive.DriveCommand;
import org.firstinspires.ftc.teamcode.components.drive.DriveSubsystem;
import org.firstinspires.ftc.teamcode.components.intake.IntakeBackwardCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeForwardCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.components.intake.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp
public class Teleop extends CommandOpMode {
    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        ArmSubsystem arm = new ArmSubsystem(hardwareMap, "arm_motor", "arm_limit_switch");
        IntakeSubsystem intake = new IntakeSubsystem(hardwareMap, "intake_motor");
        DepositSubsystem deposit = new DepositSubsystem(hardwareMap, "deposit_servo");
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, gamepad,
                "front_left_drive", "front_right_drive", "back_left_drive", "back_right_drive");

        register(arm, intake, deposit, drive);

        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new ArmRaiseCommand(arm));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(new ArmLowerCommand(arm));

        gamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new IntakeForwardCommand(intake))
                .whenReleased(new IntakeStopCommand(intake));
        gamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new IntakeBackwardCommand(intake))
                .whenReleased(new IntakeStopCommand(intake));

        gamepad.getGamepadButton(PSButtons.CROSS)
                .whenPressed(new DepositOpenCommand(deposit))
                .whenReleased(new DepositCloseCommand(deposit));

        drive.setDefaultCommand(new DriveCommand(drive));
    }
}

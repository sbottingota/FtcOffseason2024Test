package org.firstinspires.ftc.teamcode.opModes.test;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.components.deposit.DepositCloseCommand;
import org.firstinspires.ftc.teamcode.components.deposit.DepositOpenCommand;
import org.firstinspires.ftc.teamcode.components.deposit.DepositSubsystem;
import org.firstinspires.ftc.teamcode.util.inputs.PSButtons;

@TeleOp
public class DepositTester extends CommandOpMode {
    @Override
    public void initialize() {
        DepositSubsystem deposit = new DepositSubsystem(hardwareMap, "deposit_servo");
        register(deposit);
        GamepadEx gamepad = new GamepadEx(gamepad1);

        gamepad.getGamepadButton(PSButtons.SQUARE).whenPressed(new DepositOpenCommand(deposit));
        gamepad.getGamepadButton(PSButtons.CIRCLE).whenPressed(new DepositCloseCommand(deposit));
    }
}

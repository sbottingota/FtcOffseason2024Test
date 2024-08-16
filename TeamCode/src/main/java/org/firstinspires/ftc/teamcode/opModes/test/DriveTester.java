package org.firstinspires.ftc.teamcode.opModes.test;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.components.drive.DriveCommand;
import org.firstinspires.ftc.teamcode.components.drive.DriveSubsystem;

public class DriveTester extends CommandOpMode {
    @Override
    public void initialize() {
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, new GamepadEx(gamepad1),
                "front_left", "front_right", "back_left", "back_right");
        register(drive);
       
        drive.setDefaultCommand(new DriveCommand(drive));
    }
}

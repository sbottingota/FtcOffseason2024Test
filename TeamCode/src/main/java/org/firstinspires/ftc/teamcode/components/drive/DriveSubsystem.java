package org.firstinspires.ftc.teamcode.components.drive;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {
    private final Motor[] motors;

    private final MecanumDrive drive;
    private final GamepadEx gamepad;

    public DriveSubsystem(HardwareMap hw, GamepadEx gamepad,
                          String frontLeftId, String frontRightId, String backLeftId, String backRightId) {
        motors = new Motor[]{
                new Motor(hw, frontLeftId),
                new Motor(hw, frontRightId),
                new Motor(hw, backLeftId),
                new Motor(hw, backRightId)
        };
        this.drive = new MecanumDrive(motors[0], motors[1], motors[2], motors[3]);

        this.gamepad = gamepad;
    }

    public void drive() {
        this.drive.driveRobotCentric(gamepad.getLeftX(), gamepad.getLeftY(), gamepad.getRightX());
    }

    public MecanumDrive getDrive() {
        return drive;
    }

    public Motor[] getMotors() {
        return motors;
    }
}

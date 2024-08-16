package org.firstinspires.ftc.teamcode.components.deposit;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DepositSubsystem extends SubsystemBase {
    public static final int DEPOSIT_CLOSED_POSITION = 0;
    public static final int DEPOSIT_OPEN_POSITION = 90;

    private final ServoEx depositServo;

    public DepositSubsystem(HardwareMap hw, String depositServoId) {
        depositServo = new SimpleServo(hw, depositServoId, DEPOSIT_CLOSED_POSITION, DEPOSIT_OPEN_POSITION);
    }

    public void open() {
        depositServo.turnToAngle(DEPOSIT_OPEN_POSITION);
    }

    public void close() {
        depositServo.turnToAngle(DEPOSIT_CLOSED_POSITION);
    }

    public ServoEx getDepositServo() {
        return depositServo;
    }
}

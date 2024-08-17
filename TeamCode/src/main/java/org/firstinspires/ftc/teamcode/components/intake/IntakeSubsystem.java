package org.firstinspires.ftc.teamcode.components.intake;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem extends SubsystemBase {
    private final Motor intakeMotor;

    public IntakeSubsystem(HardwareMap hw, String intakeMotorId) {
        intakeMotor = new Motor(hw, intakeMotorId);
    }

    void forward() {
        intakeMotor.set(1);
    }

    void backward() {
        intakeMotor.set(-1);
    }

    void stop() {
        intakeMotor.set(0);
    }
}

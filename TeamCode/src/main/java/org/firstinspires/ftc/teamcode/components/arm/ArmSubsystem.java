package org.firstinspires.ftc.teamcode.components.arm;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class ArmSubsystem extends SubsystemBase {
    public static final int HIGH_POSITION = 1000;
    public static final int LOW_POSITION = 0;

    private final MotorEx armMotor;
    private final TouchSensor lowLimit;

    private final PIDController controller = new PIDController(0, 0, 0);

    public ArmSubsystem(HardwareMap hw, String motorId, String lowLimitSwitchId) {
        armMotor = new MotorEx(hw, motorId);
        lowLimit = hw.touchSensor.get(lowLimitSwitchId);
    }

    @Override
    public void periodic() {
        if (controller.getSetPoint() == LOW_POSITION && lowLimit.isPressed()) {
            armMotor.set(0);
        } else {
            armMotor.set(controller.calculate(armMotor.getCurrentPosition()));
        }
    }

    public void raise() {
        controller.setSetPoint(HIGH_POSITION);
    }

    public void lower() {
        controller.setSetPoint(HIGH_POSITION);
    }

    public boolean atSetPoint() {
        return controller.atSetPoint() || (controller.getSetPoint() == LOW_POSITION && lowLimit.isPressed());
    }

    public MotorEx getArmMotor() {
        return armMotor;
    }
}

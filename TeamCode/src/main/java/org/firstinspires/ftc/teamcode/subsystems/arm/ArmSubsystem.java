package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class ArmSubsystem extends SubsystemBase {
    private final MotorEx armMotor;
    private final TouchSensor lowLimit;

    private final PIDController controller = new PIDController(0, 0, 0);

    private final int highPosition, lowPosition;
    public ArmSubsystem(HardwareMap hw, String motorId, String lowLimitSwitchId, int highPosition, int lowPosition) {
        armMotor = new MotorEx(hw, motorId);
        lowLimit = hw.touchSensor.get(lowLimitSwitchId);

        this.highPosition = highPosition;
        this.lowPosition = lowPosition;
    }

    @Override
    public void periodic() {
        if (controller.getSetPoint() == lowPosition && lowLimit.isPressed()) {
            armMotor.set(0);
        } else {
            armMotor.set(controller.calculate(armMotor.getCurrentPosition()));
        }
    }

    public void raise() {
        controller.setSetPoint(highPosition);
    }

    public void lower() {
        controller.setSetPoint(lowPosition);
    }

    public boolean atSetPoint() {
        return controller.atSetPoint() || (controller.getSetPoint() == lowPosition && lowLimit.isPressed());
    }

    public MotorEx getArmMotor() {
        return armMotor;
    }
}

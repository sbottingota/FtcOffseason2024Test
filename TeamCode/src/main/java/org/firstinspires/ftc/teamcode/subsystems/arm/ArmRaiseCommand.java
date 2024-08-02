package org.firstinspires.ftc.teamcode.subsystems.arm;

import com.arcrobotics.ftclib.command.CommandBase;

public class ArmRaiseCommand extends CommandBase {
    private final ArmSubsystem subsystem;

    public ArmRaiseCommand(ArmSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        this.subsystem.raise();
    }

    @Override
    public boolean isFinished() {
        return subsystem.atSetPoint();
    }
}

package org.firstinspires.ftc.teamcode.components.arm;

import com.arcrobotics.ftclib.command.CommandBase;

public class ArmLowerCommand extends CommandBase {
    private final ArmSubsystem subsystem;

    public ArmLowerCommand(ArmSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        this.subsystem.lower();
    }

    @Override
    public boolean isFinished() {
        return subsystem.atSetPoint();
    }
}

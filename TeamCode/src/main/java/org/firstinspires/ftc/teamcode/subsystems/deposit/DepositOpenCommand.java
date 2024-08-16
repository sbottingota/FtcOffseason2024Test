package org.firstinspires.ftc.teamcode.subsystems.deposit;

import com.arcrobotics.ftclib.command.CommandBase;

public class DepositOpenCommand extends CommandBase {
    private final DepositSubsystem subsystem;

    public DepositOpenCommand(DepositSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.open();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

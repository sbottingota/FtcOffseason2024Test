package org.firstinspires.ftc.teamcode.subsystems.deposit;

import com.arcrobotics.ftclib.command.CommandBase;

public class DepositCloseCommand extends CommandBase {
    private final DepositSubsystem subsystem;

    public DepositCloseCommand(DepositSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.close();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

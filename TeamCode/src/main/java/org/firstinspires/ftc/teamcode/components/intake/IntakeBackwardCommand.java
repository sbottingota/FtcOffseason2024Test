package org.firstinspires.ftc.teamcode.components.intake;

import com.arcrobotics.ftclib.command.CommandBase;

public class IntakeBackwardCommand extends CommandBase {
    private final IntakeSubsystem subsystem;

    public IntakeBackwardCommand(IntakeSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.backward();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

package org.firstinspires.ftc.teamcode.components.intake;

import com.arcrobotics.ftclib.command.CommandBase;

public class IntakeForwardCommand extends CommandBase {
    private final IntakeSubsystem subsystem;

    public IntakeForwardCommand(IntakeSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.forward();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

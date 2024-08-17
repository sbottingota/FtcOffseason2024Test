package org.firstinspires.ftc.teamcode.components.intake;

import com.arcrobotics.ftclib.command.CommandBase;

public class IntakeStopCommand extends CommandBase {
    private final IntakeSubsystem subsystem;

    public IntakeStopCommand(IntakeSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

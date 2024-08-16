package org.firstinspires.ftc.teamcode.components.drive;

import com.arcrobotics.ftclib.command.CommandBase;

public class DriveCommand extends CommandBase {
    private final DriveSubsystem subsystem;

    public DriveCommand(DriveSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.drive();
    }
}

package org.firstinspires.ftc.teamcode.util.adaptors;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.Subsystem;

public class CommandAction implements Action {
    private final Command command;

    public CommandAction(Command command) {
        this.command = command;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        for (Subsystem subsystem : command.getRequirements()) {
            subsystem.periodic();
        }

        command.execute();
        return command.isFinished();
    }
}

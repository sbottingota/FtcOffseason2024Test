package com.example.meepmeeptesting.trajectories;

import com.acmerobotics.roadrunner.Pose2d;

public class TrajectoryPositions {
    public static final Pose2d[][] STARTING_POSES = {
            {new Pose2d(-58, -23.5, Math.toRadians(0)), new Pose2d(-58, -47, 0)},
            {new Pose2d(-58, 23.5, 0), new Pose2d(-58, 47, 0)}
    };
    public static final Pose2d[][] RANDOMIZATION_POSES = {
            {new Pose2d(11.5, -60, 0), new Pose2d(35, -35, 0), new Pose2d(60, -60, 0)},
            {new Pose2d(11.5, 60, 0), new Pose2d(35, 35, 0), new Pose2d(60, 60, 0)}
    };
    public static final Pose2d[] PARK_POSES = {
            new Pose2d(11.5, -22.5, 180), new Pose2d(11.5, 22.5, 180)
    };
}

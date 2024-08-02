package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.example.meepmeeptesting.trajectories.TrajectoryPositions;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import com.example.meepmeeptesting.colorschemes.*;

public class MeepMeepTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        MeepMeep meepMeep = new MeepMeep(800);

        for (int alliance = 0; alliance < 2; alliance++) {
            for (int startingPlace = 0; startingPlace < 2; ++startingPlace) {
                for (int randomization = 0; randomization < 3; ++randomization) {
                    RoadRunnerBotEntity bot = new DefaultBotBuilder(meepMeep)
                            .setColorScheme(alliance == 0 ? new RedColorScheme() : new BlueColorScheme())
                            .build();

                    Pose2d startPose = TrajectoryPositions.STARTING_POSES[alliance][startingPlace];
                    Pose2d randomizationPose = TrajectoryPositions.RANDOMIZATION_POSES[alliance][randomization];
                    Pose2d parkPose = TrajectoryPositions.PARK_POSES[alliance];

                    bot.runAction(bot.getDrive().actionBuilder(startPose)
                            .setTangent(randomizationPose.heading)
                            .splineToLinearHeading(randomizationPose, randomizationPose.heading)
                            .stopAndAdd((p) -> true)
                            .setTangent(parkPose.heading)
                            .splineToLinearHeading(parkPose, parkPose.heading)
                            .build());

                    meepMeep.addEntity(bot);
                }
            }
        }


        meepMeep.setBackground(MeepMeep.Background.FIELD_ULTIMATEGOAL_INNOV8RZ_DARK)
                .setAxesInterval(5)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .start();
    }
}
package org.firstinspires.ftc.teamcode.eocv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class TestPipeline extends OpenCvPipeline {
    public static final Scalar lower = new Scalar(154, 75, 21);
    public static final Scalar upper = new Scalar(220, 155, 110, 255);
    public static final Size kernelSize = new Size(15, 15);

    @Override
    public Mat processFrame(Mat mat) {
        Mat matCopy = mat.clone();

        Imgproc.blur(matCopy, matCopy, kernelSize);

        Core.inRange(matCopy, lower, upper, matCopy);

        return matCopy;
    }
}

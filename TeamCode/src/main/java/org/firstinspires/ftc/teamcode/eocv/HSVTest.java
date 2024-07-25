package org.firstinspires.ftc.teamcode.eocv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class HSVTest extends OpenCvPipeline {
    public static Scalar lower = new Scalar(10, 195, 145);
    public static Scalar upper = new Scalar(15, 220, 230);
    public static Size blurKernelSize = new Size(5, 5);

    @Override
    public Mat processFrame(Mat mat) {
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);

        Imgproc.blur(mat, mat, blurKernelSize);
        Core.inRange(mat, lower, upper, mat);

        return mat;
    }
}

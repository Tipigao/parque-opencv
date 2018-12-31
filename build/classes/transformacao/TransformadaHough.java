/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Roberto
 */
public class TransformadaHough extends OpenCVVideoCaptura {

    private final String descricao = "Transformada de Hough";

    private double rho;
    private double thetaGraus;
    private double thetaRadianos;
    private int threshold;

    private double cannyThreshold1;
    private double cannyThreshold2;
    private int cannyApertureSize;
    private boolean cannyGradient;
    private double minLineLength;
    private double maxLineGap;
    private int idImg;

    public TransformadaHough() {
        cannyThreshold1 = 300;
        cannyThreshold2 = 600;
        cannyApertureSize = 5;
        cannyGradient = true;

        idImg = 1;
        rho = 1;
        thetaGraus = 180;
        threshold = 10;
        minLineLength = 20;
        maxLineGap = 20;
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return thetaGraus;
    }

    public int getThreshold() {
        return threshold;
    }

    public double getMinLineLength() {
        return minLineLength;
    }

    public double getMaxLineGap() {
        return maxLineGap;
    }

    public double getCannyThreshold1() {
        return cannyThreshold1;
    }

    public double getCannyThreshold2() {
        return cannyThreshold2;
    }

    public int getCannyApertureSize() {
        return cannyApertureSize;
    }

    public boolean getCannyGradient() {
        return cannyGradient;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public void setTheta(double theta) {
        this.thetaGraus = theta;
        this.thetaRadianos = Math.toRadians(theta);
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setMinLineLength(double minLineLength) {
        this.minLineLength = minLineLength;
    }

    public void setMaxLineGap(double maxLineGap) {
        this.maxLineGap = maxLineGap;
    }

    public void setCannyThreshold1(double cannyThreshold1) {
        this.cannyThreshold1 = cannyThreshold1;
    }

    public void setCannyThreshold2(double cannyThreshold2) {
        this.cannyThreshold2 = cannyThreshold2;
    }

    public void setCannyApertureSize(int cannyApertureSize) {
        this.cannyApertureSize = cannyApertureSize;
    }

    public void setCannyGradient(boolean cannyGradient) {
        this.cannyGradient = cannyGradient;
    }

    public void setImgAlvoLinhas(int idImg) {
        this.idImg = idImg;
    }

    @Override
    public Mat processaFrame(Mat imgFrame) {

        Mat imgDestino = new Mat();

        transformadaDeHough(imgFrame, imgDestino, rho, thetaRadianos, threshold, minLineLength, maxLineGap);

        return imgDestino;
    }

    public void transformadaDeHough_Velho(Mat imgOrigem, Mat imgDestino, double rho, double thetaRadianos, int threshold, double minLineLength, double maxLineGap) {
        if (idImg != 1 && idImg != 2) {
            return;
        }

        Mat gray = new Mat(imgOrigem.rows(), imgOrigem.cols(), Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(imgOrigem, gray, Imgproc.COLOR_RGB2GRAY);
        Imgproc.Canny(gray, gray, 70, 110);
        Mat lines = new Mat();
        // 
        Imgproc.HoughLines(gray, lines, rho, thetaRadianos, threshold);

        for (int i = 0; i < lines.cols(); i++) {
            double data[] = lines.get(0, i);
            double rho2 = data[0];
            double theta = data[1];
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);
            double x0 = cosTheta * rho2;
            double y0 = sinTheta * rho2;
            org.opencv.core.Point pt1 = new org.opencv.core.Point(x0 + 10000 * (-sinTheta), y0 + 10000 * cosTheta);
            org.opencv.core.Point pt2 = new org.opencv.core.Point(x0 - 10000 * (-sinTheta), y0 - 10000 * cosTheta);
            Imgproc.line(imgOrigem, pt1, pt2, new Scalar(0, 0, 200), 3);
        }
        //Imgcodecs.imwrite("test2.jpg", im);							
    }

    private void transformadaDeHough(Mat imgOrigem, Mat imgDestino, double rho, double thetaRadianos, int threshold, double minLineLength, double maxLineGap) {
        if (imgOrigem.channels() == 3) {
            Imgproc.cvtColor(imgOrigem, imgDestino, Imgproc.COLOR_BGR2GRAY);
        } else {
            imgOrigem.copyTo(imgDestino);
        }

        //      Canny(     image,      edges, threshold1, threshold2, apertureSize, boolean L2gradient)
        //Imgproc.Canny(imgDestino, imgDestino, cannyThreshold1, cannyThreshold2, cannyApertureSize, cannyGradient);
        Imgproc.Canny(imgDestino, imgDestino, 50, 200, 3, true);

        Mat lines = new Mat();

        //Imgproc.HoughLines(imgDestino, lines, Imgproc.CV_HOUGH_GRADIENT, Math.PI / 180, threshold, minLineSize, lineGap);
        //Imgproc.HoughLines(imgDestino, lines, rho, theta, threshold);
        //Imgproc.HoughLines(imgDestino, lines, Imgproc.CV_HOUGH_GRADIENT, Math.PI / 180, threshold);
        //Imgproc.HoughLines(imgDestino, lines, 1, Math.PI/180, 100);
        //Imgproc.HoughLinesP(imgDestino, lines, 1, Math.PI / 180, 50, 50, 10);
        //public static void HoughLinesP(Mat image, Mat lines, double rho, double theta, int threshold, double minLineLength, double maxLineGap)
        if (idImg == 1 || idImg == 2) {
            //Imgproc.HoughLines(imgDestino, lines, Imgproc.CV_HOUGH_GRADIENT, thetaRadianos, threshold);
            //Imgproc.HoughLines(imgDestino, lines, Imgproc.CV_HOUGH_PROBABILISTIC, thetaRadianos, threshold);
            //Imgproc.HoughLinesP(imgDestino, lines, rho, thetaRadianos, threshold, minLineLength, maxLineGap);
            //Imgproc.HoughLinesP(imgDestino, lines, rho, thetaRadianos, threshold, minLineLength, maxLineGap);
            Imgproc.HoughLinesP(imgDestino, lines, 1, Math.PI / 180, 80, 30, 10);

            aplicarLinhas(lines, idImg == 1 ? imgOrigem : imgDestino);
        }

        /*for (int i = 0; i < lines.cols(); i++) {
            double data[] = lines.get(0, i);
            double rho1 = data[0];
            double theta1 = data[1];
            double cosTheta = Math.cos(theta1);
            double sinTheta = Math.sin(theta1);
            double x0 = cosTheta * rho1;
            double y0 = sinTheta * rho1;
            org.opencv.core.Point pt1 = new org.opencv.core.Point(x0 + 10000 * (-sinTheta), y0 + 10000 * cosTheta);
            org.opencv.core.Point pt2 = new org.opencv.core.Point(x0 - 10000 * (-sinTheta), y0 - 10000 * cosTheta);
            Imgproc.line(imgOrigem, pt1, pt2, new org.opencv.core.Scalar(255, 0, 0), 3);
        }*/

 /*
		for (int x = 0; x < lines.cols(); x++) 
	    {
	          double[] vec = lines.get(0, x);
	          double x1 = vec[0], 
	                 y1 = vec[1],
	                 x2 = vec[2],
	                 y2 = vec[3];
	          org.opencv.core.Point start = new org.opencv.core.Point(x1, y1);
	          org.opencv.core.Point end = new org.opencv.core.Point(x2, y2);

	          Core.line(imgOrigem, start, end, new Scalar(255,0,0), 3);

	    }*/
    }

    public void aplicarLinhas(Mat lines, Mat imgAlvo) {
        /*for (int x = 0; x < lines.cols(); x++) {
            double[] vec = lines.get(0, x);
            double x1 = vec[0],
                    y1 = vec[1],
                    x2 = vec[2],
                    y2 = vec[3];
            org.opencv.core.Point start = new org.opencv.core.Point(x1, y1);
            org.opencv.core.Point end = new org.opencv.core.Point(x2, y2);

            Imgproc.line(imgAlvo, start, end, new Scalar(255, 0, 0), 3);
        }*/
        for (int i = 0; i < lines.cols(); i++) {
            double data[] = lines.get(0, i);
            double rho2 = data[0];
            double theta = data[1];
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);
            double x0 = cosTheta * rho2;
            double y0 = sinTheta * rho2;
            org.opencv.core.Point pt1 = new org.opencv.core.Point(x0 + 10000 * (-sinTheta), y0 + 10000 * cosTheta);
            org.opencv.core.Point pt2 = new org.opencv.core.Point(x0 - 10000 * (-sinTheta), y0 - 10000 * cosTheta);
            Imgproc.line(imgAlvo, pt1, pt2, new Scalar(0, 0, 200), 3);
        }
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

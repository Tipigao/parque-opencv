/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

import captura.CapturaVideo;
import java.awt.Color;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Roberto
 */
public class TransformadaHough extends CapturaVideo {

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
    
    private Color corLinha;
    private int espessuraLinha;
    
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
        
        corLinha = Color.RED;
        espessuraLinha = 1;
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
    
    public Color getCorLinha() {
        return corLinha;
    }
    
    public int getEspessuraLinha() {
        return espessuraLinha;
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
    
    public void setCorLinha(Color corLinha) {
        this.corLinha = corLinha;
    }
    
    public void setEspessuraLinha(int espessuraLinha) {
        this.espessuraLinha = espessuraLinha;
    }

    public void setImgAlvoLinhas(int idImg) {
        this.idImg = idImg;
    }

    @Override
    public Mat processaFrame(Mat imgFrame) {

        Mat imgDestino = new Mat();

        transformadaDeHough(imgFrame, imgDestino);

        return imgDestino;
    }

    public void transformadaDeHough(Mat imgOrigem, Mat imgDestino) {
        if (imgOrigem.channels() == 3) {
            Imgproc.cvtColor(imgOrigem, imgDestino, Imgproc.COLOR_BGR2GRAY);
        } else {
            imgOrigem.copyTo(imgDestino);
        }

        Imgproc.Canny(imgDestino, imgDestino, cannyThreshold1, cannyThreshold2, cannyApertureSize, cannyGradient);

        Mat lines = new Mat();

        //System.out.printf("idImg: %s, rho: %s, thetaRadianos: %s, threshold: %s, minLineLength: %s, maxLineGap: %s\n",
        //      idImg, rho, thetaRadianos, threshold, minLineLength, maxLineGap);
        if (idImg == 1 || idImg == 2) {

            Imgproc.HoughLinesP(imgDestino, lines, rho, thetaRadianos, threshold, minLineLength, maxLineGap);

            aplicarLinhas(lines, idImg == 1 ? imgOrigem : imgDestino);
        }
    }

    public void aplicarLinhas(Mat lines, Mat imgAlvo) {
        Scalar cor = new Scalar(corLinha.getBlue(), corLinha.getGreen(), corLinha.getRed());
        
        for (int i = 0; i < lines.rows(); i++) {
            for (int j = 0; j < lines.cols(); j++) {
                double[] points = lines.get(i, j);
                double x1, y1, x2, y2;

                x1 = points[0];
                y1 = points[1];
                x2 = points[2];
                y2 = points[3];

                Point pt1 = new Point(x1, y1);
                Point pt2 = new Point(x2, y2);

                Imgproc.line(imgAlvo, pt1, pt2, cor, espessuraLinha);
            }
        }

    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

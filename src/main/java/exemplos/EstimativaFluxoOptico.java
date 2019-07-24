/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

import captura.CapturaVideo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.bytedeco.opencv.opencv_core.Point2f;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author robertosilva Exemplos oficiais:
 * https://docs.opencv.org/4.0.1/d2/d1d/samples_2cpp_2lkdemo_8cpp-example.html#a20
 * https://github.com/opencv/opencv/blob/master/samples/java/tutorial_code/TrackingMotion/good_features_to_track/GoodFeaturesToTrackDemo.java
 */
public class EstimativaFluxoOptico extends CapturaVideo {

    private final String descricao = "Estimativa de fluxo óptico";

    private Mat imgCinza;
    private java.awt.Point pontoIni, pontoFim;
    private static final int MAX_CORNERS = 25;
    private int maxCorners = 10;
    private Random rng;

    public EstimativaFluxoOptico() {
        rng = new Random(12345);
    }

    public java.awt.Point getPontotIni() {
        return pontoIni;
    }

    public void setPontoIni(java.awt.Point p) {
        pontoIni = p;
    }

    public java.awt.Point getPontotFim() {
        return pontoFim;
    }

    public void setPontoFim(java.awt.Point p) {
        pontoFim = p;
    }

    @Override
    public Mat processaFrame(Mat imgFrame) {

        Mat imgDestino = imgFrame.clone();

        estimarFluxoOptico(imgFrame, imgDestino);

        if (getPontotIni() != null && getPontotFim() != null) {
            desenhaRetangulo(imgDestino);
        }

        return imgDestino;
    }

    private void estimarFluxoOptico(Mat imgOrigem, Mat imgDestino) {

        imgCinza = new Mat();

        Imgproc.cvtColor(imgOrigem, imgCinza, Imgproc.COLOR_BGR2GRAY);

        maxCorners = Math.max(maxCorners, 1);
        MatOfPoint corners = new MatOfPoint();
        double qualityLevel = 0.01;
        double minDistance = 10;
        int blockSize = 3, gradientSize = 3;
        boolean useHarrisDetector = false;
        double k = 0.04;

        //Mat copy = imgOrigem.clone();
        Imgproc.goodFeaturesToTrack(imgCinza, corners, maxCorners, qualityLevel, minDistance, new Mat(),
                blockSize, gradientSize, useHarrisDetector, k);

        //System.out.println("** Number of corners detected: " + corners.rows());
        int[] cornersData = new int[(int) (corners.total() * corners.channels())];
        corners.get(0, 0, cornersData);
        int radius = 4;
        Mat matCorners = new Mat(corners.rows(), 2, CvType.CV_32F);
        float[] matCornersData = new float[(int) (matCorners.total() * matCorners.channels())];
        matCorners.get(0, 0, matCornersData);
        for (int i = 0; i < corners.rows(); i++) {
            Imgproc.circle(imgDestino, new Point(cornersData[i * 2], cornersData[i * 2 + 1]), radius,
                    new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)), Core.FILLED);

            matCornersData[i * 2] = cornersData[i * 2];
            matCornersData[i * 2 + 1] = cornersData[i * 2 + 1];
        }
        matCorners.put(0, 0, matCornersData);
        Size winSize = new Size(5, 5);
        Size zeroZone = new Size(-1, -1);
        TermCriteria criteria = new TermCriteria(TermCriteria.EPS + TermCriteria.COUNT, 40, 0.001);
        Imgproc.cornerSubPix(imgCinza, matCorners, winSize, zeroZone, criteria);
        matCorners.get(0, 0, matCornersData);

//        for (int i = 0; i < corners.rows(); i++) {
//            System.out.println(
//                    " -- Refined Corner [" + i + "]  (" + matCornersData[i * 2] + "," + matCornersData[i * 2 + 1] + ")");
//        }
    }

    public void finalizaAreaSelecao() {

    }

    private void desenhaRetangulo(Mat img) {
        java.awt.Point p1 = getPontotIni();
        java.awt.Point p2 = getPontotFim();
        Imgproc.rectangle(img, new Point(p1.x, p1.y), new Point(p2.x, p2.y), new Scalar(255, 0, 0), 5);
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

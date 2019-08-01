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
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
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

    private int numMaxCantos;
    private double nivelQualidade;

    private Mat imgCinza, imgCinzaAnt, mascaraAreaDeteccao;
    private java.awt.Point pontoIni, pontoFim;
    private Random rng;
    private Rectangle retang;

    private MatOfPoint2f prevFeatures, nextFeatures;
    private MatOfPoint features;

    private MatOfByte status;
    private MatOfFloat err;

    private boolean exibeMelhoresPontos, exibeRastreamento, exibeLinhasRastreamento, exibeInformacoes;
    
    StringBuilder sbInfo;

    public EstimativaFluxoOptico() {
        rng = new Random(12345);

        features = new MatOfPoint();
        prevFeatures = new MatOfPoint2f();
        nextFeatures = new MatOfPoint2f();
        status = new MatOfByte();
        err = new MatOfFloat();

        exibeInformacoes = true;
        numMaxCantos = 10;
        nivelQualidade = 0.01;
        
        sbInfo = new StringBuilder();
    }

    public int getNumMaxCantos() {
        return numMaxCantos;
    }

    public void setNumMaxCantos(int numMaxCantos) {
        this.numMaxCantos = numMaxCantos;
    }

    public double getNivelQualidade() {
        return nivelQualidade;
    }

    public void setNivelQualidade(double nivelQualidade) {
        this.nivelQualidade = nivelQualidade;
    }
    
    public boolean getExibeMelhoresPontos() {
        return exibeMelhoresPontos;
    }

    public void setExibeMelhoresPontos(boolean exibeMelhoresPontos) {
        this.exibeMelhoresPontos = exibeMelhoresPontos;
        restauraConfiguracaoRastreamento();
    }

    public boolean getExibeLinhasRastreamento() {
        return exibeLinhasRastreamento;
    }

    public void setExibeLinhasRastreamento(boolean exibeLinhasRastreamento) {
        this.exibeLinhasRastreamento = exibeLinhasRastreamento;
    }

    public boolean getExibeRastreamento() {
        return exibeRastreamento;
    }

    public void setExibeRastreamento(boolean exibeRastreamento) {
        this.exibeRastreamento = exibeRastreamento;
        restauraConfiguracaoRastreamento();
    }

    //exibeInformacoes
    public boolean getExibeInformacoes() {
        return exibeInformacoes;
    }

    public void setExibeInformacoes(boolean exibeInformacoes) {
        this.exibeInformacoes = exibeInformacoes;
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

        if (getExibeMelhoresPontos()) {
            analisaMelhoresPontosRastreamento(imgFrame, imgDestino);
            exibeMelhoresPontosRastreamento(imgDestino);
        } else if (getExibeRastreamento()) {
            estimarFluxoOptico(imgFrame, imgDestino);

            exibeCirculosMelhorRastreamento(imgDestino);

            if (getExibeLinhasRastreamento()) {
                exibeLinhasRastreamento(imgDestino);
            }
        }

        if (getPontotIni() != null && getPontotFim() != null) {
            desenhaRetangulo(imgDestino);
        }

        if (exibeInformacoes) {
            exibeInformacoesFerramenta(imgDestino);
        }

        return imgDestino;
    }

    public void restauraConfiguracaoRastreamento() {
        features = new MatOfPoint();
        prevFeatures = new MatOfPoint2f();
        nextFeatures = new MatOfPoint2f();
        status = new MatOfByte();
        err = new MatOfFloat();
        mascaraAreaDeteccao = new Mat();
        imgCinzaAnt = null;
    }

    private void analisaMelhoresPontosRastreamento(Mat imgOrigem, Mat imgDestino) {

        imgCinza = new Mat();

        Imgproc.cvtColor(imgOrigem, imgCinza, Imgproc.COLOR_BGR2GRAY);

        analisaCaracteristicasImagem();

    }

    private void estimarFluxoOptico(Mat imgOrigem, Mat imgDestino) {

        imgCinza = new Mat();

        Imgproc.cvtColor(imgOrigem, imgCinza, Imgproc.COLOR_BGR2GRAY);

        //if (features.toArray().length == 0) {
        if (features.empty()) {
            analisaCaracteristicasImagem();

            prevFeatures.fromList(features.toList());
        }

        imgCinzaAnt = imgCinzaAnt == null ? imgCinza.clone() : imgCinzaAnt;

        Video.calcOpticalFlowPyrLK(imgCinzaAnt, imgCinza, prevFeatures, nextFeatures, status, err);

        imgCinzaAnt = imgCinza.clone();
        prevFeatures.fromList(nextFeatures.toList());
    }

    private void analisaCaracteristicasImagem() {
        double minDistance = 10;
        int blockSize = 3;
        int gradientSize = 3;
        boolean useHarrisDetector = false;
        double k = 0.04;

        //mascaraAreaDeteccao = mascaraAreaDeteccao == null ? new Mat() : mascaraAreaDeteccao;
        
        //mascaraAreaDeteccao = Mat.zeros(imgCinza.size(), CvType.CV_8U);
        mascaraAreaDeteccao = new Mat();
        
        if(mascaraAreaDeteccao.empty()){
            //mascaraAreaDeteccao.adjustROI(50, 50, 50, 50);
        }

        //Mat copy = imgOrigem.clone();
        Imgproc.goodFeaturesToTrack(
                imgCinza,
                features,
                getNumMaxCantos(),
                getNivelQualidade(),
                minDistance,
                mascaraAreaDeteccao,
                blockSize,
                gradientSize,
                useHarrisDetector,
                k);
    }

    public void finalizaAreaSelecao() {
        java.awt.Point p1 = getPontotIni();
        java.awt.Point p2 = getPontotFim();

        features = new MatOfPoint();
        prevFeatures = new MatOfPoint2f();
        nextFeatures = new MatOfPoint2f();
        status = new MatOfByte();
        err = new MatOfFloat();

        retang = new Rectangle(p1, new Dimension((int) p2.getX(), (int) p2.getY()));

        //mascaraAreaDeteccao = Mat.zeros(imgCinza.size(), CvType.CV_8U); 
        //mascaraAreaDeteccao = new Mat();

        setPontoIni(null);
        setPontoFim(null);
    }

    private void desenhaRetangulo(Mat img) {
        java.awt.Point p1 = getPontotIni();
        java.awt.Point p2 = getPontotFim();

        if (p1 == null || p2 == null) {
            return;
        }

        retang = null;

        java.awt.Point p = getPosicaoImagem();
        java.awt.Dimension d = getTamanhoImagem();

        int px = (int) p.getX(),
                py = (int) p.getY();

        int p1x = (int) p1.getX() - px,
                p1y = (int) p1.getY() - py,
                p2x = (int) p2.getX() - px,
                p2y = (int) p2.getY() - py;

        double razaoImg = img.size().width / d.getWidth();

        p1x *= razaoImg;
        p1y *= razaoImg;
        p2x *= razaoImg;
        p2y *= razaoImg;

        int lx = (int) img.size().width,
                ly = (int) img.size().height;

        p1x = p1x < 0 ? 0 : p1x;
        p2x = p2x < 0 ? 0 : p2x;

        p1x = p1x > lx ? lx - 1 : p1x;
        p2x = p2x > lx ? lx - 1 : p2x;

        p1y = p1y < 0 ? 0 : p1y;
        p2y = p2y < 0 ? 0 : p2y;

        p1y = p1y > ly ? ly - 1 : p1y;
        p2y = p2y > ly ? ly - 1 : p2y;

//        if ((p1x < 0 && p2x < 0)
//                || (p1x > lx && p2x > lx)
//                || (p1y < 0 && p2y < 0)
//                || (p1y > ly && p2y > ly)) {
//            return;
//        }
        Imgproc.rectangle(img, new Point(p1x, p1y), new Point(p2x, p2y), new Scalar(0, 0, 255), (int) Math.floor(1 / razaoImg));
    }

    private void exibeCirculosMelhorRastreamento(Mat img) {
        List<Point> drawFeature = nextFeatures.toList();
        for (int i = 0; i < drawFeature.size(); i++) {
            Point p = drawFeature.get(i);
            Imgproc.circle(img, p, 5, new Scalar(255));
        }
    }

    private void exibeMelhoresPontosRastreamento(Mat img) {
        //System.out.println("** Number of corners detected: " + corners.rows());
        int[] cornersData = new int[(int) (features.total() * features.channels())];
        features.get(0, 0, cornersData);
        int radius = 4;
        Mat matCorners = new Mat(features.rows(), 2, CvType.CV_32F);
        float[] matCornersData = new float[(int) (matCorners.total() * matCorners.channels())];
        matCorners.get(0, 0, matCornersData);
        for (int i = 0; i < features.rows(); i++) {
            Imgproc.circle(img, new Point(cornersData[i * 2], cornersData[i * 2 + 1]), radius,
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

    private void exibeLinhasRastreamento(Mat img) {
        List<Point> prevList = features.toList(), nextList = nextFeatures.toList();
        Scalar color = new Scalar(255);

        for (int i = 0; i < prevList.size(); i++) {
            Imgproc.line(img, prevList.get(i), nextList.get(i), color);
        }
    }

    private void exibeInformacoesFerramenta(Mat img) {
        sbInfo.delete(0, sbInfo.length());
        
        sbInfo.append(numMaxCantos<=0 ? "Sem limite de cantos: " : "Limite de cantos: ")
                .append((int)features.size().height);
        
        
        
        Imgproc.putText(
                img, // Matrix obj of the image
                sbInfo.toString(), // Text to be added
                new Point(5, 15), // point
                0, // front face
                0.4, // front scale
                new Scalar(0, 255, 0), // Scalar object for color
                1 // Thickness
        );

    }

    @Override
    public String getDescricao() {
        return descricao;
    }

}

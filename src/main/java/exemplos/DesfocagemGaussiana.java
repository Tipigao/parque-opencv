/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

import captura.CapturaVideo;
import java.awt.Color;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Roberto
 */
public class DesfocagemGaussiana extends CapturaVideo {
    
    private final String descricao = "Desfocagem Gaussiana";

    private int sigmaX;
    private int sigmaY;
    private int tamanhoX;
    private int tamanhoY;
    
    public DesfocagemGaussiana() {
        sigmaX = 10;
        sigmaY = 10;
        tamanhoX = 100;
        tamanhoY = 100;
    }

    public int getSigmaX() {
        return sigmaX;
    }

    public int getSigmaY() {
        return sigmaY;
    }
    
    public int getTamanhoX() {
        return tamanhoX;
    }
    
    public int getTamanhoY() {
        return tamanhoY;
    }
    
    public void setSigmaX(int sigmaX) {
        this.sigmaX = sigmaX;
    }
    
    public void setSigmaY(int sigmaY) {
        this.sigmaY = sigmaY;
    }

    public void setTamanhoX(int tamanhoX) {
        this.tamanhoX = tamanhoX;
    }
    
    public void setTamanhoY(int tamanhoY) {
        this.tamanhoY = tamanhoY;
    }

    @Override
    public Mat processaFrame(Mat imgFrame) {

        Mat imgDestino = imgFrame.clone();
        Imgproc.GaussianBlur(imgDestino, imgDestino, new org.opencv.core.Size(getTamanhoX(), getTamanhoY()), getSigmaX(), getSigmaY());

        return imgDestino;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
    
}

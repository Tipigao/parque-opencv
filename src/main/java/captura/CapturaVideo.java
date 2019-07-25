/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import util.JPanelImageUtil;

/**
 *
 * @author Roberto
 */
public abstract class CapturaVideo extends Observable implements Runnable, IFrameOpenCV {

    private VideoCapture camera;
    private Thread tarefa;
    private boolean capturaEmAndamento;
    private boolean exibicaoInvertida;
    private java.awt.Point posicaoImagem;
    private java.awt.Dimension dimensoesImagem;
    
    public void iniciarCaptura() {
        capturaEmAndamento = true;
        if (tarefa != null) {
            tarefa.interrupt();
        }

        tarefa = new Thread(this);
        tarefa.start();
    }

    public void pararCaptura() {
        try {
            capturaEmAndamento = false;
            tarefa.interrupt();
            tarefa.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(CapturaVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setExibicaoInvertida(boolean exibicaoInvertida) {
        this.exibicaoInvertida = exibicaoInvertida;
    }

    public boolean getExibicaoInvertida() {
        return exibicaoInvertida;
    }
    
    @Override
    public java.awt.Point getPosicaoImagem(){
        return posicaoImagem;
    }
    
    @Override
    public void setPosicaoImagem(java.awt.Point posicaoImagem){
        this.posicaoImagem = posicaoImagem;
    }
    
    @Override
    public java.awt.Dimension getTamanhoImagem(){
        return dimensoesImagem;
    }
    
    @Override
    public void setTamanhoImagem(java.awt.Dimension dimensoesImagem){
        this.dimensoesImagem = dimensoesImagem;
    }

    @Override
    public void run() {
        leCamera();
    }

    private void leCamera() {
        try {
            System.out.println(new Date() + ": " + getDescricao() + " iniciado");
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            //nu.pattern.OpenCV.loadShared();
            //nu.pattern.OpenCV.loadLocally(); // Use in case loadShared() doesn't work
            for (int i = 0; i < 10; i++) {
                camera = new VideoCapture(i);
                //camera.open(i);
                if (camera.isOpened()) {
                    break;
                }
            }

            if (!camera.isOpened()) {
                throw new Exception("Nenhuma câmera disponível foi localizada");
            }

            Mat imgFrame = new Mat();

            while (capturaEmAndamento) {
                camera.read(imgFrame);
                if (imgFrame.empty()) {
                    continue;
                }

                if (getExibicaoInvertida()) {
                    org.opencv.core.Core.flip(imgFrame, imgFrame, +1);
                }

                Mat imgProcessada = processaFrame(imgFrame);
                
                BufferedImage buffImg1 = matToBufferedImage(imgFrame);
                BufferedImage buffImg2 = matToBufferedImage(imgProcessada);
                setChanged();
                notifyObservers(new BufferedImage[]{buffImg1, buffImg2});
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(new Date() + ": " + getDescricao() + " finalizado");
            if (camera != null) {
                camera.release();
            }
        }
    }

    /*private void exibeImagem(Mat imgOriginal, Mat imgProcessada) {
        try {

                MatOfByte matOfByte = new MatOfByte();

                Imgcodecs.imencode(".png", imgProcessada, matOfByte);
                
                byte[] byteArray = matOfByte.toArray();

                InputStream in = new ByteArrayInputStream(byteArray);
                BufferedImage bufImagew = ImageIO.read(in);

                pnlExibicao.getGraphics().drawImage(bufImagew,0,0,null);
                
                //pnlExibicao.repaint();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }*/
    public BufferedImage matToBufferedImage(Mat img) {
        BufferedImage bufImg = null;
        try {

            //if(img.width()==0 && img.height()==0)
            //    return new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);
            MatOfByte matOfByte = new MatOfByte();

            Imgcodecs.imencode(".png", img, matOfByte);

            byte[] byteArray = matOfByte.toArray();

            InputStream in = new ByteArrayInputStream(byteArray);
            bufImg = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImg;
    }
}

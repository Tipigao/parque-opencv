/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

import captura.CapturaVideo;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Roberto
 */
public class DetectaCantosHarris extends CapturaVideo {

    private final String descricao = "Detecção de cantos Harris";

    @Override
    public Mat processaFrame(Mat imgFrame) {
        Mat imgDestino = new Mat();

        detectaCantosHarris(imgFrame, imgDestino);

        return imgDestino;
    }
    
    private void detectaCantosHarris(Mat imgOrigem, Mat imgDestino){
        
        Mat gray = new Mat(imgOrigem.rows(), imgOrigem.cols(), Imgproc.COLOR_BGR2GRAY);
        
        Imgproc.cvtColor(imgOrigem, gray, Imgproc.COLOR_RGB2GRAY);
        
        Imgproc.cornerHarris(gray, imgDestino, 2, 3, 0.04d, Core.BORDER_DEFAULT);
        
        //Imgproc.dilate(gray, gray, gray);
        
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

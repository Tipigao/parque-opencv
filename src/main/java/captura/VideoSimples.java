/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura;

import org.opencv.core.Mat;

/**
 *
 * @author Roberto
 */
public class VideoSimples extends CapturaVideo{
    private final String descricao = "Vídeo simples da câmera sem efeitos";
    
    @Override
    public Mat processaFrame(Mat imgFrame) {
        return imgFrame;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}

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
public interface IFrameOpenCV {

    public Mat processaFrame(Mat imgFrame);

    public String getDescricao();
    
    public java.awt.Dimension getTamanhoImagem();
    
    public void setTamanhoImagem(java.awt.Dimension posicaoImagem);
    
    public void setPosicaoImagem(java.awt.Point posicaoImagem);
    
    public java.awt.Point getPosicaoImagem();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura;

import javax.swing.JPanel;

/**
 *
 * @author Roberto
 */
public interface ICapturaVideoUI {
    public boolean cameraDisponivel();
    public void iniciar();
    public void parar();
    public void setPainelExibicao(JPanel painel);
    public void setRenderizaMiniaturaProcessada(boolean renderizaMiniaturaProcessada);
    public void setExibicaoInvertida(boolean exibicaoInvertida);
    public boolean getExibicaoInvertida();
    public void setPausa(boolean bPausa);
}

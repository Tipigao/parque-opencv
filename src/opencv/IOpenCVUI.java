/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Roberto
 */
public interface IOpenCVUI {
    public boolean cameraEstaPronta();
    public void iniciar();
    public void parar();
    public void setPainelExibicao(JPanel painel);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacao;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import opencv.IOpenCVUI;

/**
 *
 * @author Roberto
 */
public class VideoSimplesUI extends javax.swing.JPanel implements IOpenCVUI, Observer {

    private JPanel pnlExibicao;
    private final VideoSimples obj;
    private boolean cameraDisponivel;
    
    /**
     * Creates new form VideoSimplesUI
     */
    public VideoSimplesUI() {
        initComponents();
        
        cameraDisponivel = false;
        
        obj = new VideoSimples();
        obj.addObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public boolean cameraEstaPronta() {
        return cameraDisponivel;
    }
    
    @Override
    public void iniciar() {
        obj.iniciarCaptura();
    }

    @Override
    public void parar() {
        obj.pararCaptura();
    }

    @Override
    public void setPainelExibicao(JPanel painel) {
        pnlExibicao = painel;
    }

    @Override
    public void update(Observable o, Object arg) {
        BufferedImage[] bufImgs = (BufferedImage[]) arg;
        pnlExibicao.getGraphics().drawImage(bufImgs[0], 0, 0, null);
        cameraDisponivel = true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

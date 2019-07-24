/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captura;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import util.JPanelImageUtil;

/**
 *
 * @author Roberto
 */
public class VideoSimplesUI extends javax.swing.JPanel implements ICapturaVideoUI, Observer  {
    
    private JPanel pnlExibicao;
    private final VideoSimples obj;
    private boolean camDisponivel;
    private boolean renderizaMiniaturaProcessada;
    
    /**
     * Creates new form VideoSimplesUI
     */
    public VideoSimplesUI() {
        initComponents();
        
        camDisponivel = false;
        
        obj = new VideoSimples();
        obj.addObserver(this);
    }
    
     @Override
    public boolean cameraDisponivel() {
        return camDisponivel;
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
    public void setRenderizaMiniaturaProcessada(boolean renderizaMiniaturaProcessada) {
        this.renderizaMiniaturaProcessada = renderizaMiniaturaProcessada;
    }
    
    @Override
    public void setExibicaoInvertida(boolean exibicaoInvertida) {
        obj.setExibicaoInvertida(exibicaoInvertida);
    }
    
    @Override
    public boolean getExibicaoInvertida() {
        return obj.getExibicaoInvertida();
    }

    @Override
    public void update(Observable o, Object arg) {
        BufferedImage[] bufImgs = (BufferedImage[]) arg;
        //pnlExibicao.getGraphics().drawImage(bufImgs[0], 0, 0, null);
        //pnlExibicao.getGraphics().drawImage(bufImgs[0], 0, 0, this.getHeight(), this.getWidth(), null);
        JPanelImageUtil.drawImageWithAspectRatio(pnlExibicao, bufImgs[0]);
        camDisponivel = true;
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
            .addGap(0, 138, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

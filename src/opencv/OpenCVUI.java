/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import java.util.logging.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Roberto
 */
public class OpenCVUI extends javax.swing.JFrame {

    /**
     * Creates new form OpenCVUI
     */
    public OpenCVUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlImagem = new javax.swing.JPanel();
        pnlControles = new javax.swing.JPanel();
        cboDemonstracao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnVisualizar = new javax.swing.JButton();
        btnPararExibicao = new javax.swing.JButton();
        pnlControleItem = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlImagem.setBackground(new java.awt.Color(0, 102, 102));
        pnlImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlImagemLayout = new javax.swing.GroupLayout(pnlImagem);
        pnlImagem.setLayout(pnlImagemLayout);
        pnlImagemLayout.setHorizontalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        pnlImagemLayout.setVerticalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cboDemonstracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Selecione...",
            "Transformada de Hough"
        }));
        cboDemonstracao.setSelectedItem("Selecione...");
        cboDemonstracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDemonstracaoActionPerformed(evt);
            }
        });

        jLabel1.setText("Aplicação");

        btnVisualizar.setText("Exibir");
        btnVisualizar.setEnabled(false);
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnPararExibicao.setText("Parar");
        btnPararExibicao.setEnabled(false);
        btnPararExibicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararExibicaoActionPerformed(evt);
            }
        });

        pnlControleItem.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout pnlControlesLayout = new javax.swing.GroupLayout(pnlControles);
        pnlControles.setLayout(pnlControlesLayout);
        pnlControlesLayout.setHorizontalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlControleItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlesLayout.createSequentialGroup()
                        .addComponent(btnPararExibicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizar)))
                .addContainerGap())
        );
        pnlControlesLayout.setVerticalGroup(
            pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDemonstracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPararExibicao)
                    .addComponent(btnVisualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlControleItem, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        mnuArquivo.setText("Arquivo");

        mnuSair.setText("Sair");
        mnuArquivo.add(mnuSair);

        jMenuBar1.add(mnuArquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (objDemo != null) {
            objDemo.parar();
        }

        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        if (cboDemonstracao.getSelectedIndex() == 1) {
            exibeVideoCamera();
        }
        //btnVisualizar.setEnabled(false);
        //btnPararExibicao.setEnabled(true);
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void cboDemonstracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDemonstracaoActionPerformed
        javax.swing.JComboBox cbo = (javax.swing.JComboBox) evt.getSource();
        exibeVideoCamera();
        //btnVisualizar.setEnabled(!btnPararExibicao.isEnabled() && cbo.getSelectedIndex() > 0);
    }//GEN-LAST:event_cboDemonstracaoActionPerformed

    private void btnPararExibicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararExibicaoActionPerformed
        exibeVideoCamera();
        //btnPararExibicao.setEnabled(false);
        //btnVisualizar.setEnabled(true);
    }//GEN-LAST:event_btnPararExibicaoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultComboBoxModel opt = new DefaultComboBoxModel(enumerador.TipoTransformacao.values());
        opt.insertElementAt("Selecione...", 0);
        cboDemonstracao.setModel(opt);
        cboDemonstracao.setSelectedIndex(0);
    }//GEN-LAST:event_formWindowOpened

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpenCVUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenCVUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenCVUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenCVUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OpenCVUI janela = new OpenCVUI();
                centralizarJanela(janela);
                janela.setVisible(true);
            }
        });
    }

    public void exibeVideoCamera() {
        try {
            String nmClasse = null;

            if (objDemo != null) {
                objDemo.parar();
                pnlImagem.setBackground(new java.awt.Color(0, 102, 102));
                pnlImagem.revalidate();
                pnlImagem.repaint();

                pnlControleItem.removeAll();
                pnlControleItem.revalidate();
                pnlControleItem.repaint();
            }

            if (cboDemonstracao.getSelectedIndex() > 0) {
                enumerador.TipoTransformacao tpt = (enumerador.TipoTransformacao) cboDemonstracao.getSelectedItem();
                nmClasse = tpt.getClasse();
            } else {
                nmClasse = "transformacao.VideoSimples";
            }

            objDemo = (IOpenCVUI) Class.forName(nmClasse + "UI").newInstance();
            javax.swing.JPanel pnlDemo = (javax.swing.JPanel) objDemo;
            //System.out.println(pnlDemo.getPreferredSize());
            pnlControleItem.add(pnlDemo);

            //pnlControleItem.setSize(new Dimension(600, 350));
            objDemo.setPainelExibicao(pnlImagem);
            objDemo.iniciar();
            pnlDemo.setVisible(true);

            new Thread() {
                @Override
                public void run() {
                    cboDemonstracao.setEnabled(false);
                    while (!objDemo.cameraEstaPronta()) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(OpenCVUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    cboDemonstracao.setEnabled(true);
                    cboDemonstracao.requestFocus();
                }
            }.start();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OpenCVUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OpenCVUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OpenCVUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void centralizarJanela(javax.swing.JFrame frame) {
        java.awt.Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    private IOpenCVUI objDemo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPararExibicao;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox<String> cboDemonstracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenuItem mnuSair;
    private javax.swing.JPanel pnlControleItem;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JPanel pnlImagem;
    // End of variables declaration//GEN-END:variables
}

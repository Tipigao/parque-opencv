/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

import captura.ICapturaVideoUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import captura.IFrameOpenCV;
import javax.swing.JColorChooser;
import util.JPanelImageUtil;
import util.StringUtil;

/**
 *
 * @author Roberto
 */
public class TransformadaHoughUI extends javax.swing.JPanel implements ICapturaVideoUI, Observer {

    private JPanel pnlExibicao;
    private TransformadaHough obj;
    private boolean camDisponivel;
    private boolean renderizaMiniaturaProcessada;

    /**
     * Creates new form TransformadaHoughUI
     */
    public TransformadaHoughUI() {
        initComponents();

        obj = new TransformadaHough();
        obj.addObserver(this);

        sldDistancia.setValue((int) obj.getRho());
        sldAngulo.setValue((int) obj.getTheta());
        sldLimite.setValue(obj.getThreshold());
        sldTamMinLinha.setValue((int) obj.getMinLineLength());
        sldDiferencaLinha.setValue((int) obj.getMaxLineGap());
        sldHisterese1.setValue((int) obj.getCannyThreshold1());
        sldHisterese2.setValue((int) obj.getCannyThreshold2());
        sldSobel.setValue(obj.getCannyApertureSize());
        sldEspessuraLinha.setValue(obj.getEspessuraLinha());

        spnDistancia.setValue((int) obj.getRho());
        spnAngulo.setValue((int) obj.getTheta());
        spnLimite.setValue(obj.getThreshold());
        spnTamMinLinha.setValue((int) obj.getMinLineLength());
        spnDiferencaLinha.setValue((int) obj.getMaxLineGap());
        spnHisterese1.setValue((int) obj.getCannyThreshold1());
        spnHisterese2.setValue((int) obj.getCannyThreshold2());
        spnSobel.setValue(obj.getCannyApertureSize());
        sldEspessuraLinha.setValue(obj.getEspessuraLinha());

        cbxGradiente.setSelected(obj.getCannyGradient());

        camDisponivel = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioImgExibicao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sldHisterese1 = new javax.swing.JSlider();
        spnHisterese1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        sldHisterese2 = new javax.swing.JSlider();
        spnHisterese2 = new javax.swing.JSpinner();
        lblSobel = new javax.swing.JLabel();
        sldSobel = new javax.swing.JSlider();
        spnSobel = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        cbxGradiente = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sldDistancia = new javax.swing.JSlider();
        spnDistancia = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        sldAngulo = new javax.swing.JSlider();
        spnAngulo = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        sldLimite = new javax.swing.JSlider();
        spnLimite = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        sldTamMinLinha = new javax.swing.JSlider();
        spnTamMinLinha = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        sldDiferencaLinha = new javax.swing.JSlider();
        spnDiferencaLinha = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        radImgOriginal = new javax.swing.JRadioButton();
        radImgContorno = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbxLinhas = new javax.swing.JCheckBox();
        lblNada = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCorLinha = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sldEspessuraLinha = new javax.swing.JSlider();
        spnEspessuraLinha = new javax.swing.JSpinner();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detecção de contorno (Bordas de Canny)"));
        jPanel1.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("1º limiar histerese");
        jPanel1.add(jLabel4);

        sldHisterese1.setMaximum(2000);
        sldHisterese1.setMinimum(1);
        sldHisterese1.setValue(600);
        sldHisterese1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldHisterese1StateChanged(evt);
            }
        });
        jPanel1.add(sldHisterese1);

        spnHisterese1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnHisterese1StateChanged(evt);
            }
        });
        jPanel1.add(spnHisterese1);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("2º limiar histerese");
        jPanel1.add(jLabel5);

        sldHisterese2.setMaximum(2000);
        sldHisterese2.setMinimum(1);
        sldHisterese2.setValue(300);
        sldHisterese2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldHisterese2StateChanged(evt);
            }
        });
        jPanel1.add(sldHisterese2);

        spnHisterese2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnHisterese2StateChanged(evt);
            }
        });
        jPanel1.add(spnHisterese2);

        lblSobel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSobel.setText("Abertura Sobel");
        jPanel1.add(lblSobel);

        sldSobel.setMaximum(7);
        sldSobel.setMinimum(-1);
        sldSobel.setValue(5);
        sldSobel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSobelStateChanged(evt);
            }
        });
        jPanel1.add(sldSobel);

        spnSobel.setModel(new javax.swing.SpinnerNumberModel(3, -1, 7, 2));
        spnSobel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSobelStateChanged(evt);
            }
        });
        jPanel1.add(spnSobel);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gradiente");
        jPanel1.add(jLabel7);

        cbxGradiente.setSelected(true);
        cbxGradiente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbxGradienteStateChanged(evt);
            }
        });
        jPanel1.add(cbxGradiente);
        cbxGradiente.getAccessibleContext().setAccessibleName("cboGradiente");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Transformada de Hough"));
        jPanel2.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Distâcia em pixels");
        jPanel2.add(jLabel1);

        sldDistancia.setMaximum(500);
        sldDistancia.setMinimum(1);
        sldDistancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDistanciaStateChanged(evt);
            }
        });
        jPanel2.add(sldDistancia);

        spnDistancia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDistanciaStateChanged(evt);
            }
        });
        jPanel2.add(spnDistancia);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ângulo");
        jPanel2.add(jLabel2);

        sldAngulo.setMaximum(360);
        sldAngulo.setMinimum(1);
        sldAngulo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAnguloStateChanged(evt);
            }
        });
        jPanel2.add(sldAngulo);

        spnAngulo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAnguloStateChanged(evt);
            }
        });
        jPanel2.add(spnAngulo);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Limite");
        jPanel2.add(jLabel3);

        sldLimite.setMinimum(1);
        sldLimite.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldLimiteStateChanged(evt);
            }
        });
        jPanel2.add(sldLimite);

        spnLimite.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnLimiteStateChanged(evt);
            }
        });
        jPanel2.add(spnLimite);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tamanho mín. linha");
        jPanel2.add(jLabel8);

        sldTamMinLinha.setMaximum(500);
        sldTamMinLinha.setMinimum(1);
        sldTamMinLinha.setValue(20);
        sldTamMinLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldTamMinLinhaStateChanged(evt);
            }
        });
        jPanel2.add(sldTamMinLinha);

        spnTamMinLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTamMinLinhaStateChanged(evt);
            }
        });
        jPanel2.add(spnTamMinLinha);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Diferença da linha");
        jPanel2.add(jLabel6);

        sldDiferencaLinha.setMaximum(500);
        sldDiferencaLinha.setMinimum(1);
        sldDiferencaLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDiferencaLinhaStateChanged(evt);
            }
        });
        jPanel2.add(sldDiferencaLinha);

        spnDiferencaLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDiferencaLinhaStateChanged(evt);
            }
        });
        jPanel2.add(spnDiferencaLinha);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        radioImgExibicao.add(radImgOriginal);
        radImgOriginal.setSelected(true);
        radImgOriginal.setText("Original");
        radImgOriginal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radImgOriginalItemStateChanged(evt);
            }
        });
        jPanel3.add(radImgOriginal);

        radioImgExibicao.add(radImgContorno);
        radImgContorno.setText("Contorno");
        radImgContorno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radImgContornoItemStateChanged(evt);
            }
        });
        jPanel3.add(radImgContorno);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Linhas de exibição"));
        jPanel5.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Exibir linhas");
        jPanel5.add(jLabel15);

        cbxLinhas.setSelected(true);
        cbxLinhas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbxLinhasStateChanged(evt);
            }
        });
        cbxLinhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLinhasActionPerformed(evt);
            }
        });
        jPanel5.add(cbxLinhas);
        jPanel5.add(lblNada);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cor");
        jPanel5.add(jLabel12);

        txtCorLinha.setText("FF0000");
        txtCorLinha.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCorLinhaCaretUpdate(evt);
            }
        });
        jPanel5.add(txtCorLinha);

        lblCor.setBackground(new java.awt.Color(255, 0, 0));
        lblCor.setOpaque(true);
        lblCor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCorMousePressed(evt);
            }
        });
        jPanel5.add(lblCor);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Espessura");
        jPanel5.add(jLabel13);

        sldEspessuraLinha.setMaximum(50);
        sldEspessuraLinha.setMinimum(1);
        sldEspessuraLinha.setValue(3);
        sldEspessuraLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldEspessuraLinhaStateChanged(evt);
            }
        });
        jPanel5.add(sldEspessuraLinha);

        spnEspessuraLinha.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnEspessuraLinhaStateChanged(evt);
            }
        });
        jPanel5.add(spnEspessuraLinha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.getAccessibleContext().setAccessibleName("Ajustes de linha");
        jPanel5.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos de componentes">
    private void sldDistanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDistanciaStateChanged
        int vl = (int) sldDistancia.getValue();
        obj.setRho(vl);
        spnDistancia.setValue(vl);
    }//GEN-LAST:event_sldDistanciaStateChanged

    private void spnDistanciaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDistanciaStateChanged
        int vl = (int) spnDistancia.getValue();
        obj.setRho(vl);
        sldDistancia.setValue(vl);
    }//GEN-LAST:event_spnDistanciaStateChanged

    private void sldAnguloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAnguloStateChanged
        int vl = (int) sldAngulo.getValue();
        obj.setTheta(vl);
        spnAngulo.setValue(vl);
    }//GEN-LAST:event_sldAnguloStateChanged

    private void spnAnguloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnguloStateChanged
        int vl = (int) spnAngulo.getValue();
        obj.setTheta(vl);
        sldAngulo.setValue(vl);
    }//GEN-LAST:event_spnAnguloStateChanged

    private void sldLimiteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldLimiteStateChanged
        int vl = (int) sldLimite.getValue();
        obj.setThreshold(vl);
        spnLimite.setValue(vl);
    }//GEN-LAST:event_sldLimiteStateChanged

    private void spnLimiteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnLimiteStateChanged
        int vl = (int) spnLimite.getValue();
        obj.setThreshold(vl);
        sldLimite.setValue(vl);
    }//GEN-LAST:event_spnLimiteStateChanged

    private void sldHisterese1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldHisterese1StateChanged
        int vl = (int) sldHisterese1.getValue();
        obj.setCannyThreshold1(vl);
        spnHisterese1.setValue(vl);
    }//GEN-LAST:event_sldHisterese1StateChanged

    private void spnHisterese1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnHisterese1StateChanged
        int vl = (int) spnHisterese1.getValue();
        obj.setCannyThreshold1(vl);
        sldHisterese1.setValue(vl);
    }//GEN-LAST:event_spnHisterese1StateChanged

    private void sldHisterese2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldHisterese2StateChanged
        int vl = (int) sldHisterese2.getValue();
        obj.setCannyThreshold2(vl);
        spnHisterese2.setValue(vl);
    }//GEN-LAST:event_sldHisterese2StateChanged

    private void spnHisterese2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnHisterese2StateChanged
        int vl = (int) spnHisterese2.getValue();
        obj.setCannyThreshold2(vl);
        sldHisterese2.setValue(vl);
    }//GEN-LAST:event_spnHisterese2StateChanged

    private void sldSobelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSobelStateChanged
        int vl = (int) sldSobel.getValue();
        setVlSobel(vl);
        spnSobel.setValue(vl);
    }//GEN-LAST:event_sldSobelStateChanged

    private void spnSobelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSobelStateChanged
        int vl = (int) spnSobel.getValue();
        setVlSobel(vl);
        sldSobel.setValue(vl);
    }//GEN-LAST:event_spnSobelStateChanged

    private void cbxGradienteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxGradienteStateChanged
        obj.setCannyGradient(cbxGradiente.isSelected());
    }//GEN-LAST:event_cbxGradienteStateChanged

    private void sldTamMinLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldTamMinLinhaStateChanged
        int vl = (int) sldTamMinLinha.getValue();
        obj.setMinLineLength(vl);
        spnTamMinLinha.setValue(vl);
    }//GEN-LAST:event_sldTamMinLinhaStateChanged

    private void sldDiferencaLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDiferencaLinhaStateChanged
        int vl = (int) sldDiferencaLinha.getValue();
        obj.setMaxLineGap(vl);
        spnDiferencaLinha.setValue(vl);
    }//GEN-LAST:event_sldDiferencaLinhaStateChanged

    private void spnTamMinLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTamMinLinhaStateChanged
        int vl = (int) spnTamMinLinha.getValue();
        obj.setMinLineLength(vl);
        sldTamMinLinha.setValue(vl);
    }//GEN-LAST:event_spnTamMinLinhaStateChanged

    private void spnDiferencaLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDiferencaLinhaStateChanged
        int vl = (int) spnDiferencaLinha.getValue();
        obj.setMaxLineGap(vl);
        sldDiferencaLinha.setValue(vl);
    }//GEN-LAST:event_spnDiferencaLinhaStateChanged

    private void radImgOriginalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radImgOriginalItemStateChanged
        obj.setImgAlvoLinhas(cbxLinhas.isSelected() ? 1 : 0);
    }//GEN-LAST:event_radImgOriginalItemStateChanged

    private void radImgContornoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radImgContornoItemStateChanged
        obj.setImgAlvoLinhas(cbxLinhas.isSelected() ? 2 : 0);
    }//GEN-LAST:event_radImgContornoItemStateChanged

    private void cbxLinhasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxLinhasStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLinhasStateChanged

    private void sldEspessuraLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldEspessuraLinhaStateChanged
        int vl = (int) sldEspessuraLinha.getValue();
        obj.setEspessuraLinha(vl);
        spnEspessuraLinha.setValue(vl);
    }//GEN-LAST:event_sldEspessuraLinhaStateChanged

    private void spnEspessuraLinhaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnEspessuraLinhaStateChanged
        int vl = (int) spnEspessuraLinha.getValue();
        if (vl <= 0) {
            vl = 1;
            spnEspessuraLinha.setValue(vl);
        }
        obj.setEspessuraLinha(vl);
        sldEspessuraLinha.setValue(vl);
    }//GEN-LAST:event_spnEspessuraLinhaStateChanged

    private void cbxLinhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLinhasActionPerformed
        obj.setImgAlvoLinhas(cbxLinhas.isSelected() ? (radImgOriginal.isSelected() ? 1 : 2) : 0);
    }//GEN-LAST:event_cbxLinhasActionPerformed

    private void txtCorLinhaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCorLinhaCaretUpdate
        Color cor = obj.getCorLinha();
        try {
            String strCor = txtCorLinha.getText().replace("#", "");

            if (strCor.length() != 6) {
                return;
            }

            cor = StringUtil.hexToColor(strCor);
            txtCorLinha.setForeground(Color.BLACK);
        } catch (Exception e) {
            txtCorLinha.setForeground(Color.RED);
        }

        obj.setCorLinha(cor);
        lblCor.setBackground(cor);
    }//GEN-LAST:event_txtCorLinhaCaretUpdate

    private void lblCorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCorMouseClicked
        //selecionaCor();
    }//GEN-LAST:event_lblCorMouseClicked

    private void lblCorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCorMousePressed
        if(evt.getButton()==1)
            selecionaCor();
    }//GEN-LAST:event_lblCorMousePressed

    private void setVlSobel(int vl) {

        if (vl == -1 || vl == 3 || vl == 5 || vl == 7) {
            obj.setCannyApertureSize(vl);
            lblSobel.setForeground(Color.black);
        } else {
            lblSobel.setForeground(Color.red);
        }

        spnSobel.setValue(vl);
        sldSobel.setValue(vl);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos herdados">
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
    public void update(Observable o, Object arg) {
        BufferedImage[] bufImgs = (BufferedImage[]) arg;
        //Graphics g = pnlExibicao.getGraphics();

        //bufImgs[1].getGraphics().setColor(Color.blue);
        //bufImgs[1].getGraphics().drawString("Contorno", 12, 12);
        if (radImgOriginal.isSelected()) {
            //g.drawImage(bufImgs[0], 0, 0, null);
            JPanelImageUtil.drawImageWithAspectRatio(pnlExibicao, bufImgs[0]);
        } else if (radImgContorno.isSelected()) {
            //g.drawImage(bufImgs[1], 0, 0, null);
            JPanelImageUtil.drawImageWithAspectRatio(pnlExibicao, bufImgs[1]);
            //g.drawImage(bufImgs[1], 0, 0, pnlExibicao.getWidth(), pnlExibicao.getHeight(), null);
        }

        //bufImgs[0].getGraphics().drawImage(bufImgs[1], 0, 0, (int) (bufImgs[1].getWidth() / 4), (int) (bufImgs[1].getHeight() / 4), null);
        //g.drawImage(bufImgs[0], 0, 0, null);
        camDisponivel = true;
    }
    // </editor-fold>
    
    private void selecionaCor(){
        Color cor = JColorChooser.showDialog(this, "Selecione a cor da linha", obj.getCorLinha());
        if (cor == null) {
            return;
        }
        obj.setCorLinha(cor);
        lblCor.setBackground(cor);
        txtCorLinha.setText(String.format("%02x%02x%02x", cor.getRed(), cor.getGreen(), cor.getBlue()).toUpperCase());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbxGradiente;
    private javax.swing.JCheckBox cbxLinhas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblNada;
    private javax.swing.JLabel lblSobel;
    private javax.swing.JRadioButton radImgContorno;
    private javax.swing.JRadioButton radImgOriginal;
    private javax.swing.ButtonGroup radioImgExibicao;
    private javax.swing.JSlider sldAngulo;
    private javax.swing.JSlider sldDiferencaLinha;
    private javax.swing.JSlider sldDistancia;
    private javax.swing.JSlider sldEspessuraLinha;
    private javax.swing.JSlider sldHisterese1;
    private javax.swing.JSlider sldHisterese2;
    private javax.swing.JSlider sldLimite;
    private javax.swing.JSlider sldSobel;
    private javax.swing.JSlider sldTamMinLinha;
    private javax.swing.JSpinner spnAngulo;
    private javax.swing.JSpinner spnDiferencaLinha;
    private javax.swing.JSpinner spnDistancia;
    private javax.swing.JSpinner spnEspessuraLinha;
    private javax.swing.JSpinner spnHisterese1;
    private javax.swing.JSpinner spnHisterese2;
    private javax.swing.JSpinner spnLimite;
    private javax.swing.JSpinner spnSobel;
    private javax.swing.JSpinner spnTamMinLinha;
    private javax.swing.JTextField txtCorLinha;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javafx.util.Pair;
import javax.swing.JPanel;

/**
 *
 * @author Roberto
 */
public class JPanelImageUtil {
    
    public static Point getPosicaoImagemPainel(JPanel pnl, BufferedImage bufImg){
        
        int posX = (pnl.getWidth() - bufImg.getWidth()) / 2;
        int posY = (pnl.getHeight() - bufImg.getHeight()) / 2;
        
        return new Point(posX, posY);
    }

    /**
     * Desenha uma imagem centralizada em um painel, mantendo a proporção da imagem.
     * @param pnl
     * @param bufImg
     * @return Matriz de inteiros com posição x e y da imagem e largura e altura da imagem desenhada no painel
     */
    public static Pair<java.awt.Point, java.awt.Dimension> drawImageWithAspectRatio(JPanel pnl, BufferedImage bufImg) {
        BufferedImage bufImg2 = scaleImage(
                bufImg,
                BufferedImage.TYPE_INT_ARGB,
                pnl.getWidth(),
                pnl.getHeight());
        
        int posX = (pnl.getWidth() - bufImg2.getWidth()) / 2;
        int posY = (pnl.getHeight() - bufImg2.getHeight()) / 2;
        
        Graphics g = pnl.getGraphics();
        g.drawImage(bufImg2, posX, posY, bufImg2.getWidth(), bufImg2.getHeight(), null);
        
        java.awt.Point p = new java.awt.Point(posX, posY);
        java.awt.Dimension d = new java.awt.Dimension( bufImg2.getWidth(), bufImg2.getHeight());
        
        return new Pair<>(p, d);
    }

//    public static void drawImage(JPanel pnl, BufferedImage bufImg, Point p) {
//        Graphics g = pnl.getGraphics();
//        
//        g.drawImage(bufImg, (int)p.getX(), (int)p.getY(), bufImg.getWidth(), bufImg.getHeight(), null);
//    }
    
    /**
     * Retirado de http://www.technojeeves.com/index.php/33-scale-an-image-in-java
     * @param image
     * @param imageType
     * @param newWidth
     * @param newHeight
     * @return 
     */
    public static BufferedImage scaleImage(BufferedImage image, int imageType, int newWidth, int newHeight) {
        // Make sure the aspect ratio is maintained, so the image is not distorted
        double thumbRatio = (double) newWidth / (double) newHeight;
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        double aspectRatio = (double) imageWidth / (double) imageHeight;

        if (thumbRatio < aspectRatio) {
            newHeight = (int) (newWidth / aspectRatio);
        } else {
            newWidth = (int) (newHeight * aspectRatio);
        }

        // Draw the scaled image
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, imageType);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);

        return newImage;
    }

}

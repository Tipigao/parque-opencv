/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;

/**
 *
 * @author Roberto
 */
public class StringUtil {

    /**
     * Converte uma cor hexadecimal para cor em Java. Retirado de
     * https://stackoverflow.com/questions/4129666/how-to-convert-hex-to-rgb-using-java
     *
     * @param hexCor e.g. "#FFFFFF" ou  e.g. "FFFFFF"
     * @return
     */
    public static Color hexToColor(String hexCor) {
        if (hexCor == null || hexCor.length() < 6) {
            return Color.BLACK;
        }

        hexCor = hexCor.replace("#", "");
        switch (hexCor.length()) {
            case 6:
                return new Color(
                        Integer.valueOf(hexCor.substring(0, 2), 16),
                        Integer.valueOf(hexCor.substring(2, 4), 16),
                        Integer.valueOf(hexCor.substring(4, 6), 16));
            case 8:
                return new Color(
                        Integer.valueOf(hexCor.substring(0, 2), 16),
                        Integer.valueOf(hexCor.substring(2, 4), 16),
                        Integer.valueOf(hexCor.substring(4, 6), 16),
                        Integer.valueOf(hexCor.substring(6, 8), 16));
        }
        return Color.BLACK;
    }
}

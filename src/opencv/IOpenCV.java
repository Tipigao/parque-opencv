/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv;

import org.opencv.core.Mat;

/**
 *
 * @author Roberto
 */
public interface IOpenCV {
    public Mat processaFrame(Mat imgFrame);
    public String getDescricao();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumeradores;

/**
 *
 * @author Roberto
 */
public enum TipoTransformacao {

    /*
    Correspondências entre duas imagens: https://docs.opencv.org/3.4/db/d70/tutorial_akaze_matching.html
    
    */
    
    CorrespondenciaForcaBruta("Correspondência por Força Bruta", exemplos.CorrespondenciaForcaBruta.class.getName())
    ,DesfocagemGaussiana("Desfocagem Gaussiana", exemplos.DesfocagemGaussiana.class.getName())
    ,EstimativaFluxoOptico("Estimativa de Fluxo Óptico", exemplos.EstimativaFluxoOptico.class.getName())
    ,TransformadaDeHough("Transformada de Hough", exemplos.TransformadaHough.class.getName())
    //,DetectaCantosHarris("Detecta Cantos Harris", exemplos.DetectaCantosHarris.class.getName())
    ;
    private final String descricao;
    private final String classe;

    TipoTransformacao(final String descricao, final String classe) {
        this.descricao = descricao;
        this.classe = classe;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerador;

/**
 *
 * @author Roberto
 */
public enum TipoTransformacao {
    TransformadaDeHough("Transformada de Hough", "transformacao.TransformadaHough");

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

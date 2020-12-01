package com.bcopstein.Entidades;

public class SistLocacaoException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public enum Causa {
        CARRO_NAO_CADASTRADO_NA_GARAGEM,
        CARRO_INDISPONIVEL_PARA_LOCACAO
    };

    private Causa causa;

    public SistLocacaoException(Causa causa) {
        super(causa.toString());
        this.causa = causa;
    }

    public Causa getCausa(){
        return causa;
    }
}
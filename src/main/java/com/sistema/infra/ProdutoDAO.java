package com.sistema.infra;

import com.sistema.model.Produto;

public class ProdutoDAO extends DAO<Produto> {
//CRIAR METODOS E FUNCIONALIDADE, SEM INCLUIR COMPLEXIDADE DENTRO DO NEGÓCIO

    public ProdutoDAO(){
        super(Produto.class);
    }

}

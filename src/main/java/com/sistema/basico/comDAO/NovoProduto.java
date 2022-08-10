package com.sistema.basico.comDAO;

import com.sistema.infra.DAO;
import com.sistema.model.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        Produto produto= new Produto("Monitor",1099.99);


        DAO<Produto> produtoDAO=new DAO<>(Produto.class);

      //  produtoDAO.abrirTransacao().incluir(produto).fecharTransacao().fechar();
        produtoDAO.incluirAromico(produto).fechar();

        System.out.println("Id do produto: "+produto.getNome()+" - "+produto.getId()+ "- R$"+produto.getPreco());

    }
}

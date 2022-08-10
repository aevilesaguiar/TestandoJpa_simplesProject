package com.sistema.basico;

import com.sistema.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoProduto0 {
    public static void main(String[] args) {

        /*crio a fabrica de persistencia*/
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");

        /*o entityManger encapsula a conexão com o BD*/
        EntityManager em= emf.createEntityManager();


        Produto produto= new Produto();
        produto.setPreco(5.99);
        produto.setNome("Macarrao");


        em.getTransaction().begin();
        //persistir a informação no BD - gera o insert
        em.persist(produto);
        em.getTransaction().commit();

        System.out.println("O id gerado foi: "+produto.getId());

        em.close();
        emf.close();


    }
}

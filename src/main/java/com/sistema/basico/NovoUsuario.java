package com.sistema.basico;

import com.sistema.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {

        /*crio a fabrica de persistencia*/
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");

        /*o entityManger encapsula a conexão com o BD*/
        EntityManager em= emf.createEntityManager();


        Usuario usuario1= new Usuario();
        usuario1.setNome("Joao");
        usuario1.setEmail("gmail@gmail.com");



        em.getTransaction().begin();
        //persistir a informação no BD - gera o insert
        em.persist(usuario1);
        em.getTransaction().commit();

        System.out.println("O id gerado foi: "+usuario1.getId());

        em.close();
        emf.close();


    }
}

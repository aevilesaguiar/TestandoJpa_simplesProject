package com.sistema.basico;

import com.sistema.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {

        //select nnão necessita transação pois é só uma consulta

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");
        EntityManager em=emf.createEntityManager();

        Usuario novoUsuario= em.find(Usuario.class,4L);
        System.out.println(novoUsuario.getNome());

        em.close();
        emf.close();


    }
}

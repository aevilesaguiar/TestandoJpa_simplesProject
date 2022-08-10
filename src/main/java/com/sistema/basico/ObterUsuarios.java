package com.sistema.basico;

import com.sistema.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {

        /*crio a fabrica de persistencia*/
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");

        /*o entityManger encapsula a conexão com o BD*/
        EntityManager em= emf.createEntityManager();

        String jpql= "select u from Usuario u";
        TypedQuery<Usuario> query= em.createQuery(jpql, Usuario.class);
        query.setMaxResults(5);

        List<Usuario> usuarios=query.getResultList();

        for (Usuario usuario:usuarios){
            System.out.println("ID: "+usuario.getId()+" Email: "+usuario.getEmail());
        }




        emf.close();
        em.close();
    }
}

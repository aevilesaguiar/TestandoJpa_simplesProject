package com.sistema.basico;

import com.sistema.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {
    public static void main(String[] args) {
        /*crio a fabrica de persistencia*/
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");

        /*o entityManger encapsula a conexão com o BD*/
        EntityManager em= emf.createEntityManager();


        Usuario usuario= em.find(Usuario.class,4L);

        if(usuario!= null){
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }





        em.close();
        emf.close();
    }
}

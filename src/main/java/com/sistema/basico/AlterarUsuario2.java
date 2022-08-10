package com.sistema.basico;

import com.sistema.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        /*crio a fabrica de persistencia*/
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("testandosistem");

        /*o entityManger encapsula a conexão com o BD*/
        EntityManager em= emf.createEntityManager();

        //alterar
        em.getTransaction().begin();

        Usuario usuario=em.find(Usuario.class, 1L);
        usuario.setNome("Pereira Silva alterado");
        usuario.setEmail("pereira@gmail.com");

        //em.merge(usuario);

        //mesmo não chamando o método merge ele sincroniza os dados com o banco de dados
        //isto sempre acontece quando o objeto não está no estado gerenciado

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

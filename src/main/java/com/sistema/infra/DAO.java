package com.sistema.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO <E>{//O GENERICS ELE CRIA UMA CLASSE GENERICA -O <E> é entidade

    private  static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try{
            emf= Persistence.createEntityManagerFactory("testandosistem");
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public DAO(){
        this(null);
    }

    public DAO(Class<E> classe){
        this.classe=classe;
        em= emf.createEntityManager();
    }


    public DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    //incluir atomico é que ele vai efetuar a transação, ela já inclui abrir e fechar
    public DAO<E> incluirAromico(E entidade){

        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public E obterPorID(Object id){
        return em.find(classe,id);
    }
    public List<E> obterTodos(){

        return this.obterTodos(10,0);
    }


    //paginando  qtde de registro que eu quero obter e limite(deslocamento) ex de 10
    public List<E> obterTodos(int qtde, int deslocamento){

        if(classe ==null){
            //se for nula quer dizer que eu não posso atender pois não existe a classe
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from "+classe.getName()+ " e";//o e é o alias
        TypedQuery<E> query=em.createQuery(jpql,classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();

    }


    public void fechar(){
        em.close();
    }





}

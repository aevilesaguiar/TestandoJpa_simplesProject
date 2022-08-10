package com.sistema.basico.umparaum;

import com.sistema.infra.DAO;
import com.sistema.umparaum.Assento;
import com.sistema.umparaum.Cliente;

public class ObterClientesAssento {
    public static void main(String[] args) {

        DAO< Cliente> daoCliente=new DAO<>(Cliente.class);

        Cliente cliente=daoCliente.obterPorID(1L);
        System.out.println(cliente.getAssento().getNome());
        daoCliente.fechar();

        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento=daoAssento.obterPorID(1L);


        System.out.println(assento.getCliente().getNome());



    }
}

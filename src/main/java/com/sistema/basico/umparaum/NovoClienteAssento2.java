package com.sistema.basico.umparaum;

import com.sistema.infra.DAO;
import com.sistema.umparaum.Assento;
import com.sistema.umparaum.Cliente;

public class NovoClienteAssento2 {

    public static void main(String[] args) {

        Assento assento=new Assento("1c");
        Cliente cliente=new Cliente("Inez", assento);

        DAO<Cliente> dao=new DAO<>(Cliente.class);
        dao.incluirAromico(cliente);





    }
}

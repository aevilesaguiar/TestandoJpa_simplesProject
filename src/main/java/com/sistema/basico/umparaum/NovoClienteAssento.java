package com.sistema.basico.umparaum;

import com.sistema.infra.DAO;
import com.sistema.umparaum.Assento;
import com.sistema.umparaum.Cliente;

public class NovoClienteAssento {

    public static void main(String[] args) {

        Assento assento=new Assento("15c");
        Cliente cliente=new Cliente("flavio", assento);

        DAO<Object> dao=new DAO<>();
        dao.abrirTransacao()
                .incluir(assento)
                .incluir(cliente)
                .fecharTransacao()
                .fechar();





    }
}

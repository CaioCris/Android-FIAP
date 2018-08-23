package com.example.logonrmlocal.listagem;

import java.util.ArrayList;
import java.util.List;

public class GeradorContatos {

    public static List<Contato> gerarContatos(){
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Caio", "(11)945857584",
                "Trabalhando", R.drawable.p1);

        contatos.add(contato1);

        Contato contato2 = new Contato("Camila", "(11)985452535",
                "Desempregada", R.drawable.p2);

        contatos.add(contato2);
        return contatos;

    }

}

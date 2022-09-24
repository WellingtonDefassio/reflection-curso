package alurator;

import alurator.reflexao.Reflexao;
import estoque.protocolo.Request;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }


    public Object executa(String url) {

        Request request = new Request(url);
        String nomeControle = request.getNomeControle();


        Object instanciaControle = new Reflexao().refleteClass(pacoteBase + nomeControle)
                .getConstrutorPadrao()
                .invoca();

//            Class<?> classeControle = Class.forName(nomeControle);
//            Object instance = classeControle.getDeclaredConstructor().newInstance();

        System.out.println(instanciaControle);
        return null;

    }

}

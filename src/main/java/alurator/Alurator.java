package alurator;

import alurator.reflexao.ManipuladorClasse;
import alurator.reflexao.ManipuladorMethod;
import alurator.reflexao.Reflexao;
import estoque.protocolo.Request;

import java.util.Map;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }


    public Object executa(String url) {

        Request request = new Request(url);

        String nomeControle = request.getNomeControle();
        String nomeMethod = request.getNomeMethod();
        Map<String, Object> queryParams = request.getQueryParams();


        Object invoca = new Reflexao().refleteClass(pacoteBase + nomeControle).criarInstancia().getMethod(nomeMethod, queryParams).invoca();

//        Object instanciaControle = new Reflexao().refleteClass(pacoteBase + nomeControle)
//                .getConstrutorPadrao()
//                .invoca();
//
//        ManipuladorMethod getLista = new Reflexao().refleteClass(pacoteBase + nomeControle).getMethodSemParam(nomeMethod);
//        getLista.invoke(instanciaControle);
//
//            Class<?> classeControle = Class.forName(nomeControle);
//            Object instance = classeControle.getDeclaredConstructor().newInstance();

        System.out.println(invoca);

        return invoca;

    }

}

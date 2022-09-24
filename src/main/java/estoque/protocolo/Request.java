package estoque.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String nomeControle;
    private String nomeMethod;

    private Map<String, Object> queryParams;

    public Request(String url) {
        /*
         * /controlador/metodo
         * /controlador/metodo?param1=valor1&param2=valor2
         */


        String[] partesUrl = url.replaceFirst("/", "").split("[?]");

        String[] controleEMetodo = partesUrl[0].split("/");



        this.nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0)) +
                controleEMetodo[0].substring(1) + "Controller";

        this.nomeMethod = controleEMetodo[1];

        queryParams = partesUrl[1].length() > 1? new QueryParamsBuilder().withParams(partesUrl[1]).build() : new HashMap<String, Object>();

    }

    public String getNomeControle() {

        return this.nomeControle;

    }

    public String getNomeMethod() {
        return this.nomeMethod;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }
}

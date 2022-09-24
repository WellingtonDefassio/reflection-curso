package alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {
    private Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }


    public ManipuladorMethod getMethod(String nomeMethod, Map<String, Object> queryParams) {

        Method[] declaredMethods = instancia.getClass().getDeclaredMethods();
        Method metodoSelecionado = Arrays.stream(declaredMethods).filter(metodo ->
                        metodo.getName().equals(nomeMethod)
                                && metodo.getParameterCount() == queryParams.values().size()
                                && Stream.of(metodo.getParameters()).allMatch(param -> queryParams.keySet().contains(param.getName())
                                && queryParams.get(param.getName()).getClass().equals(param.getType())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("metodo não encontrado!"));


        return new ManipuladorMethod(instancia, metodoSelecionado, queryParams);
    }
}
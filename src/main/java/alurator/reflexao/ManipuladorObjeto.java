package alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class ManipuladorObjeto {
    private Object instancia;

    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }


    public ManipuladorMethod getMethod(String nomeMethod, Map<String, Object> queryParams) {

        Method[] declaredMethods = instancia.getClass().getDeclaredMethods();
        Method metodoSelecionado = Arrays.stream(declaredMethods).filter(metodo -> true)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("metodo não encontrado!"));

        try {
            Method method = instancia.getClass().getDeclaredMethod(nomeMethod);
            return new ManipuladorMethod(instancia, method);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

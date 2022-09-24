package alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorMethod {


    private Object instancia;
    private Method method;
    private Map<String, Object> queryParams;

    public ManipuladorMethod(Object instancia, Method method, Map<String, Object> queryParams) {
        this.instancia = instancia;

        this.method = method;
        this.queryParams = queryParams;
    }

    public Object invoca() {
        try {
            List<Object> parametros = new ArrayList<>();
            Stream.of(method.getParameters())
                    .forEach(p-> parametros.add(queryParams.get(p.getName())));

          return method.invoke(instancia, parametros.toArray());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

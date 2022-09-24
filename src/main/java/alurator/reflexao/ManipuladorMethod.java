package alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMethod {


    private Object instancia;
    private Method method;

    public ManipuladorMethod(Object instancia, Method method) {
        this.instancia = instancia;

        this.method = method;
    }

    public Object invoca() {
        try {
          return method.invoke(instancia);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

package alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {
    private Constructor<?> declaredConstructor;

    public ManipuladorConstrutor(Constructor<?> declaredConstructor) {
        this.declaredConstructor = declaredConstructor;
        
    }

    public Object invoca() {
        try {
           return declaredConstructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

package alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ManipuladorClasse {
    private Class<?> aClass;

    public ManipuladorClasse(Class<?> forName) {
        this.aClass = forName;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            return new ManipuladorConstrutor(declaredConstructor);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    public ManipuladorObjeto criarInstancia() {
        Object instancia = getConstrutorPadrao().invoca();
        return new ManipuladorObjeto(instancia);
    }
}

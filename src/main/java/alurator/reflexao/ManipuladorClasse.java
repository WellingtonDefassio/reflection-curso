package alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {
    private Class<?> forName;

    public ManipuladorClasse(Class<?> forName) {
        this.forName = forName;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> declaredConstructor = forName.getDeclaredConstructor();
            return new ManipuladorConstrutor(declaredConstructor);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

package alurator.reflexao;

public class Reflexao {
    public ManipuladorClasse refleteClass(String fqn) {
        try {
            Class<?> aClass = Class.forName(fqn);
            return new ManipuladorClasse(aClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

package alurator.reflexao;

public class Reflexao {
    public ManipuladorClasse refleteClass(String fqn) {
        try {
            Class<?> forName = Class.forName(fqn);
            return new ManipuladorClasse(forName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

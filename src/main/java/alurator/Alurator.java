package alurator;

public class Alurator {

    private String pacoteBase;

    public Alurator(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        String[] partesUrl = url.replaceFirst("/", "").split("/");
        String pathName = Character.toUpperCase(partesUrl[0].charAt(0)) +
                partesUrl[0].substring(1);
        String nomeControle = pacoteBase + pathName + "Controller";

        try {
            Class<?> classeControle = Class.forName(nomeControle);
            Object controllerInstance = classeControle.newInstance();

            System.out.println(controllerInstance);

            return null;

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


}

package controle;

import java.util.List;

public class Controle {

    private List<String> lista = List.of("item 1", "item 2", "item 3");

    public Controle() {

    }

    public Controle(List<String> lista) {
        this.lista = lista;
    }

    private Controle(List<String> lista, String t) {
        this.lista = lista;
    }

    public List<String> getLista() {
        System.out.println("LISTA FOI INVOKADA");
        return lista;
    }

    private void metodoControle1() {

    }
    public void metodoControle2(String p1) {
        System.out.println("Controle.metodoControle2(String p1)");
        System.out.println("Parametro obtido: " + p1);
    }
    public void metodoControle2(String p1, String p2) {
        System.out.println("Controle.metodoControle2(String p1, String p2)");
        System.out.println("Parametro obtido: " + p1);
        System.out.println("Parametro obtido: " + p2);
    }
    public void metodoControle2(String p1, Integer p2) {
        System.out.println("Controle.metodoControle2(String p1, Integer p2)");
        System.out.println("Parametro obtido: " + p1);
        System.out.println("Parametro obtido: " + p2);
    }
}

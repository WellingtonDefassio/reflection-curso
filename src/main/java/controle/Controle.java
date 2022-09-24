package controle;

import java.util.List;

public class Controle {

	public Controle(){

	}

	public Controle(List<String> lista) {
		this.lista = lista;
	}
	private Controle(List<String> lista, String t) {
		this.lista = lista;
	}



	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}
}

package estoque.controle;

import estoque.dao.ProdutoDaoMock;
import estoque.modelo.Produto;

import java.util.List;
import java.util.stream.Collectors;


public class ProdutoController {
	
	private ProdutoDaoMock produtoDao;

	public ProdutoController() {
		produtoDao = new ProdutoDaoMock();
	}
	
	public List<Produto> lista() {

		System.out.println("executou a lista do ProdutoController");

		return produtoDao.lista();
	}
	
	public List<Produto> filtra(String nome) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	public List<Produto> filtra(String nome, String marca) {
		return produtoDao.lista().stream()
							.filter(produto -> 
								produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
								&& produto.getMarca().equalsIgnoreCase(marca)
							)
							.collect(Collectors.toList());
	}
}

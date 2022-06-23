package br.api.java.productapp.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.java.productapp.dto.ProdutoDTO;
import br.api.java.productapp.entities.Produto;
import br.api.java.productapp.repository.ProdutoRepository;

@Service
public class ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> listar() {
		List<Produto> lists = produtoRepository.findAllByOrderByPrecoDesc();
		return lists.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	public ProdutoDTO buscarPeloId(Long id) {
		Produto produto = produtoRepository.findById(id).get();
		return new ProdutoDTO(produto);

	}

	public ProdutoDTO adicionar(ProdutoDTO dto) {
		Produto produto = new Produto(null, dto.getNome(), dto.getPreco(), dto.getDescricao());
		produtoRepository.save(produto);
		return new ProdutoDTO(produto);

	}

	public ProdutoDTO editar(Long id, ProdutoDTO obj) {
		Produto produto = produtoRepository.findById(id).get();
		produto.setNome(obj.getNome());
		produto.setPreco(obj.getPreco());
		produto.setDescricao(obj.getDescricao());

		produtoRepository.save(produto);
		return new ProdutoDTO(produto);
	}

	public void deletar(Long id) {
		if (!produtoRepository.findById(id).isPresent()) {
			throw new RuntimeException("Usuario não encontrado");

		} else {
			produtoRepository.deleteById(id);
		}
	}

	public List<ProdutoDTO> buscarProdutoPeloNome(String nome) {
		List<Produto> prods = produtoRepository.findByNome(nome);
		return prods.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());

	}
}

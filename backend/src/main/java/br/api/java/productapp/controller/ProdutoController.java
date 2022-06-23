package br.api.java.productapp.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.api.java.productapp.dto.ProdutoDTO;
import br.api.java.productapp.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	@ApiOperation(value = "Lista de produtos ")
	private ResponseEntity<List<ProdutoDTO>> listar() {
		List<ProdutoDTO> list = produtoService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar produto pelo ID")
	private ResponseEntity<ProdutoDTO> buscarPeloId(@PathVariable Long id) {
		ProdutoDTO dto = produtoService.buscarPeloId(id);
		return ResponseEntity.ok().body(dto);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Editar produto pelo ID")
	private ResponseEntity<ProdutoDTO> editar(@PathVariable Long id, @RequestBody ProdutoDTO obj) {
		ProdutoDTO dto = produtoService.editar(id, obj);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	@ApiOperation(value = "Criação de um pedido")
	private ResponseEntity<ProdutoDTO> adicionar(@RequestBody ProdutoDTO obj) {
		ProdutoDTO dto = produtoService.adicionar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar produto pelo ID")
	private ResponseEntity<?> deletar(@PathVariable Long id) {

		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nome/{nome}")
	@ApiOperation(value = "Buscar lista de produtos pelo nome")
	private ResponseEntity<List<ProdutoDTO>> byName(@PathVariable String nome) {
		List<ProdutoDTO> prod = produtoService.buscarProdutoPeloNome(nome);
		return ResponseEntity.ok().body(prod);

	}

}

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

import br.api.java.productapp.dto.PedidoDTO;
import br.api.java.productapp.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	PedidoService pedidoService;

	@GetMapping
	ResponseEntity<List<PedidoDTO>> listar() {
		List<PedidoDTO> list = pedidoService.listar();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	ResponseEntity<PedidoDTO> adicionar(@RequestBody PedidoDTO dto) {
		dto = pedidoService.adicionar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/{id}")
	ResponseEntity<PedidoDTO> editar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
		dto = pedidoService.atualizar(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	ResponseEntity<PedidoDTO> buscarPeloId(@PathVariable Long id) {
		PedidoDTO obj = pedidoService.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}
}
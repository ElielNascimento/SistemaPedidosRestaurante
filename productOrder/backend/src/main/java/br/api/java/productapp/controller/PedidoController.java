package br.api.java.productapp.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pedidos")
@CrossOrigin("*")
public class PedidoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	PedidoService pedidoService;

	@GetMapping
	@ApiOperation(value = "Lista de pedidos")
	ResponseEntity<List<PedidoDTO>> listar() {
		List<PedidoDTO> list = pedidoService.listar();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ApiOperation(value = "Criação de um pedido")
	ResponseEntity<PedidoDTO> adicionar(@RequestBody PedidoDTO dto) {
		dto = pedidoService.adicionar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Editar pedido pelo ID")
	ResponseEntity<PedidoDTO> editar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
		dto = pedidoService.atualizar(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar pedido pelo ID")
	ResponseEntity<?> deletar(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar pedido pelo ID")
	ResponseEntity<PedidoDTO> buscarPeloId(@PathVariable Long id) {
		PedidoDTO obj = pedidoService.buscarPeloId(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping("/{id}/entregue")
	@ApiOperation(value = "Mudar status do pedido para entregue")
	ResponseEntity<PedidoDTO> setEntrega(@PathVariable Long id) {
		PedidoDTO dto = pedidoService.pedidoEntregue(id);
		return ResponseEntity.ok().body(dto);
	}

}

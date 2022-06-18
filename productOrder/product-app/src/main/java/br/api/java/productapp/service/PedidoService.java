package br.api.java.productapp.service;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.api.java.productapp.dto.PedidoDTO;
import br.api.java.productapp.entities.Pedido;
import br.api.java.productapp.enums.PedidoEnum;
import br.api.java.productapp.repository.PedidoRepository;

@Service
public class PedidoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	PedidoRepository pedidoRepository;

	public List<PedidoDTO> listar() {
		List<Pedido> list = pedidoRepository.findAll();
		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}

	public PedidoDTO adicionar(PedidoDTO dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), Instant.now(), PedidoEnum.PENDENTE);
		pedidoRepository.save(pedido);
		return new PedidoDTO(pedido);
	}

	public PedidoDTO atualizar(Long id, PedidoDTO novoObjeto) {
		Pedido obj = pedidoRepository.findById(id).get();
		obj.setEndereco(novoObjeto.getEndereco());
		obj.setMoment(novoObjeto.getMoment());
		obj.setStatus(novoObjeto.getStatus());
		pedidoRepository.save(obj);
		return new PedidoDTO(obj);

	}

	public void deletar(Long id) {
		if (!pedidoRepository.existsById(id)) {
			throw new RuntimeException("Usuario não encontrado");
		} else {
			pedidoRepository.deleteById(id);
		}
	}

	public PedidoDTO buscarPeloId(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		return new PedidoDTO(pedido);

	}

}
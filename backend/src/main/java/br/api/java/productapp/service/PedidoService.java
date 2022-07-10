package br.api.java.productapp.service;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.api.java.productapp.dto.PedidoDTO;
import br.api.java.productapp.dto.ProdutoDTO;
import br.api.java.productapp.entities.Pedido;
import br.api.java.productapp.entities.Produto;
import br.api.java.productapp.enums.PedidoEnum;
import br.api.java.productapp.repository.PedidoRepository;
import br.api.java.productapp.repository.ProdutoRepository;

@Service
public class PedidoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Page<PedidoDTO> listar(Pageable pageable) {
		Page<Pedido> response = pedidoRepository.findAll(pageable);
		Page<PedidoDTO> page = response.map(x -> new PedidoDTO(x));
		return page;
		
	}

	public PedidoDTO adicionar(PedidoDTO dto) {
		Pedido pedido = new Pedido(null, dto.getEndereco(), Instant.now(), PedidoEnum.PENDENTE);
		for (ProdutoDTO p : dto.getListDeProdutos()) {
			Produto produto = produtoRepository.getReferenceById(p.getId());
			pedido.getListDeProdutos().add(produto);
			produtoRepository.save(produto);

		}
		pedido = pedidoRepository.save(pedido);

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

	public PedidoDTO pedidoEntregue(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		pedido.setMoment(Instant.now());
		pedido.setStatus(PedidoEnum.ENTREGUE);

		pedidoRepository.save(pedido);

		return new PedidoDTO(pedido);

	}

}
package br.api.java.productapp.dto;

import java.time.Instant;
import java.util.Objects;

import br.api.java.productapp.entities.Pedido;
import br.api.java.productapp.enums.PedidoEnum;

public class PedidoDTO {

	private Long id;
	private String endereco;
	private Instant moment;
	private PedidoEnum status;

	public PedidoDTO() {

	}

	public PedidoDTO(Long id, String endereco, Instant moment, PedidoEnum status) {
		this.id = id;
		this.endereco = endereco;
		this.moment = moment;
		this.status = status;
	}

	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		endereco = entity.getEndereco();
		moment = entity.getMoment();
		status = entity.getStatus();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public PedidoEnum getStatus() {
		return status;
	}

	public void setStatus(PedidoEnum status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDTO other = (PedidoDTO) obj;
		return Objects.equals(id, other.id);
	}

}

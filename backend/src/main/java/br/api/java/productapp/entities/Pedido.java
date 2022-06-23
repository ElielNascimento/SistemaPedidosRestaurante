package br.api.java.productapp.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.api.java.productapp.enums.PedidoEnum;

@Entity
@Table(name = "tbl_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Long id;

	@Column(name = "pedido_endereco")
	private String endereco;

	@Column(name = "pedido_moment")
	private Instant moment;

	@Column(name = "pedido_status")
	@Enumerated(EnumType.STRING)
	private PedidoEnum status;

	@ManyToMany
	@JoinTable(name = "tbl_pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> listDeProdutos = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Long id, String endereco, Instant moment, PedidoEnum status) {
		this.id = id;
		this.endereco = endereco;
		this.moment = moment;
		this.status = status;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public List<Produto> getListDeProdutos() {
		return listDeProdutos;
	}

	public void setListDeProdutos(List<Produto> listDeProdutos) {
		this.listDeProdutos = listDeProdutos;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}

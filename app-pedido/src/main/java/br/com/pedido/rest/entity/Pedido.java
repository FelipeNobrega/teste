package br.com.pedido.rest.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate dataPedido;
	
	@Column(nullable = false)
	private String local;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PedidoProduto> pedidoProduto = new ArrayList<PedidoProduto>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<PedidoProduto> getPedidoProduto() {
		return pedidoProduto;
	}

	public void setPedidoProduto(List<PedidoProduto> pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataPedido, id, local, pedidoProduto);
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
		return Objects.equals(dataPedido, other.dataPedido) && Objects.equals(id, other.id)
				&& Objects.equals(local, other.local) && Objects.equals(pedidoProduto, other.pedidoProduto);
	}
	
	

}

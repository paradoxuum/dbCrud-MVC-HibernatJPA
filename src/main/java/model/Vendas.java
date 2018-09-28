package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Vendas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_venda;
	
	
	@ManyToOne
	private Cliente cliente;
	
	@Column
	private Date data;
	@Column
	private Double valorTotal;
	@Column
	private Double valorPago;
	@Column
	private Double desconto;
	
	
	public Integer getId_venda() {
		return id_venda;
	}
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
}

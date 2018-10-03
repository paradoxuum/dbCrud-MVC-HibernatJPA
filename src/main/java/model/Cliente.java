package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	@Id
	private Integer id_cliente;
	
	//REALCIONAMENTO 1 > N
	@OneToMany (mappedBy="cliente", 
			targetEntity=Vendas.class, 
			cascade=CascadeType.ALL)
	private Collection cliente;
	
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String rg;
	
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Collection getCliente() {
		return cliente;
	}
	public void setCliente(Collection cliente) {
		this.cliente = cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
}

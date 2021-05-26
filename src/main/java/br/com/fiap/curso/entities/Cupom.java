package br.com.fiap.curso.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_cupom")
public class Cupom implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cupom", sequenceName = "sq_tb_cupom", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cupom")
	@Column(name = "id_cupom")
	private Long id;
	
	@Column(name = "cd_cupom")
	private String codigo;
	
	@Column(name = "ds_cupom")
	private String descricao;
	
	@Column(name = "desconto_percentual")
	private Double descontoPercentual;
	
	@Column(name = "desconto_direto")
	private Integer descontoDireto;
	
	@ManyToMany(mappedBy = "cupons")
	private List<Carrinho> carrinhos;

	public Cupom() {
		super();
	}

	public Cupom(Long id, String codigo, Double descontoPercentual, Integer descontoDireto, List<Carrinho> carrinhos,
			String descricao) {
		this.id = id;
		this.codigo = codigo;
		this.descontoPercentual = descontoPercentual;
		this.descontoDireto = descontoDireto;
		this.carrinhos = carrinhos;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getDescontoPercentual() {
		return descontoPercentual;
	}

	public void setDescontoPercentual(Double descontoPercentual) {
		this.descontoPercentual = descontoPercentual;
	}

	public Integer getDescontoDireto() {
		return descontoDireto;
	}

	public void setDescontoDireto(Integer descontoDireto) {
		this.descontoDireto = descontoDireto;
	}

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

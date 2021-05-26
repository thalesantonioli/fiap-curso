package br.com.fiap.curso.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conteudo")
public class Conteudo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "conteudo", sequenceName = "sq_tb_conteudo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conteudo")
	@Column(name = "id_conteudo")
	private Long id;

	@Column(name = "ds_conteudo")
	private String descricao;	

	public Conteudo() {
		super();
	}

	public Conteudo(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

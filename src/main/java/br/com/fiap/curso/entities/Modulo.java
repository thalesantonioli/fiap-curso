package br.com.fiap.curso.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modulo")
public class Modulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "modulo", sequenceName = "sq_tb_modulo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modulo")
	@Column(name = "id_modulo")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "carga_horaria")
	private Double cargaHoraria;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Conteudo> conteudos;

	public Modulo() {
		super();
	}

	public Modulo(Long id, String nome, Double cargaHoraria, List<Conteudo> conteudos) {
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.conteudos = conteudos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
}

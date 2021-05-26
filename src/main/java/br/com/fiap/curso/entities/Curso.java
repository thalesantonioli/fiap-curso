package br.com.fiap.curso.entities;

import br.com.fiap.curso.enums.CursoNivel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "curso", sequenceName = "sq_tb_curso", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	@Column(name = "id_curso")
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "nivel")
	private CursoNivel nivel;

	@Column(name = "nm_curso")
	private String nome;

	@Column(name = "ds_curso")
	private String descricao;

	@Column(name = "preco_original")
	private Double precoOriginal;

	@Column(name = "preco_promocional")
	private Double precoPromocional;

	@Column(name = "url_imagem")
	private String ulrImagem;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Modulo> modulos;

	@ManyToMany(mappedBy = "usuario")
	private List<Usuario> usuarios;

	public Curso(Long id, CursoNivel nivel, String nome, String descricao, Double precoOriginal, Double precoPromocional, String ulrImagem, List<Modulo> modulos, List<Usuario> usuarios) {
		this.id = id;
		this.nivel = nivel;
		this.nome = nome;
		this.descricao = descricao;
		this.precoOriginal = precoOriginal;
		this.precoPromocional = precoPromocional;
		this.ulrImagem = ulrImagem;
		this.modulos = modulos;
		this.usuarios = usuarios;
	}

	public Curso() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CursoNivel getNivel() {
		return nivel;
	}

	public void setNivel(CursoNivel nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoOriginal() {
		return precoOriginal;
	}

	public void setPrecoOriginal(Double precoOriginal) {
		this.precoOriginal = precoOriginal;
	}

	public Double getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(Double precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public String getUlrImagem() {
		return ulrImagem;
	}

	public void setUlrImagem(String ulrImagem) {
		this.ulrImagem = ulrImagem;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}

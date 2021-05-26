package br.com.fiap.curso.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "usuario", sequenceName = "sq_tb_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nm_usuario")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tb_usuario_curso",
				joinColumns = @JoinColumn(name = "id_usuario"),
				inverseJoinColumns = @JoinColumn(name = "id_curso"))
	private List<Curso> cursos;
	
	@OneToOne(mappedBy = "usuario")
	private Carrinho carrinho;

	public Usuario(Long id, String nome, String email, String password, List<Curso> cursos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.cursos = cursos;
	}

	public Usuario() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}

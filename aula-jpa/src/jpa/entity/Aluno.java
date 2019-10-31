package jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	private String nome;

	@ManyToOne
	private Curso curso;
	
	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Contato> contatos;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Aluno() {
		super();
	}

	public Aluno(String cpf, String nome, Calendar dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno(String cpf, String nome, Curso curso, List<Contato> contatos, Calendar dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.curso = curso;
		this.contatos = contatos;
		this.dataNascimento = dataNascimento;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
}

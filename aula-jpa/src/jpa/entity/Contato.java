package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String tipo;
	
	@ManyToOne
	private Aluno aluno;
	
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	public Contato(String descricao, String tipo) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
	}



	public Contato(String descricao, String tipo, Aluno aluno) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.aluno = aluno;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}

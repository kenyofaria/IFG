package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	public Curso() {
		super();
	}
	

	public Curso(String nome) {
		super();
		this.nome = nome;
	}



	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}

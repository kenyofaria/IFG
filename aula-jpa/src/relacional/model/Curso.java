package relacional.model;

public class Curso {

	private Long id;
	private String nome;
	
	
	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public Curso() {
		super();
	}

	public Curso(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
}

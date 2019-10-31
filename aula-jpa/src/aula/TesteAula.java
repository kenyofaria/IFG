package aula;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.entity.Aluno;
import jpa.entity.Contato;
import jpa.entity.Curso;
import jpa.util.JPAUtil;

/**
 * Esta classe foi construída com o objetivo de aplicar conceitos de Mapeamento
 * Objeto-relacional em aulas de demonstração para alunos de graduação.
 * 
 * @author kenyo
 * 
 */
public class TesteAula {

	public static void main(String[] args) {
		//naoSeiONomeAinda();
		//salvaAlunoEContatos();
		//listaAlunosEContatos();
		//atualizaListaDeContatosDoAluno();
		excluiContatosDoAluno();
	}
	
	public static void salvaAlunoEContatos() {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Aluno aluno = new Aluno("109.108.107-70", "Daniel", Calendar.getInstance());
		Contato contato = new Contato("62 3210-1990", "telefone", aluno);
		List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(contato);
		aluno.setContatos(contatos);
		
		em.getTransaction().begin();
		
		em.persist(aluno);
		em.getTransaction().commit();
		
	}
	
	public static void listaAlunosEContatos() {
		EntityManager em = new JPAUtil().getEntityManager();
		Aluno aluno = em.find(Aluno.class, 7L);
		
		for(Contato c: aluno.getContatos()) {
			System.out.println(c.getAluno().getNome());
			System.out.println(c.getDescricao());
		}			
	}
	
	public static void atualizaListaDeContatosDoAluno() {
		EntityManager em = new JPAUtil().getEntityManager();
		Aluno aluno = em.find(Aluno.class, 7L);
		
		Contato novoContato = new Contato("maisum@mail.com", "email", aluno);
		aluno.getContatos().add(novoContato);
		
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public static void excluiContatosDoAluno() {
		EntityManager em = new JPAUtil().getEntityManager();
		Aluno aluno = em.find(Aluno.class, 7L);
		aluno.getContatos().clear();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	private static void listaAlunosDeUmCurso(EntityManager em) {
		System.out.println("------------------ lista de alunos cadastrados ----------------- \n\n");
		
		Query query = em.createQuery(
				"select a from Aluno a, Curso c "
				+ " where a.curso.id = c.id "
				+ " and c.id = :idCurso "
				+ " order by a.nome");
		
		query.setParameter("idCurso", 2L);
		List<Aluno> alunos = query.getResultList();
		
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome() + "    " + aluno.getCurso().getNome());
		}
	}




	private static void listaAlunos(EntityManager em) {
		System.out.println("------------------ lista de alunos cadastrados ----------------- \n\n");
		Query query = em.createQuery("from Aluno a order by a.nome");
		List<Aluno> alunos = query.getResultList();
		
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
	}



	private static void atualizaDadosAluno(EntityManager em) {
		em.getTransaction().begin();
		Aluno alunoEncontrado = em.find(Aluno.class, 2L);
		alunoEncontrado.setNome("Marcos Vinícius");
		em.getTransaction().commit();
	}



	private static void inseteEstudante2(EntityManager em) {
		em.getTransaction().begin();
		Curso curso = new Curso("Engenharia de Software");
		Aluno aluno = new Aluno("140-190-199-00", "Aldo", Calendar.getInstance());
		aluno.setCurso(curso);
		em.persist(curso);
		em.persist(aluno);
		em.getTransaction().commit();
	}

	private static void insereEstudante1(EntityManager em) {
		em.getTransaction().begin();
			Curso cienciaDaComputacao = new Curso("Ciência da Computação");
			Aluno aluno = new Aluno("120.123.124.90", "Marcos", Calendar.getInstance());
			aluno.setCurso(cienciaDaComputacao);
			em.persist(cienciaDaComputacao);
			em.persist(aluno);
		em.getTransaction().commit();
	}
}

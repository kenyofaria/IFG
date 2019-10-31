package jpa.service;

import javax.persistence.EntityManager;

import jpa.entity.Curso;
import jpa.entity.Grade;
import jpa.util.JPAUtil;

public class CursoService {
	

	
	public void salva(Curso curso) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		if(curso.getId()==null || curso.getId()==0) {
			em.persist(curso);
		}else {
			Curso cursoExistente = em.find(Curso.class, curso.getId());
			cursoExistente.setNome(curso.getNome());
		}
		em.getTransaction().commit();
		
	}
	
	/**
	 * Este método salva uma grade atribuindo ao curso passado como parâmetro
	 * @param curso
	 * @param grade
	 */
	public void salva(Curso curso, Grade grade) {
		EntityManager em = new JPAUtil().getEntityManager();
		grade.setCurso(curso);
		em.getTransaction().begin();
		em.persist(grade);
		em.getTransaction().commit();
	}
	
}

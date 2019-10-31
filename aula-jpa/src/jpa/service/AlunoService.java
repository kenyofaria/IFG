package jpa.service;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import jpa.entity.Aluno;
import jpa.util.JPAUtil;

public class AlunoService {
	
	
	/**
	 * Este método retorna um unico aluno com base no cpf passado como parâmetro
	 * @param cpf
	 * @return
	 */
	public Aluno getByCpf(String cpf) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery("from Aluno where cpf = :pCpf");
		query.setParameter("pCpf", cpf);
		Aluno alunoEncontrado = new Aluno();
		try {
			alunoEncontrado = (Aluno) query.getSingleResult();
		}catch(NoResultException e) {
			throw new PersistenceException("Erro ao obter o aluno pelo CPF");
		}finally {
			em.close();
		}
		return alunoEncontrado;
	}
	
	public void salva(Aluno aluno) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		if(aluno.getId() == null || aluno.getId() == 0) {
			em.persist(aluno);
		}else {
			Aluno alunoExistente = em.find(Aluno.class, aluno.getId());
			if(alunoExistente == null) {
				throw new RuntimeException("Aluno não encontrado");
			}
			alunoExistente.setCpf(aluno.getCpf());
			alunoExistente.setDataNascimento(aluno.getDataNascimento());
			alunoExistente.setNome(aluno.getNome());
			//alunoExistente.setSexo(aluno.getSexo());
		}
		em.getTransaction().commit();
		em.close();
	}
}

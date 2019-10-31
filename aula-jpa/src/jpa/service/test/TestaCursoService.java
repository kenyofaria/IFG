package jpa.service.test;

import jpa.entity.Curso;
import jpa.entity.Grade;
import jpa.service.CursoService;

public class TestaCursoService {

	private static CursoService servico = new CursoService();
	
	/**
	 * Este método tem o objetivo de testar se a persistência relacionada a cursos e grades está funcionando
	 * @param args
	 */
	public static void main(String[] args) {
		Curso cienciaComputacao = new Curso("Ciência da Computação");
		servico.salva(cienciaComputacao);
		servico.salva(cienciaComputacao, new Grade("grade inicial 2007"));
	}
}

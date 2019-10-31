package jpa.service.test;

import java.util.Calendar;

import jpa.entity.Aluno;
import jpa.service.AlunoService;

public class TestaAlunoService {

	private static AlunoService servico = new AlunoService();
	
	/**
	 * Este método tem o objetivo de testar se a persistência relacionada a alunos está funcionando
	 * @param args
	 */
	public static void main(String[] args) {
		salvaAluno();
		atualizaAlunoComBaseNoCPF();
		atualizaAlunoComBaseNoId();
	}
	
	private static void atualizaAlunoComBaseNoCPF() {
		Aluno alunoObtido = servico.getByCpf("124.987.098-00");
		alunoObtido.setNome("Agora é uma menina");
		servico.salva(alunoObtido);
	}

	private static void atualizaAlunoComBaseNoId() {
		//Aluno aluno = new Aluno("124.987.098-00", "Agora é uma menina", Calendar.getInstance(), 'F');
		Aluno aluno = new Aluno("124.987.098-00", "Agora é uma menina", Calendar.getInstance());
		aluno.setId(1L);
		servico.salva(aluno);
	}
	
	
	private static void salvaAluno() {
		//Aluno aluno = new Aluno("124.987.098-00", "Outra pessoa", Calendar.getInstance(),'M');
		Aluno aluno = new Aluno("124.987.098-00", "Outra pessoa", Calendar.getInstance());
		servico.salva(aluno);
	}
}

package Entidades;

import DataAcessObject.alunoDao;
import DataAcessObject.disciplinaDao;
import java.util.Scanner;

public class aluno_disciplina {

    String idAluno, idDisciplina;
    double nota1, nota2, nota3, nota4;

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public static aluno_disciplina cadastraNotas() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Insira o ID do aluno: ");
        System.out.println(alunoDao.exibeAlunoDao());
        aluno_disciplina notas = new aluno_disciplina();
        notas.setIdAluno(ler.next());
        System.out.println("Insira o ID da disciplina: ");
        System.out.println(disciplinaDao.exibeDisciplinaDao());
        notas.setIdDisciplina(ler.next());
        System.out.println("Insira a nota do primeiro Bimestre: ");
        notas.setNota1(ler.nextDouble());
        System.out.println("Insira a nota do segundo Bimestre: ");
        notas.setNota2(ler.nextDouble());
        System.out.println("Insira a nota do terceiro Bimestre: ");
        notas.setNota3(ler.nextDouble());
        System.out.println("Insira a nota do quarto Bimestre: ");
        notas.setNota4(ler.nextDouble());
        return notas;
    }
}

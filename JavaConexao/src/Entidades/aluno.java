package Entidades;

import java.util.Scanner;

public class aluno {

    String nome, serie, turma;
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSerie() {
        return serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    public String getTurma() {
        return turma;
    }
    
    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public static aluno cadastraAluno() {
        aluno a = new aluno();
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome do aluno:");
        a.setNome(ler.nextLine());
        System.out.println("Digite a serie do aluno:");
        a.setSerie(ler.nextLine());
        System.out.println("Digite a turma do aluno:");
        a.setTurma(ler.nextLine());
        
        return a;
    }
    
}

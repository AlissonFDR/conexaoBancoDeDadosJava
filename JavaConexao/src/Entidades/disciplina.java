package Entidades;
import java.util.Scanner;

public class disciplina {
    String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
       public static disciplina cadastraDisciplina() {
        disciplina d = new disciplina();
        Scanner ler = new Scanner(System.in);
           System.out.println("Digite o nome da disciplina:");
        d.setDescricao(ler.nextLine());
        return d;
    }
      
      
}

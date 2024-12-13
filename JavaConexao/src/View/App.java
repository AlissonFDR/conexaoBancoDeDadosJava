package View;
import Entidades.aluno;
import Entidades.disciplina;
import DataAcessObject.alunoDao;
import DataAcessObject.disciplinaDao;
import DataAcessObject.aluno_disciplinaDao;
import Entidades.aluno_disciplina;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Selecione a Opção desejada:");
            System.out.println("(1) Apresentar média do aluno");
            System.out.println("(2) Inserir dados do aluno");
            System.out.println("(3) Inserir disciplinas");
            System.out.println("(4) Inserir nota do aluno");
            System.out.println("(5) Sair");
            opcao = ler.nextInt();
            switch (opcao){
                case 1 : //Apresenta média do aluno
                    System.out.println("Digite o ID do aluno para exibir o boletim: ");
                    System.out.println(alunoDao.exibeAlunoDao());
                    String id = ler.next();
                    System.out.println("O boletim do aluno é: \n");
                    System.out.println(alunoDao.exibeInfoAlunoDao(id));
                    System.out.println(new aluno_disciplinaDao().exibeBoletimDao(id));
                    break;
                case 2 : //Cadastrar aluno
                    new alunoDao().cadastraAlunoDao(aluno.cadastraAluno());
                    break;
                case 3 : //Cadastrar materia
                    new disciplinaDao().cadastraDisciplinaDao(disciplina.cadastraDisciplina());
                    break;
                case 4 : //Cadastrar notas
                    new aluno_disciplinaDao().cadastraAlunoDisciplinaDao(aluno_disciplina.cadastraNotas());
                    break;
                case 5 : //Sair
                    System.out.println("Volte Sempre!");
                    break;
                
                default:
                    System.out.println("Opção inválida!");
       
            }
        }while(opcao!=5);
    }
    
}

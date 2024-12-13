
package DataAcessObject;
import ConexaoBancoDados.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.aluno_disciplina;
import Util.implementaMedia;
import java.sql.ResultSet;

public class aluno_disciplinaDao {
      public void cadastraAlunoDisciplinaDao(aluno_disciplina alunoDisciplina){
        
        String sql = "INSERT INTO aluno_disciplina(aluno_idaluno, disciplina_iddisciplina,1bimestre,2bimestre,3bimestre,4bimestre) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, alunoDisciplina.getIdAluno());
            ps.setString(2, alunoDisciplina.getIdDisciplina());
            ps.setDouble(3, alunoDisciplina.getNota1());
            ps.setDouble(4, alunoDisciplina.getNota2());
            ps.setDouble(5, alunoDisciplina.getNota3());
            ps.setDouble(6, alunoDisciplina.getNota4());
            System.out.println("Notas cadastradas com sucesso!\n");
            
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Ocorreu um erro no Banco de Dados\n");
            e.printStackTrace();
        }
        
    }
     
     public String exibeBoletimDao(String idAluno){
        // join foi usado para juntar as duas tabelas e obter como resultado o nome da disciplina
        String sql = "SELECT disciplina.descricao, 1bimestre,2bimestre,3bimestre,4bimestre FROM aluno_disciplina JOIN disciplina ON aluno_disciplina.disciplina_iddisciplina = disciplina.iddisciplina WHERE aluno_idaluno="+idAluno;
        PreparedStatement ps = null;
   
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            String resultado="";
            implementaMedia m =new implementaMedia();
            while(rs.next()){
                String nomeDisciplina = rs.getString("disciplina.descricao");
                double bimestre1 = rs.getDouble("1bimestre");
                double bimestre2 = rs.getDouble("2bimestre");
                double bimestre3 = rs.getDouble("3bimestre");
                double bimestre4 = rs.getDouble("4bimestre");
                resultado += nomeDisciplina+ "\n1° BIM: " + bimestre1 + "\n2° BIM: " + bimestre2 + "\n3° BIM: " + bimestre3 + "\n4° BIM: "+bimestre4+"\n"+"Média: "+m.mediaFinal(bimestre1, bimestre2, bimestre3, bimestre4)+"\n\n";
            }
            rs.close();
            ps.close();
            return resultado;
        } catch (SQLException e){
            e.printStackTrace();
             return "Ocorreu um erro no Banco de Dados\n";
        }
    }
}

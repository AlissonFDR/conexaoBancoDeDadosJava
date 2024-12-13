package DataAcessObject;

import ConexaoBancoDados.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.aluno;
import java.sql.ResultSet;

public class alunoDao {
    public void cadastraAlunoDao(aluno aluno){
        
        String sql = "INSERT INTO aluno(nome, serie, turma) VALUES (?,?,?)";
        
        PreparedStatement ps = null;
        
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getSerie());
            ps.setString(3, aluno.getTurma());
            System.out.println("Aluno Cadastrado com sucesso!\n");
            
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Ocorreu um erro no Banco de Dados\n");
            e.printStackTrace();
        }
        
    }
    
    public static String exibeAlunoDao(){
        
        String sql = "SELECT * FROM aluno";
        PreparedStatement ps = null;
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            String resultado="";
            while(rs.next()){
                int id = rs.getInt("idaluno");
                String nome = rs.getString("nome");
                String serie = rs.getString("serie");
                String turma = rs.getString("turma");
                resultado += "ID: " + id + ", Nome: " + nome + ", Serie: " + serie + ", Turma: "+turma+"\n";
            }
            rs.close();
            ps.close();
            return resultado;
        } catch (SQLException e){
            e.printStackTrace();
             return "Ocorreu um erro no Banco de Dados\n";
        }
    }
    
     public static String exibeInfoAlunoDao(String idAluno){
        
        String sql = "SELECT nome, serie, turma FROM aluno WHERE idaluno="+idAluno;
        PreparedStatement ps = null;
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            String resultado="";
            while(rs.next()){
                String nome = rs.getString("nome");
                String serie = rs.getString("serie");
                String turma = rs.getString("turma");
                resultado ="Nome: " + nome+"\n"+"Serie: "+serie+"\n"+"Turma: "+turma+"\n";
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

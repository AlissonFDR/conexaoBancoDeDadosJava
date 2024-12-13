
package DataAcessObject;

import ConexaoBancoDados.conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.disciplina;
import java.sql.ResultSet;

public class disciplinaDao {
        public void cadastraDisciplinaDao(disciplina materia){
        
        String slq = "INSERT INTO disciplina(descricao) VALUES (?)";
        
        PreparedStatement ps = null;
        
        try{
            ps = conexao.getConexao().prepareStatement(slq);
            ps.setString(1, materia.getDescricao());
            System.out.println("Disciplina cadastrada com sucesso!\n");
            
            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("Ocorreu um erro no Banco de Dados\n");
            e.printStackTrace();
        }
        
    }
        
     public static String exibeDisciplinaDao(){
        
        String sql = "SELECT * FROM disciplina";
        PreparedStatement ps = null;
        try{
            ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            String resultado="";
            while(rs.next()){
                int id = rs.getInt("iddisciplina");
                String descricao = rs.getString("descricao");
                resultado += "ID: " + id + ", Descrição: " + descricao+"\n";               
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


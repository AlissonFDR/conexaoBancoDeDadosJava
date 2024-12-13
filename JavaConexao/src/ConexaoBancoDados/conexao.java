package ConexaoBancoDados;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class conexao {
    
    private static final String url="jdbc:mysql://localhost:3306/nomeBD";
    private static final String user = "root";
    private static final String password = "";
    
    private static Connection conn;
    
    public static Connection getConexao(){
            try {
                if(conn == null){//Se a conexao nunca foi criada
                    conn = DriverManager.getConnection(url, user, password);
                    return conn;
                }else{
                    return conn;
                }
                }catch (SQLException e) {//Se der erro
                    System.out.println("Erro na conexão com o Banco de Dados!");
                    e.printStackTrace();
                    return null;
                }      
    }
}
package persistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements IGenericDAO{

    private Connection conn = null;
    
    @Override
    public Connection getConnection() throws ClassNotFoundException {
        
        String path = "C:\\Projeto4bimDS\\database\\crud_base.db3";
        
        String url = "jdbc:sqlite:" + path;
        
        try{
            if (conn == null){
                conn = DriverManager.getConnection(url);
            }
        }catch(SQLException e){
            System.out.println("erro ao se conecatr com o banco de dados: " + e.getMessage());
        }
        
        return conn;
        
    }
    
}

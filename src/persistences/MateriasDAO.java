package persistences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Materias;

public class MateriasDAO implements IMateriasDAO{
    
    private Connection conn;
    
    public MateriasDAO() throws ClassNotFoundException, SQLException{
        IGenericDAO genericDAO = new GenericDAO();
        
        conn = genericDAO.getConnection();
    }

    @Override
    public void adicionarMaterias(Materias materia) throws SQLException {
        String sql = "INSERT INTO TB_MATERIAS(nome, carga_horaria) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, materia.getNome());
        ps.setInt(2, materia.getCarga_horaria());
        ps.execute();
        ps.close();
        conn.close();
    }

    @Override
    public void atualizarMaterias(Materias materia) throws SQLException {
        String sql = "UPDATE TB_MATERIAS SET nome = ?, carga_horaria = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, materia.getNome());
        ps.setInt(2, materia.getCarga_horaria());
        ps.setInt(3, materia.getId());
        ps.execute();
        ps.close();
        conn.close();
    }

    @Override
    public void excluirMaterias(Materias materia) throws SQLException {
        try{
            String sql = "DELETE FROM TB_MATERIAS WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, materia.getId());
            ps.execute();
            ps.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Erro ao excluir materia: " + e.getMessage());
        }
    }

    @Override
    public Materias ConsultaMaterias(Materias materia) throws SQLException {
        String sql = "SELECT id, nome, carga_horaria FROM TB_MATERIAS WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, materia.getId());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            materia.setId(rs.getInt("id"));
            materia.setNome(rs.getString("nome"));
            materia.setCarga_horaria(rs.getInt("carga_horaria"));
        }
        rs.close();
        ps.close();
        conn.close();
        return materia;
    }

    @Override
    public List<Materias> consultaMaterias() throws SQLException {
        List<Materias> listaMaterias = new ArrayList<Materias>();
        String sql = "SELECT id, nome, carga_horaria FROM TB_MATERIAS";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Materias materia = new Materias();
            materia.setId(rs.getInt("id"));
            materia.setNome(rs.getString("nome"));
            materia.setCarga_horaria(rs.getInt("carga_horaria"));
            
            listaMaterias.add(materia);
        }
        
        rs.close();
        ps.close();
        conn.close();
        
        return listaMaterias;
    }

    @Override
    public int proximoId() throws SQLException {
        String sql = "SELECT MAX(id) * 1 AS proximo_id FROM TB_MATERIAS";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        conn.close();
        
        if(rs.next()){
            return rs.getInt("proximo_id");
        }else{
            return 1;
        }
    }
    
}

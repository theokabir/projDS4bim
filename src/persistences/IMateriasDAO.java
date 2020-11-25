package persistences;

import java.sql.SQLException;
import java.util.List;
import model.Materias;

public interface IMateriasDAO {
    
    public void adicionarMaterias(Materias materia) throws SQLException;    
    public void atualizarMaterias(Materias materia) throws SQLException;    
    public void excluirMaterias(Materias materia) throws SQLException;
    public Materias ConsultaMaterias(Materias materia) throws SQLException;
    public List<Materias> consultaMaterias() throws SQLException;
    public int proximoId() throws SQLException;
    
}

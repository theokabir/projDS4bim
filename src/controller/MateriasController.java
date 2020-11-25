package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Materias;
import persistences.MateriasDAO;

public class MateriasController implements IMateriasController{
    
    private JComboBox<Materias> combobox;
    private JTextField textFieldId;
    private JTable tbl_Materias;
    
    public MateriasController(JComboBox<Materias> combobox){
        this.combobox = combobox;
    }

    public MateriasController(JTextField textFieldId) {
        this.textFieldId = textFieldId;
    }

    public MateriasController(JComboBox<Materias> combobox, JTextField textFieldId) {
        this.combobox = combobox;
        this.textFieldId = textFieldId;
    }

    public MateriasController(JTable tbl_Materias) {
        this.tbl_Materias = tbl_Materias;
    }

    @Override
    public void proximoId() {
        try{
            MateriasDAO materiasdao = new MateriasDAO();
            this.textFieldId.setText(String.valueOf(materiasdao.proximoId()));
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void listaMaterias() {
        try{
            MateriasDAO materiasdao = new MateriasDAO();
            
            List<Materias> listaMaterias = materiasdao.consultaMaterias();
            
            if(this.combobox.getItemCount() > 0){
                this.combobox.removeAllItems();
            }
            
            if(listaMaterias != null){
                for (Materias materia : listaMaterias){
                    combobox.addItem(materia);
                }
            }
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void tabelaMaterias() {
        if(tbl_Materias != null){
            DefaultTableModel modelo = (DefaultTableModel) tbl_Materias.getModel();
            if(modelo.getRowCount()>0){
                modelo.setRowCount(0);
            }
            try{
                MateriasDAO materiasdao = new MateriasDAO();
                List<Materias> listaMaterias = materiasdao.consultaMaterias();
                
                for(Materias m : listaMaterias){
                    Object[] linha = new Object[3];
                    linha[0] = m.getId();
                    linha[1] = m.getNome();
                    linha[2] = m.getCarga_horaria();
                    
                    modelo.addRow(linha);
                }
            }catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

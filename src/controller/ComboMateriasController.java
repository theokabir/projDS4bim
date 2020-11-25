package controller;

import java.awt.event.*;
import javax.swing.*;

import model.Materias;

public class ComboMateriasController implements ActionListener{
    
    JTextField txt_Id, txt_Nome, txt_CargaHoraria;
    
    JRadioButton rdb_Excluir;
    
    JComboBox<Materias> cbo_Materias;

    public ComboMateriasController(JTextField txt_Id, JTextField txt_Nome, 
    JTextField txt_CargaHoraria, JRadioButton rdb_Excluir, 
    JComboBox<Materias> cbo_Materias) {
        this.txt_Id = txt_Id;
        this.txt_Nome = txt_Nome;
        this.txt_CargaHoraria = txt_CargaHoraria;
        this.rdb_Excluir = rdb_Excluir;
        this.cbo_Materias = cbo_Materias;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cbo_Materias.getItemCount() > 0){
            if(!rdb_Excluir.isSelected()){
                Materias materia = (Materias) cbo_Materias.getSelectedItem();
                preencherCampos(materia);
            }
        }
    }

    private void preencherCampos(Materias materia) {
        this.txt_Id.setText(String.valueOf(materia.getId()));
        this.txt_Nome.setText(materia.getNome());
        this.txt_CargaHoraria.setText(String.valueOf(materia.getCarga_horaria()));
    }
    
    
    
}

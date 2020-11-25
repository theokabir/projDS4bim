package controller;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import model.Materias;
import persistences.MateriasDAO;

public class BotaoMateriasController implements ActionListener{
    
    JTextField txt_Id, txt_Nome, txt_CargaHoraria;
    JRadioButton rdb_Adicionar, rdb_Atualizar, rdb_Excluir;
    JComboBox<Materias> cbo_Materias;
    JTable tbl_Materias;

    public BotaoMateriasController(JTextField txt_Id, JTextField txt_Nome, JTextField txt_CargaHoraria, 
    JRadioButton rdb_Adicionar, JRadioButton rdb_Atualizar, JRadioButton rdb_Excluir, JComboBox<Materias> cbo_Materias, JTable tbl_Materias) {
        this.txt_Id = txt_Id;
        this.txt_Nome = txt_Nome;
        this.txt_CargaHoraria = txt_CargaHoraria;
        this.rdb_Adicionar = rdb_Adicionar;
        this.rdb_Atualizar = rdb_Atualizar;
        this.rdb_Excluir = rdb_Excluir;
        this.cbo_Materias = cbo_Materias;
        this.tbl_Materias = tbl_Materias;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Materias materia = new Materias();
        
        if(cbo_Materias.getSelectedItem() != null){
            materia = (Materias) cbo_Materias.getSelectedItem();
        }
        
        if(rdb_Excluir.isSelected()){
            excluir(materia);
        }else{
            materia.setId(Integer.parseInt(txt_Id.getText()));
            materia.setNome(txt_Nome.getText());
            materia.setCarga_horaria(Integer.parseInt(txt_CargaHoraria.getText()));
            
            if(rdb_Adicionar.isSelected()){
                cadstrar(materia);
            }else{
                atualizar(materia);
            }
        }
    }

    private void atualizar(Materias materia) {
        try {
            
            MateriasDAO mdao = new MateriasDAO();
            mdao.atualizarMaterias(materia);
            
            JOptionPane.showMessageDialog(null, "Materia Atualizada com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            
            IMateriasController imc = new MateriasController(cbo_Materias);
            
            imc.listaMaterias();
            
            imc = new MateriasController(tbl_Materias);
            
            imc.tabelaMaterias();
            
            this.limpaCampos();
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void cadstrar(Materias materia) {
        try{
            
            MateriasDAO mdao = new MateriasDAO();
            mdao.adicionarMaterias(materia);
            
            JOptionPane.showMessageDialog(null, "Materia inserida com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            MateriasController  mc = new MateriasController(txt_Id);
            
            mc.proximoId();
            
            mc = new MateriasController(tbl_Materias);
            
            mc.tabelaMaterias();
            
            this.limpaCampos();
            
        }catch(ClassNotFoundException | SQLException e){
            
        }
    }

    private void excluir(Materias materia) {
        try{
            MateriasDAO mdao = new MateriasDAO();
            
            mdao.excluirMaterias(materia);
            
            JOptionPane.showMessageDialog(null, "Matéria excluida com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            IMateriasController imc = new MateriasController(cbo_Materias);
            
            imc.listaMaterias();
            
            imc = new MateriasController(tbl_Materias);
            
            imc.tabelaMaterias();
            
            this.limpaCampos();
            
        }catch(ClassNotFoundException | SQLException e){
            
        }
    }

    private void limpaCampos() {
        txt_Nome.setText("");
        txt_CargaHoraria.setText("");
        
        if(!rdb_Adicionar.isSelected()){
            txt_Id.setText("");
        }
    }
    
    
    
}

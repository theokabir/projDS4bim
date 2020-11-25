package controller;

import java.awt.event.*;
import javax.swing.*;
import model.Materias;

public class RadioMateriasController implements ActionListener{

    JTextField txt_Id, txt_Nome, txt_CargaHoraria;
    JLabel lbl_Materias, lbl_Id, lbl_Nome, lbl_CargaHoraria;
    JRadioButton rdb_Adicionar, rdb_Atualizar, rdb_Excluir;
    JButton btn_Aplicar;
    JComboBox<Materias> cbo_Materias;

    public RadioMateriasController(JTextField txt_Id, JTextField txt_Nome, 
    JTextField txt_CargaHoraria, JLabel lbl_Materias, JLabel lbl_Id, 
    JLabel lbl_Nome, JLabel lbl_CargaHoraria, JRadioButton rdb_Adicionar, 
    JRadioButton rdb_Atualizar, JRadioButton rdb_Excluir, JButton btn_Aplicar, 
    JComboBox<Materias> cbo_Materias) {
        this.txt_Id = txt_Id;
        this.txt_Nome = txt_Nome;
        this.txt_CargaHoraria = txt_CargaHoraria;
        this.lbl_Materias = lbl_Materias;
        this.lbl_Id = lbl_Id;
        this.lbl_Nome = lbl_Nome;
        this.lbl_CargaHoraria = lbl_CargaHoraria;
        this.rdb_Adicionar = rdb_Adicionar;
        this.rdb_Atualizar = rdb_Atualizar;
        this.rdb_Excluir = rdb_Excluir;
        this.btn_Aplicar = btn_Aplicar;
        this.cbo_Materias = cbo_Materias;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        limpaCampos();
        
        if(rdb_Adicionar.isSelected()){
            IMateriasController imc = new MateriasController(this.txt_Id);
            imc.proximoId();
            montaTelaCadastro();
        }else{
            IMateriasController imc = new MateriasController(this.cbo_Materias);
            imc.listaMaterias();
            
            if(rdb_Atualizar.isSelected()){
                montaTelaAtualiza();
            }else{
                montaTelaExclui();
            }
        }
    }
    
    private void limpaCampos(){
        this.txt_Id.setText("");
        this.txt_Nome.setText("");
        this.txt_CargaHoraria.setText("");
    }

    private void montaTelaExclui() {
        lbl_Id.setVisible(false);
        lbl_Nome.setVisible(false);
        lbl_CargaHoraria.setVisible(false);
        lbl_Materias.setVisible(true);
        txt_Id.setVisible(false);
        txt_Nome.setVisible(false);
        txt_CargaHoraria.setVisible(false);
        cbo_Materias.setVisible(true);
        btn_Aplicar.setVisible(true);
    }

    private void montaTelaAtualiza() {
        lbl_Id.setVisible(true);
        lbl_Nome.setVisible(true);
        lbl_CargaHoraria.setVisible(true);
        lbl_Materias.setVisible(true);
        txt_Id.setVisible(true);
        txt_Nome.setVisible(true);
        txt_CargaHoraria.setVisible(true);
        cbo_Materias.setVisible(true);
        btn_Aplicar.setVisible(true);
    }

    private void montaTelaCadastro() {
        lbl_Id.setVisible(true);
        lbl_Nome.setVisible(true);
        lbl_CargaHoraria.setVisible(true);
        lbl_Materias.setVisible(false);
        txt_Id.setVisible(true);
        txt_Nome.setVisible(true);
        txt_CargaHoraria.setVisible(true);
        cbo_Materias.setVisible(false);
        btn_Aplicar.setVisible(true);
    }
    
}

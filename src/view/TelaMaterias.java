package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.*;
import model.Materias;

public class TelaMaterias extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JRadioButton rdb_Adicionar, rdb_Atualizar, rdb_Excluir;
    private JLabel lbl_Materias, lbl_Id, lbl_Nome, lbl_CargaHoraria;
    private JComboBox<Materias> cbo_Materias;
    private JTextField txt_Id, txt_Nome, txt_CargaHoraria;
    private JButton btn_Aplicar;
    private JTable tbl_Materias;
    
    
    
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    TelaMaterias frame = new TelaMaterias();
                    frame.setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
    }
    
    
    
    public TelaMaterias(){
        setTitle("Tela Materias");
        
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 590, 500);
        getContentPane().setLayout(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        rdb_Adicionar = new JRadioButton("Adicionar");
        rdb_Adicionar.setBounds(6, 28, 121, 23);
        contentPane.add(rdb_Adicionar);
        rdb_Adicionar.setSelected(true);
        
        rdb_Atualizar = new JRadioButton("Atualizar");
        rdb_Atualizar.setBounds(221, 28, 121, 23);
        contentPane.add(rdb_Atualizar);
        
        rdb_Excluir = new JRadioButton("Excluir");
        rdb_Excluir.setBounds(449, 28, 121, 23);
        contentPane.add(rdb_Excluir);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdb_Adicionar);
        bg.add(rdb_Atualizar);
        bg.add(rdb_Excluir);
        
        lbl_Materias = new JLabel("Matérias: ");
        lbl_Materias.setBounds(10, 82, 63, 14);
        contentPane.add(lbl_Materias);
        lbl_Materias.setVisible(true);
        
        lbl_Id = new JLabel("Id: ");
        lbl_Id.setBounds(10, 138, 46, 14);
        contentPane.add(lbl_Id);
        
        lbl_Nome = new JLabel("Nome: ");
        lbl_Nome.setBounds(10, 203, 46, 14);
        contentPane.add(lbl_Nome);
        
        lbl_CargaHoraria = new JLabel("Carga Horária: ");
        lbl_CargaHoraria.setBounds(10, 258, 46, 14);
        contentPane.add(lbl_CargaHoraria);
        
        cbo_Materias = new JComboBox<Materias>();
        cbo_Materias.setBounds(109, 79, 461, 20);
        contentPane.add(cbo_Materias);
        cbo_Materias.setVisible(true);
        
        txt_Id = new JTextField();
        txt_Id.setEditable(false);
        txt_Id.setBounds(107, 135, 86, 20);
        contentPane.add(txt_Id);
        txt_Id.setColumns(10);
        
        txt_Nome = new JTextField();
        txt_Nome.setBounds(107, 200, 319, 20);
        contentPane.add(txt_Nome);
        txt_Nome.setColumns(10);
        
        txt_CargaHoraria = new JTextField();
        txt_CargaHoraria.setBounds(107, 255, 86, 20);
        contentPane.add(txt_CargaHoraria);
        txt_CargaHoraria.setColumns(10);
        
        btn_Aplicar = new JButton("Aplicar");
        btn_Aplicar.setBounds(240, 304, 89, 23);
        contentPane.add(btn_Aplicar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 342, 573, 118);
        contentPane.add(scrollPane);
        
        tbl_Materias = new JTable();
        scrollPane.setViewportView(tbl_Materias);
        
        tbl_Materias.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Id", "Nome", "Carga Horária"} ));
        
        tbl_Materias.getColumnModel().getColumn(0).setPreferredWidth(35);
        tbl_Materias.getColumnModel().getColumn(1).setPreferredWidth(450);
        tbl_Materias.getColumnModel().getColumn(2).setPreferredWidth(90);
        
        MateriasController mc = new MateriasController(txt_Id);
        
        mc.proximoId();
        
        mc = new MateriasController(tbl_Materias);
        
        mc.tabelaMaterias();
        
        RadioMateriasController rmc = new RadioMateriasController(
        txt_Id, txt_Nome, txt_CargaHoraria,lbl_Materias, lbl_Id,
        lbl_Nome, lbl_CargaHoraria, rdb_Adicionar, rdb_Atualizar,
        rdb_Excluir, btn_Aplicar, cbo_Materias);
        
        rdb_Adicionar.addActionListener(rmc);
        rdb_Atualizar.addActionListener(rmc);
        rdb_Excluir.addActionListener(rmc);
        
        ComboMateriasController cmc = new ComboMateriasController(
        txt_Id, txt_Nome, txt_CargaHoraria, rdb_Excluir, cbo_Materias);
        
        cbo_Materias.addActionListener(cmc);
        
        BotaoMateriasController bmc = new BotaoMateriasController(
        txt_Id, txt_Nome, txt_CargaHoraria, rdb_Adicionar, rdb_Atualizar,
        rdb_Excluir,cbo_Materias, tbl_Materias
        );
        
        btn_Aplicar.addActionListener(bmc);
    }
    
}

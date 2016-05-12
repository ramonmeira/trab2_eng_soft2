package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JFormattedTextField;

public class CadastroProduto extends JInternalFrame {
	private static CadastroProduto instance = null;
	
	private JFormattedTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JFormattedTextField txtCodEan;

	private CadastroProduto() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setTitle("Cadastro de Produto");
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 20, 25, 14);
		getContentPane().add(lblId);
		
		txtId = new JFormattedTextField();
		txtId.setBounds(20, 35, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(116, 35, 363, 20);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(116, 20, 46, 14);
		getContentPane().add(lblDescricao);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setBounds(20, 65, 67, 14);
		getContentPane().add(lblFabricante);
		
		txtFabricante = new JTextField();
		txtFabricante.setBounds(20, 80, 300, 20);
		getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(330, 80, 149, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(330, 65, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblCodEan = new JLabel("Cod. EAN");
		lblCodEan.setBounds(20, 110, 46, 14);
		getContentPane().add(lblCodEan);
		
		try {
			txtCodEan = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("#############")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "O c�digo EAN informado possui formato inv�lido!", "C�digo EAN inv�lido", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		txtCodEan.setBounds(20, 125, 142, 20);
		getContentPane().add(txtCodEan);
		txtCodEan.setColumns(13);
		
		JComboBox cmbFornecedor = new JComboBox();
		cmbFornecedor.setBounds(172, 125, 307, 20);
		getContentPane().add(cmbFornecedor);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(172, 111, 67, 14);
		getContentPane().add(lblFornecedor);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 182, 89, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(152, 182, 89, 23);
		getContentPane().add(btnCadastrar);
	}
	
	public static CadastroProduto getInstance() {
		if(instance ==null) {
			instance = new CadastroProduto();
		}
		return instance;
	}
}

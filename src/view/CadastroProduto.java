package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import control.TelaPrincipalControl;
import data.model.Funcionario;
import data.model.Produto;

import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroProduto extends JInternalFrame {
	private static CadastroProduto instance = null;
	private JTextField txtModelo;
	private JFormattedTextField txtCodEan;
	private TelaPrincipalControl controle;

	private CadastroProduto() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setTitle("Cadastro de Produto");
		getContentPane().setLayout(null);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(20, 36, 263, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblCodEan = new JLabel("Cod. EAN");
		lblCodEan.setBounds(20, 67, 46, 14);
		getContentPane().add(lblCodEan);
		
		try {
			txtCodEan = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("#############")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "O codigo EAN informado possui formato invalido!", "Codigo EAN invalido", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		txtCodEan.setBounds(20, 92, 263, 20);
		getContentPane().add(txtCodEan);
		txtCodEan.setColumns(13);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Produto produto = new Produto();
				produto.setCodEan(txtCodEan.getText());
				produto.setModelo(txtModelo.getText());
//				controle.salvaDadosFuncionarios(funcionario);
			}
		});
		btnSalvar.setBounds(20, 123, 89, 23);
		getContentPane().add(btnSalvar);
	}
	
	public static CadastroProduto getInstance() {
		if(instance ==null) {
			instance = new CadastroProduto();
		}
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtModelo.setText("");
		txtCodEan.setText("");
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtCodEan.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1));
		txtModelo.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
	}
}

package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import control.TelaPrincipalControl;
import data.model.Estoque;
import data.model.Produto;

import java.beans.PropertyVetoException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroEstoque extends JInternalFrame {
	private static CadastroEstoque instance = null;
	
	TelaPrincipalControl controle;
	private JTextField txtModelo;
	private JFormattedTextField txtCodEan;
	private JTextField txtQtd;

	public CadastroEstoque() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setBounds(100, 100, 368, 215);
		
		setTitle("Cadastro de estoque");
		
		getContentPane().setLayout(null);
		
		JLabel lblCodigoEan = new JLabel("Codigo EAN");
		lblCodigoEan.setBounds(10, 67, 67, 14);
		getContentPane().add(lblCodigoEan);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(239, 67, 73, 14);
		getContentPane().add(lblQuantidade);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(10, 36, 315, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		try {
			txtCodEan = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("##############")));
			txtCodEan.setColumns(14);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "O codigo EAN informado possui formato invalido!", "Codigo EAN invalido", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		txtCodEan.setBounds(10, 92, 223, 20);
		getContentPane().add(txtCodEan);
		txtCodEan.setColumns(10);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(239, 92, 86, 20);
		getContentPane().add(txtQtd);
		txtQtd.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Estoque estoque = new Estoque();
				estoque.setCodEan(txtCodEan.getText());
				estoque.setModelo(txtModelo.getText());
				estoque.setQtd(txtQtd.getText());
				controle.salvaDadosEstoque(estoque);
			}
		});
		btnSalvar.setBounds(10, 141, 89, 23);
		getContentPane().add(btnSalvar);
	}
	
	public static CadastroEstoque getInstance() {
		if(instance == null) {
			instance = new CadastroEstoque();
		}
		
		return instance;
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
	
	public void limpaCampos() {
		txtCodEan.setText("");
		txtModelo.setText("");
		txtQtd.setText("");
	}
	
	public void insereDados(ArrayList<String> dados) {
		txtCodEan.setText(dados.get(0).substring(dados.get(0).indexOf("=") + 1));
		txtModelo.setText(dados.get(1).substring(dados.get(1).indexOf("=") + 1));
		txtQtd.setText(dados.get(2).substring(dados.get(2).indexOf("=") + 1));
	}
}

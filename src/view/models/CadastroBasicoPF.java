package view.models;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import control.TelaPrincipalControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;

/*
 * TODO deixar somente os campode de nome e cpf
 */

public class CadastroBasicoPF extends JInternalFrame {

	private static final long serialVersionUID = 2528457607303713404L;
	
	protected JTextField txtNome;
	protected JFormattedTextField txtCpf;
	protected JLabel lblNome;
	protected JLabel lblCpf;
	
	DateFormatter displayFormat;
	DateFormatter editFormat;
	DefaultFormatterFactory dateFormat;
	
	TelaPrincipalControl controle;

	protected CadastroBasicoPF(){
		super();
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setBounds(100, 100, 463, 220);
		
		getContentPane().setLayout(null);
		
		displayFormat = new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"));
		editFormat = new DateFormatter(new SimpleDateFormat("ddMMyyyy"));
		dateFormat = new DefaultFormatterFactory(displayFormat, displayFormat, editFormat);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 11, 39, 14);
		lblNome.setSize(lblNome.getPreferredSize());
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 65, 28, 14);
		lblCpf.setSize(lblCpf.getPreferredSize());
		getContentPane().add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 34, 389, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		try {
			txtCpf = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "CPF inválido", "O número de CPF informado possui formato inválido!", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		txtCpf.setColumns(11);
		txtCpf.setBounds(20, 80, 150, 20);
		getContentPane().add(txtCpf);
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}

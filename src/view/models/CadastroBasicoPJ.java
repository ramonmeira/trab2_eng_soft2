/*
 * TODO deixar somente os campos de Razão Social, CNPJ
 */

package view.models;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import control.TelaPrincipalControl;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;

public class CadastroBasicoPJ extends JInternalFrame {
	protected JTextField txtRazaoSocial;
	protected JFormattedTextField txtCnpj;
	protected JCheckBox chckbxAtivo;
	protected JLabel lblRazaoSocial;
	protected JLabel lblCnpj;
	
	TelaPrincipalControl controle;

	public CadastroBasicoPJ() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setBounds(100, 100, 639, 184);
		getContentPane().setLayout(null);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(20, 34, 581, 20);
		getContentPane().add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);
		
		lblRazaoSocial = new JLabel("Raz\u00E3o Social");
		lblRazaoSocial.setBounds(20, 11, 93, 14);
		lblRazaoSocial.setSize(lblRazaoSocial.getPreferredSize());
		getContentPane().add(lblRazaoSocial);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(20, 65, 46, 14);
		lblCnpj.setSize(lblCnpj.getPreferredSize());
		getContentPane().add(lblCnpj);
		
		try {
			txtCnpj = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("##.###.###/####-##"), new MaskFormatter("##.###.###/####-##"), new MaskFormatter("##.###.###/####-##")));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "O numero de CNPJ informado possui formato inválido!", "CNPJ invalido", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		txtCnpj.setBounds(20, 90, 183, 20);
		getContentPane().add(txtCnpj);
		txtCnpj.setColumns(14);
		
		chckbxAtivo = new JCheckBox("Ativo");
		chckbxAtivo.setBounds(234, 89, 97, 23);
		chckbxAtivo.setSize(chckbxAtivo.getPreferredSize());
		getContentPane().add(chckbxAtivo);
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}

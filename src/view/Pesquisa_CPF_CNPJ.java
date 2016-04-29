package view;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.TelaPrincipalControl;

import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pesquisa_CPF_CNPJ extends JInternalFrame {
	
	private TelaPrincipalControl controle;
	private JFormattedTextField frmtdtxtfldPesquisa;
	
	private String tipo;
	
	public Pesquisa_CPF_CNPJ(String tipo) {
		setBounds(100, 100, 380, 195);
		getContentPane().setLayout(null);
		
		setTitle("Pesquisa de " + tipo);
		
		this.tipo = tipo;
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tipo.equals("CPF")) {
					controle.pesquisaCPF(frmtdtxtfldPesquisa.getText());
				}
			}
		});
		btnPesquisar.setBounds(142, 114, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblCpfCnpj = new JLabel(tipo);
		lblCpfCnpj.setBounds(67, 46, 56, 14);
		getContentPane().add(lblCpfCnpj);
		
		frmtdtxtfldPesquisa = new JFormattedTextField();
		try {
			if(tipo.equals("CNPJ")) {
				frmtdtxtfldPesquisa = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
				frmtdtxtfldPesquisa.setColumns(14);
			} else {
				frmtdtxtfldPesquisa = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
				frmtdtxtfldPesquisa.setColumns(10);
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "CNPJ inválido", "O número de CNPJ informado possui formato inválido!", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		frmtdtxtfldPesquisa.setBounds(133, 43, 158, 20);
		getContentPane().add(frmtdtxtfldPesquisa);
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}

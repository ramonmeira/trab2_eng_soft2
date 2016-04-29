package view;

import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.TelaPrincipalControl;

import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Tipos de operacoes:
 * 1 - Cadastrar cliente
 * 2 - Alterar dados de cliente
 * 3 - Remover Cliente
 * 4 - Cadastrar funcionario
 * 5 - Alterar dados do funcionario
 * 6 - Promover funcionario
 * 7 - Desativar funcionario
 * 8 - Cadastrar fornecedor
 * 9 - Alterar dados do fornecedor
 * 10 - Desativar fornecedor
 * 11 - Cadastrar produto
 * 12 - Remover produto
 * 13 - Solicitar produto
 */

public class Pesquisa_CPF_CNPJ extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private TelaPrincipalControl controle;
	private JFormattedTextField frmtdtxtfldPesquisa;
	
//	private int tipoOperacao;
	
	public Pesquisa_CPF_CNPJ(int tipoOperacao) {
		setBounds(100, 100, 380, 195);
		getContentPane().setLayout(null);
		
		String tipo;
		
		if(tipoOperacao < 8) {
			tipo = "CPF";
		} else if(tipoOperacao < 11) {
			tipo = "CNPJ";
		} else {
			tipo = "Código EAN";
		}
		
		setTitle("Pesquisa de " + tipo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tipo.equals("CPF")) {
					controle.pesquisaCPF(frmtdtxtfldPesquisa.getText());
				}
			}
		});
		btnPesquisar.setBounds(139, 103, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblCpfCnpj = new JLabel(tipo);
		lblCpfCnpj.setBounds(64, 40, 56, 14);
		lblCpfCnpj.setSize(lblCpfCnpj.getPreferredSize());
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
		frmtdtxtfldPesquisa.setBounds(64, 56, 242, 20);
		getContentPane().add(frmtdtxtfldPesquisa);
	}
	
	public void setControl(TelaPrincipalControl controle) {
		this.controle = controle;
	}
}

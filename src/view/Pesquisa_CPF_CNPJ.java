package view;

import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

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

	private TelaPrincipalControl controle;
	private JFormattedTextField frmtdtxtfldPesquisa;
	private int tipoOperacao = 1;
	private String tipo = "CPF";
	
//	private int tipoOperacao;
	
	public Pesquisa_CPF_CNPJ(TelaPrincipalControl controll) {
		setClosable(true);
		setBounds(100, 100, 380, 195);
		getContentPane().setLayout(null);
		
		this.controle = controll;
		
		setTitle("Pesquisa de " + tipo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch(tipoOperacao) {
				case 1:
					controle.abreCadastroCliente(frmtdtxtfldPesquisa.getText());
					break;
				case 2:
					controle.alteraDadosCliente(frmtdtxtfldPesquisa.getText());
					break;
				case 3:
					controle.removeCliente(frmtdtxtfldPesquisa.getText());
					break;
				case 4:
					controle.cadastraFuncionario(frmtdtxtfldPesquisa.getText());
					break;
				case 5:
					controle.alteraDadosFuncionario(frmtdtxtfldPesquisa.getText());
					break;
				case 6:
					controle.promoveFuncionario(frmtdtxtfldPesquisa.getText());
					break;
				case 7:
					controle.desativaFuncionario(frmtdtxtfldPesquisa.getText());
					break;
				case 8:
					controle.cadastraFornecedor(frmtdtxtfldPesquisa.getText());
					break;
				case 9:
					controle.alteraDadosFornecedor(frmtdtxtfldPesquisa.getText());
					break;
				case 10:
					controle.desativaFornecedor(frmtdtxtfldPesquisa.getText());
					break;
				case 11:
					controle.cadastraProduto(frmtdtxtfldPesquisa.getText());
					break;
				case 12:
					controle.removeProduto(frmtdtxtfldPesquisa.getText());
					break;
				case 13:
					controle.solicitaProduto(frmtdtxtfldPesquisa.getText());
					break;
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
			switch(tipo) {
			case "CNPJ":
				frmtdtxtfldPesquisa = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
				frmtdtxtfldPesquisa.setColumns(14);
				break;
			case "CPF":
				frmtdtxtfldPesquisa = new JFormattedTextField(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
				frmtdtxtfldPesquisa.setColumns(10);
				break;
			case "C�digo EAN":
				frmtdtxtfldPesquisa = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("#############")));
				frmtdtxtfldPesquisa.setColumns(14);
				break;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		frmtdtxtfldPesquisa.setBounds(64, 56, 242, 20);
		getContentPane().add(frmtdtxtfldPesquisa);
	}
	
	public void setOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		
		if(tipoOperacao < 8) {
			tipo = "CPF";
		} else if(tipoOperacao < 11) {
			tipo = "CNPJ";
		} else {
			tipo = "C�digo EAN";
		}
	}
	
	public void dispose() {
		super.dispose();
		limpaFormulario();
	}
	public void limpaFormulario() {
		frmtdtxtfldPesquisa.setText("");
	}
}

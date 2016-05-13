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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private static final long serialVersionUID = 6203273259393355197L;
	private TelaPrincipalControl controle;
	private JFormattedTextField frmtdtxtfldPesquisa;
	private int tipoOperacao = 1;
	private String tipo = "CPF";
	
//	private int tipoOperacao;
	
	public Pesquisa_CPF_CNPJ(TelaPrincipalControl controll) {
		setClosable(true);
		setMaximizable(false);
		setResizable(false);
		setBounds(100, 100, 380, 195);
		getContentPane().setLayout(null);
		
		this.controle = controll;
		
		setTitle("Pesquisa de " + tipo);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pesquisa();
			}
		});
		btnPesquisar.setBounds(139, 103, 89, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblCpfCnpj = new JLabel(tipo);
		lblCpfCnpj.setBounds(64, 40, 56, 14);
		lblCpfCnpj.setSize(lblCpfCnpj.getPreferredSize());
		getContentPane().add(lblCpfCnpj);
		
		frmtdtxtfldPesquisa = new JFormattedTextField();
		frmtdtxtfldPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyCode());
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisa();
				}
			}
		});
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
			case "Código EAN":
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
			tipo = "Cï¿½digo EAN";
		}
	}
	
	public void dispose() {
		super.dispose();
		limpaFormulario();
	}
	public void limpaFormulario() {
		frmtdtxtfldPesquisa.setText("");
	}
	
	public void pesquisa() {
		switch(tipoOperacao) {
		case 1:
			if(!controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "clientes")) {
				controle.abreCadastroCliente(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado ja posui um cliente vinculado.", "Cliente ja cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 2:
			if(controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "clientes")) {
				controle.abreCadastroCliente(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado naoa possui um cliente vinculado.", "Cliente nao cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 3:
			if(controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "clientes")) {
				controle.removeCliente(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado naoa possui um cliente vinculado.", "Cliente nao cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 4:
			if(!controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "funcionarios")) {
				//controle.abreaCadastroFuncionario(frmtdtxtfldPesquisa.getText());
				controle.abreCadastroFuncionario(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado ja posui um funcionario vinculado.", "Funcionario ja cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 5:
			if(controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "funcionarios")) {
				//controle.abreaCadastroFuncionario(frmtdtxtfldPesquisa.getText());
				controle.abreCadastroFuncionario(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado nao posui um funcionario vinculado.", "Funcionario nao cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 6:
			if(controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "funcionarios")) {
				//controle.abreaCadastroFuncionario(frmtdtxtfldPesquisa.getText());
				controle.promoveFuncionario(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado nao posui um funcionario vinculado.", "Funcionario nao cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 7:
			if(controle.pesquisaChave(frmtdtxtfldPesquisa.getText(), "funcionarios")) {
				//controle.abreaCadastroFuncionario(frmtdtxtfldPesquisa.getText());
				controle.desativaFuncionario(frmtdtxtfldPesquisa.getText());
			} else {
				JOptionPane.showMessageDialog(this, "O CPF informado nao posui um funcionario vinculado.", "Funcionario nao cadastrado", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 8:
			controle.abreCadastroFornecedor(frmtdtxtfldPesquisa.getText());
			break;
		case 9:
			controle.abreCadastroFornecedor(frmtdtxtfldPesquisa.getText());
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
}

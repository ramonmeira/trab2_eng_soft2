package control;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import view.CadastroCliente;
import view.Pesquisa_CPF_CNPJ;
import view.TelaLogin;
import view.TelaLoginInternal;
import view.TelaPrincipal;

public class TelaPrincipalControl {
	
	TelaPrincipal telaPrincipal;
	TelaLoginInternal telaLogin;
	Pesquisa_CPF_CNPJ pesquisaCliente = null;
	Pesquisa_CPF_CNPJ pesquisaFuncionario = null;
	Pesquisa_CPF_CNPJ pesquisaFornecedor = null;
	Pesquisa_CPF_CNPJ pesquisaProduto = null;
	
	boolean usuarioLogado = false;
	String usuario = null;
	
	public TelaPrincipalControl(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}
	
	public void abreCadastroCliente() {
		if(!CadastroCliente.getInstance().isVisible()) {
			pesquisaFuncionario = new Pesquisa_CPF_CNPJ(1);
			pesquisaFuncionario.setControl(this);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abreAlterarDadosCliente() {
		if(!CadastroCliente.getInstance().isVisible()) {
			pesquisaFuncionario = new Pesquisa_CPF_CNPJ(2);
			pesquisaFuncionario.setControl(this);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abreRemoverCliente() {
		if(!CadastroCliente.getInstance().isVisible()) {
			pesquisaFuncionario = new Pesquisa_CPF_CNPJ(3);
			pesquisaFuncionario.setControl(this);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abreTelaLogin() {
		telaLogin = TelaLoginInternal.getInstance();
		telaLogin.setControl(this);
		telaPrincipal.addInternalFrame(telaLogin);
		telaLogin.setVisible(true);
	}
	
	public void usuarioAutenticado(String login, String senha) {
		//TODO fazer o login
//		if(login OK) {
//			telaPrincipal.ativarMenus(true);
//		};
		
		if(false) { //checar usuário
			JOptionPane.showMessageDialog(telaPrincipal, "Usuário ou senha não conferem. Por favor tente novamente.", "Usuário ou senha inválido!", JOptionPane.WARNING_MESSAGE);
		} else {
			usuario = login;
			usuarioLogado = true;
			telaLogin.dispose();
			telaPrincipal.ativarMenus(true);
		}
	}
	
	public void pesquisaCPF(String CPF) {
//		if(cpf valido){
		pesquisaCliente.dispose();
		pesquisaCliente = null;
		CadastroCliente cadastroCliente = CadastroCliente.getInstance();
		cadastroCliente.setControl(this);
		telaPrincipal.addInternalFrame(cadastroCliente);
		cadastroCliente.setVisible(true);
	}
	
}

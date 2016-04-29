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
	Pesquisa_CPF_CNPJ pesquisaCPF = null;
	Pesquisa_CPF_CNPJ pesquisaCNPJ = null;
	
	boolean usuarioLogado = false;
	String usuario = null;
	
	public TelaPrincipalControl(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}
	
	public void abreCadastroCliente() {
//		CadastroCliente cadastroCliente = CadastroCliente.getInstance();
//		telaPrincipal.addInternalFrame(cadastroCliente);
//		cadastroCliente.setVisible(true);
		if(!CadastroCliente.getInstance().isVisible()) {
			pesquisaCPF = new Pesquisa_CPF_CNPJ("CPF");
			pesquisaCPF.setControl(this);
			telaPrincipal.addInternalFrame(pesquisaCPF);
			pesquisaCPF.setVisible(true);
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
		pesquisaCPF.dispose();
		pesquisaCPF = null;
		CadastroCliente cadastroCliente = CadastroCliente.getInstance();
		cadastroCliente.setControl(this);
		telaPrincipal.addInternalFrame(cadastroCliente);
		cadastroCliente.setVisible(true);
	}
	
}

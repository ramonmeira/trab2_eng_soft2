package control;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import view.CadastroCliente;
import view.CadastroEstoque;
import view.CadastroFuncionario;
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
		pesquisaCliente = new Pesquisa_CPF_CNPJ(this);
		pesquisaFuncionario = new Pesquisa_CPF_CNPJ(this);
		pesquisaFornecedor = new Pesquisa_CPF_CNPJ(this);
		pesquisaProduto = new Pesquisa_CPF_CNPJ(this);
	}
	
	public void abrePesquisaCliente(int tipo) {
		if(!CadastroCliente.getInstance().isVisible() && !pesquisaCliente.isVisible()) {
			pesquisaCliente.setOperacao(tipo);
			telaPrincipal.addInternalFrame(pesquisaCliente);
			pesquisaCliente.setVisible(true);
		}
	}
	
	public void abrePesquisaFuncionario(int tipo) {
		if(!CadastroFuncionario.getInstance().isVisible() && pesquisaFuncionario == null) {
			pesquisaFuncionario.setOperacao(tipo);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abrePesquisaForncedor(int tipo) {
		
	}
	
	public void abrePesquisaProduto(int tipo) {
		
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
	
	public boolean pesquisaCPF(String CPF) {
//		if(cpf valido){
//			return true;
//		}
		return false;
	}
	
	public boolean pesquisaCNPJ(String CNPJ) {
//		if(cnpj encontrado){
//			return true;
//		}
		return false;
	}
	
	public boolean pesquisaEAN(String EAN) {
//		if(cnpj encontrado){
//			return true;
//		}
		return false;
	}
	
	public void cadastraCliente(String CPF) {
		if(!pesquisaCPF(CPF)) {
			pesquisaCliente.dispose();
			//pesquisaCliente = null;
			CadastroCliente cadastroCliente = CadastroCliente.getInstance();
			cadastroCliente.setControl(this); //Diz qual classe vai fazer o controle do frame
			telaPrincipal.addInternalFrame(cadastroCliente);
			cadastroCliente.setVisible(true);
			return;
		}
		JOptionPane.showMessageDialog(pesquisaCliente, "O CPF informado já posui um cliente vinculado.", "Cliente já cadastrado", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alteraDadosCliente(String CPF) {
		if(pesquisaCPF(CPF)) {
			pesquisaCliente.dispose();
			CadastroCliente cadastroCliente = CadastroCliente.getInstance(); // Fazer o cadastro do cliente vir preenchido
			cadastroCliente.setControl(this);
			telaPrincipal.addInternalFrame(cadastroCliente);
			cadastroCliente.setVisible(true);
			return;
		}
		JOptionPane.showMessageDialog(pesquisaCliente, "Não foi encontrado nenhum cliente com o CPF informado", "Cliente não encontrado", JOptionPane.WARNING_MESSAGE);
	}
	
	public void removeCliente(String CPF) {
		if(pesquisaCPF(CPF)) {
			pesquisaCliente.dispose();
			JOptionPane.showMessageDialog(pesquisaCliente, "Cliente removido com sucesso", "Cliente removido", JOptionPane.WARNING_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(pesquisaCliente, "Não foi encontrado nenhum cliente com o CPF informado", "Cliente não encontrado", JOptionPane.WARNING_MESSAGE);
	}
	
	public void cadastraFuncionario(String CPF) {
				
	}
	
	public void alteraDadosFuncionario(String CPF) {
		
	}
	
	public void promoveFuncionario(String CPF) {
		
	}
	
	public void desativaFuncionario(String CPF) {
		
	}
	
	public void cadastraFornecedor(String CNPJ) {
		
	}
	
	public void alteraDadosFornecedor(String CNPJ) {
		
	}
	
	public void desativaFornecedor(String CNPJ) {
		
	}
	
	public void cadastraProduto(String EAN) {
		
	}
	
	public void removeProduto(String EAN) {
		
	}
	
	public void solicitaProduto(String EAN) {
		
	}
	
	public void cadastraEstoque() {
		CadastroEstoque cadastroEstoque = CadastroEstoque.getInstance();
		cadastroEstoque.setControl(this);
		telaPrincipal.addInternalFrame(cadastroEstoque);
		cadastroEstoque.setVisible(true);
		return;
	}
	
	public void alterarEstoque() {
		//Fazer uma busca para entregar o fomulário com os dados preenchidos
		CadastroEstoque cadastroEstoque = CadastroEstoque.getInstance();
		cadastroEstoque.setControl(this);
		telaPrincipal.addInternalFrame(cadastroEstoque);
		cadastroEstoque.setVisible(true);
		return;		
	}
	
}

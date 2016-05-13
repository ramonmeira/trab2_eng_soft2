package control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import data.model.Cliente;
import data.model.Funcionario;
import data.tools.fileDao;
import view.CadastroCliente;
import view.CadastroEstoque;
import view.CadastroFornecedor;
import view.CadastroFuncionario;
import view.CadastroProduto;
import view.Pesquisa_CPF_CNPJ;
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
		if(!CadastroFuncionario.getInstance().isVisible() && !pesquisaFuncionario.isVisible()) {
			pesquisaFuncionario.setOperacao(tipo);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abrePesquisaForncedor(int tipo) {
		if(!CadastroFornecedor.getInstance().isVisible() && !pesquisaFornecedor.isVisible()) {
			pesquisaFornecedor.setOperacao(tipo);
			telaPrincipal.addInternalFrame(pesquisaFornecedor);
			pesquisaFornecedor.setVisible(true);
		}
	}
	
	public void abrePesquisaProduto(int tipo) {
		if(!CadastroProduto.getInstance().isVisible() && !pesquisaProduto.isVisible()) {
			pesquisaProduto.setOperacao(tipo);
			telaPrincipal.addInternalFrame(pesquisaProduto);
			pesquisaProduto.setVisible(true);
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
		
		if(false) { //checar usu�rio
			JOptionPane.showMessageDialog(telaPrincipal, "Usu�rio ou senha n�o conferem. Por favor tente novamente.", "Usu�rio ou senha inv�lido!", JOptionPane.WARNING_MESSAGE);
		} else {
			usuario = login;
			usuarioLogado = true;
			telaLogin.dispose();
			telaPrincipal.ativarMenus(true);
		}
	}
	
	public boolean pesquisaCPF(String CPF, String arquivo) {
		if(CPF.isEmpty() || CPF == null  || CPF.length() < 11) {
			JOptionPane.showMessageDialog(telaPrincipal, "CPF informado invalido!", "CPF invalido", JOptionPane.WARNING_MESSAGE);
		} else {
			fileDao dao = new fileDao();
			if(arquivo.equals("clientes")) {
				Cliente cliente = new Cliente();
				cliente.setCpf(CPF);
				if(dao.existeObjeto(cliente, arquivo)) {
					return true;
				}
			} else {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(CPF);
				if(dao.existeObjeto(funcionario, arquivo)) {
					return true;
				}
			}
		}
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
	
	
	
	public void abreCadastroCliente(String CPF) {
		pesquisaCliente.limpaFormulario();
		pesquisaCliente.dispose();
		telaPrincipal.addInternalFrame(CadastroCliente.getInstance());
		CadastroCliente.getInstance().setControl(this);
		
		if(pesquisaCPF(CPF, "clientes")) {
			fileDao dao = new fileDao();
			Cliente cliente = new Cliente();
			cliente.setCpf(CPF);
			ArrayList<String> dados = dao.getDados(cliente, "clientes");
			CadastroCliente.getInstance().insereDados(dados);
		} else {
			CadastroCliente.getInstance().limpaCampos();
		}
		CadastroCliente.getInstance().setVisible(true);
	}
	
	public void salvaDadosCliente(Cliente cliente) {
		ArrayList<String> dados = cliente.getDadosSerializados();
		if(pesquisaCPF(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "clientes")) {
			atualizaCliente(cliente);
		} else {
			cadastraCliente(cliente);
		}
	}
	
	public void cadastraCliente(Cliente cliente) {
		fileDao dao = new fileDao();
		dao.adicionaObjeto(cliente, "clientes");
		CadastroCliente.getInstance().limpaCampos();
		CadastroCliente.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroCliente.getInstance(), "Cliente cadastrado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void atualizaCliente(Cliente cliente) {
		fileDao dao = new fileDao();
		dao.atualizaObjeto(cliente, "clientes");
		CadastroCliente.getInstance().limpaCampos();
		CadastroCliente.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroCliente.getInstance(), "Dados atualizados com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void removeCliente(String CPF) {
		fileDao dao = new fileDao();
		Cliente cliente = new Cliente();
		cliente.setCpf(CPF);
		dao.removeObjeto(cliente, "clientes");
		pesquisaCliente.limpaFormulario();
		pesquisaCliente.dispose();
		JOptionPane.showMessageDialog(pesquisaCliente, "Cliente removido com sucesso", "Cliente removido", JOptionPane.WARNING_MESSAGE);
	}
	
	public void abreCadastroFuncionario(String CPF) {
		pesquisaFuncionario.limpaFormulario();
		pesquisaFuncionario.dispose();
		telaPrincipal.addInternalFrame(CadastroFuncionario.getInstance());
		CadastroFuncionario.getInstance().setControl(this);
		if(pesquisaCPF(CPF, "funcionarios")) {
			fileDao dao = new fileDao();
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(CPF);
			ArrayList<String> dados = dao.getDados(funcionario, "funcionarios");
			CadastroFuncionario.getInstance().insereDados(dados);
		} else {
			CadastroFuncionario.getInstance().limpaCampos();
		}
		CadastroFuncionario.getInstance().setVisible(true);
	}
	
	public void salvaDadosFuncionarios(Funcionario funcionario) {
		ArrayList<String> dados = funcionario.getDadosSerializados();
		if(pesquisaCPF(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "funcionarios")) {
			atualizaFuncionario(funcionario);
		} else {
			cadastraFuncionario(funcionario);
		}
	}
	
	public void cadastraFuncionario(Funcionario funcionario) {
		fileDao dao = new fileDao();
		dao.adicionaObjeto(funcionario, "funcionarios");
		CadastroFuncionario.getInstance().limpaCampos();
		CadastroFuncionario.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Funcionario cadastrado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);				
	}
	
	public void atualizaFuncionario(Funcionario funcionario) {
		fileDao dao = new fileDao();
		dao.atualizaObjeto(funcionario, "funcionarios");
		CadastroCliente.getInstance().limpaCampos();
		CadastroCliente.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Dados atualizados com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void promoveFuncionario(String CPF) {
		fileDao dao = new fileDao();
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(CPF);
		ArrayList<String> dados = dao.getDados(funcionario, "funcionarios");
		if(dados.get(4).equals("false")) {
			dados.remove(4);
			dados.add(4,"true");
			pesquisaFuncionario.limpaFormulario();
			pesquisaFuncionario.dispose();
			dao.atualizaObjeto(funcionario, "funcionarios");
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Funcionario promovido com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Este funcionario ja e um gerente", "Erro!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void desativaFuncionario(String CPF) {
		fileDao dao = new fileDao();
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(CPF);
		ArrayList<String> dados = dao.getDados(funcionario, "funcionarios");
		if(dados.get(5).equals("true")) {
			dados.remove(5);
			dados.add(5,"falase");
			pesquisaFuncionario.limpaFormulario();
			pesquisaFuncionario.dispose();
			dao.atualizaObjeto(funcionario, "funcionarios");
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Funcionario desativado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Este funcionario ja esta desativado", "Erro!", JOptionPane.WARNING_MESSAGE);
		}
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
		//Fazer uma busca para entregar o fomul�rio com os dados preenchidos
		CadastroEstoque cadastroEstoque = CadastroEstoque.getInstance();
		cadastroEstoque.setControl(this);
		telaPrincipal.addInternalFrame(cadastroEstoque);
		cadastroEstoque.setVisible(true);
		return;		
	}
	
}

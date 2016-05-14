package control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import data.model.Cliente;
import data.model.Estoque;
import data.model.Fornecedor;
import data.model.Funcionario;
import data.model.ObjetoPersistente;
import data.model.Produto;
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
		pesquisaCliente = new Pesquisa_CPF_CNPJ(this, 1);
		pesquisaFuncionario = new Pesquisa_CPF_CNPJ(this, 4);
		pesquisaFornecedor = new Pesquisa_CPF_CNPJ(this, 8);
		pesquisaProduto = new Pesquisa_CPF_CNPJ(this, 11);
	}
	
	public void abrePesquisaCliente(int tipo) {
		if(!CadastroCliente.getInstance().isVisible() && !pesquisaCliente.isVisible()) {
//			pesquisaCliente.setOperacao(tipo);
			pesquisaCliente = new Pesquisa_CPF_CNPJ(this, tipo);
			telaPrincipal.addInternalFrame(pesquisaCliente);
			pesquisaCliente.setVisible(true);
		}
	}
	
	public void abrePesquisaFuncionario(int tipo) {
		if(!CadastroFuncionario.getInstance().isVisible() && !pesquisaFuncionario.isVisible()) {
//			pesquisaFuncionario.setOperacao(tipo);
			pesquisaFuncionario = new Pesquisa_CPF_CNPJ(this, tipo);
			telaPrincipal.addInternalFrame(pesquisaFuncionario);
			pesquisaFuncionario.setVisible(true);
		}
	}
	
	public void abrePesquisaForncedor(int tipo) {
		if(!CadastroFornecedor.getInstance().isVisible() && !pesquisaFornecedor.isVisible()) {
//			pesquisaFornecedor.setOperacao(tipo);
			pesquisaFornecedor = new Pesquisa_CPF_CNPJ(this, tipo);
			telaPrincipal.addInternalFrame(pesquisaFornecedor);
			pesquisaFornecedor.setVisible(true);
		}
	}
	
	public void abrePesquisaProduto(int tipo) {
		if(!CadastroProduto.getInstance().isVisible() && !pesquisaProduto.isVisible()) {
//			pesquisaProduto.setOperacao(tipo);
			pesquisaProduto = new Pesquisa_CPF_CNPJ(this, tipo);
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
			JOptionPane.showMessageDialog(telaPrincipal, "Usuario ou senha nao conferem. Por favor tente novamente.", "Usuario ou senha invalido!", JOptionPane.WARNING_MESSAGE);
		} else {
			usuario = login;
			usuarioLogado = true;
			telaLogin.dispose();
			telaPrincipal.ativarMenus(true);
		}
	}
	
	public boolean pesquisaChave(String chave, String arquivo) {
		fileDao dao = new fileDao();
		ObjetoPersistente objeto = null;
		switch(arquivo) {
		case "clientes":
			Cliente cliente = new Cliente();
			cliente.setCpf(chave);
			objeto = cliente;
			break;
		case "funcionarios":
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(chave);
			objeto = funcionario;
			break;
		case "fornecedores":
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCnpj(chave);
			objeto = fornecedor;
			break;
		case "produtos":
			Produto produto = new Produto();
			produto.setCodEan(chave);
			objeto = produto;
			break;
		case "estoque":
			Estoque estoque = new Estoque();
			estoque.setCodEan(chave);
			objeto = estoque;
			break;
		}
		if(dao.existeObjeto(objeto, arquivo)) {
			return true;
		} 
		return false;
	}

	public void abreCadastroCliente(String CPF) {
		pesquisaCliente.limpaFormulario();
		pesquisaCliente.dispose();
		telaPrincipal.removeInternalFrame(pesquisaCliente);
		telaPrincipal.addInternalFrame(CadastroCliente.getInstance());
		CadastroCliente.getInstance().setControl(this);
		
		if(pesquisaChave(CPF, "clientes")) {
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
		if(pesquisaChave(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "clientes")) {
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
		telaPrincipal.removeInternalFrame(pesquisaCliente);
		JOptionPane.showMessageDialog(pesquisaCliente, "Cliente removido com sucesso", "Cliente removido", JOptionPane.WARNING_MESSAGE);
	}
	
	public void abreCadastroFuncionario(String CPF) {
		pesquisaFuncionario.limpaFormulario();
		pesquisaFuncionario.dispose();
		telaPrincipal.removeInternalFrame(pesquisaFuncionario);
		telaPrincipal.addInternalFrame(CadastroFuncionario.getInstance());
		CadastroFuncionario.getInstance().setControl(this);
		if(pesquisaChave(CPF, "funcionarios")) {
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
		if(pesquisaChave(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "funcionarios")) {
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
		CadastroFuncionario.getInstance().limpaCampos();
		CadastroFuncionario.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Dados atualizados com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void promoveFuncionario(String CPF) {
		fileDao dao = new fileDao();
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(CPF);
		ArrayList<String> dados = dao.getDados(funcionario, "funcionarios");
		if(dados.get(4).equals("GERENTE=false")) {
			dados.remove(4);
			dados.add(4,"GERENTE=true");
			pesquisaFuncionario.limpaFormulario();
			pesquisaFuncionario.dispose();
			telaPrincipal.removeInternalFrame(pesquisaFuncionario);
			funcionario.setDados(dados);
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
		if(dados.get(5).equals("ATIVO=true")) {
			dados.remove(5);
			dados.add(5,"ATIVO=false");
			pesquisaFuncionario.limpaFormulario();
			pesquisaFuncionario.dispose();
			telaPrincipal.removeInternalFrame(pesquisaFuncionario);
			funcionario.setDados(dados);
			dao.atualizaObjeto(funcionario, "funcionarios");
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Funcionario desativado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Este funcionario ja esta desativado", "Erro!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void abreCadastroFornecedor(String CNPJ) {
		pesquisaFornecedor.limpaFormulario();
		pesquisaFornecedor.dispose();
		telaPrincipal.removeInternalFrame(pesquisaFornecedor);
		telaPrincipal.addInternalFrame(CadastroFornecedor.getInstance());
		CadastroFornecedor.getInstance().setControl(this);
		if(pesquisaChave(CNPJ, "fornecedores")) {
			fileDao dao = new fileDao();
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCnpj(CNPJ);
			ArrayList<String> dados = dao.getDados(fornecedor, "fornecedores");
			CadastroFornecedor.getInstance().insereDados(dados);
		} else {
			CadastroFornecedor.getInstance().limpaCampos();
		}
		CadastroFornecedor.getInstance().setVisible(true);
	}
	
	public void salvaDadosFornecedor(Fornecedor fornecedor) {
		ArrayList<String> dados = fornecedor.getDadosSerializados();
		if(pesquisaChave(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "fornecedores")) {
			atualizaFornecedor(fornecedor);
		} else {
			cadastraFornecedor(fornecedor);
		}
	}
	
	public void cadastraFornecedor(Fornecedor fornecedor) {
		fileDao dao = new fileDao();
		dao.adicionaObjeto(fornecedor, "fornecedores");
		CadastroFornecedor.getInstance().limpaCampos();
		CadastroFornecedor.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Fornecedor cadastrado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void atualizaFornecedor(Fornecedor fornecedor) {
		fileDao dao = new fileDao();
		dao.atualizaObjeto(fornecedor, "fornecedores");
		CadastroFornecedor.getInstance().limpaCampos();
		CadastroFornecedor.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Dados atualizados com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void desativaFornecedor(String CNPJ) {
		fileDao dao = new fileDao();
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj(CNPJ);
		ArrayList<String> dados = dao.getDados(fornecedor, "fornecedores");
		if(dados.get(2).equals("ATIVO=true")) {
			dados.remove(2);
			dados.add(2,"ATIVO=false");
			pesquisaFornecedor.limpaFormulario();
			pesquisaFornecedor.dispose();
			telaPrincipal.removeInternalFrame(pesquisaFornecedor);
			fornecedor.setDados(dados);
			dao.atualizaObjeto(fornecedor, "fornecedores");
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Fornecedor desativado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Este fornecedor ja esta desativado", "Erro!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void abreCadastroProduto(String EAN) {
		pesquisaProduto.limpaFormulario();
		pesquisaProduto.dispose();
		telaPrincipal.removeInternalFrame(pesquisaProduto);
		telaPrincipal.addInternalFrame(CadastroProduto.getInstance());
		CadastroProduto.getInstance().setControl(this);
		CadastroProduto.getInstance().limpaCampos();
		CadastroProduto.getInstance().setVisible(true);
	}
	
	public void cadastraProduto(Produto produto) {
		fileDao dao = new fileDao();
		dao.adicionaObjeto(produto, "produtos");
		CadastroProduto.getInstance().limpaCampos();
		CadastroProduto.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Produto cadastrado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);	
	}
	
	public void removeProduto(String EAN) {
		fileDao dao = new fileDao();
		Produto produto = new Produto();
		produto.setCodEan(EAN);
		dao.removeObjeto(produto, "produtos");
		pesquisaProduto.limpaFormulario();
		pesquisaProduto.dispose();
		telaPrincipal.removeInternalFrame(pesquisaProduto);
		JOptionPane.showMessageDialog(pesquisaProduto, "Produto removido com sucesso", "Produto removido", JOptionPane.WARNING_MESSAGE);
	}
	
	public void abreCadastroEstoque(String EAN) {
		pesquisaProduto.limpaFormulario();
		pesquisaProduto.dispose();
		telaPrincipal.removeInternalFrame(pesquisaProduto);
		telaPrincipal.addInternalFrame(CadastroEstoque.getInstance());
		CadastroEstoque.getInstance().setControl(this);		
		if(pesquisaChave(EAN, "estoque")) {
			fileDao dao = new fileDao();
			Estoque estoque = new Estoque();
			estoque.setCodEan(EAN);
			ArrayList<String> dados = dao.getDados(estoque, "estoque");
			CadastroEstoque.getInstance().insereDados(dados);
		} else {
			CadastroEstoque.getInstance().limpaCampos();
		}
		CadastroEstoque.getInstance().setVisible(true);
	}
	
	public void salvaDadosEstoque(Estoque estoque) {
		ArrayList<String> dados = estoque.getDadosSerializados();
		if(pesquisaChave(dados.get(0).substring(dados.get(0).indexOf("=") + 1), "estoque")) {
			alterarEstoque(estoque);
		} else {
			cadastraEstoque(estoque);
		}
	}
	
	public void cadastraEstoque(Estoque estoque) {
		fileDao dao = new fileDao();
		dao.adicionaObjeto(estoque, "estoque");
		CadastroEstoque.getInstance().limpaCampos();
		CadastroEstoque.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Estoque cadastrado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alterarEstoque(Estoque estoque) {
		fileDao dao = new fileDao();
		dao.atualizaObjeto(estoque, "estoque");
		CadastroEstoque.getInstance().limpaCampos();
		CadastroEstoque.getInstance().dispose();
		JOptionPane.showMessageDialog(CadastroFuncionario.getInstance(), "Estoque alterado com sucesso!", "Sucesso!", JOptionPane.WARNING_MESSAGE);	
	}
	
}

package data.model;

import java.util.ArrayList;

public class Funcionario extends PessoaFisica implements ObjetoPersistente{
	private String login;
	private String senha;
	private String gerente;
	
//-=-=-=-=-=-=-=-=-=-=-=-=- Getters e Setters -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados são lidos da seguinte forma
		 * 1ª posição contém a chave, 2ª contém o valor
		 * A chave primára fica sempre na posição 0, neste caso o CPF é a chave primária
		 */
		
		dados.add("CPF="+cpf);
		dados.add("NOME="+nome);
		dados.add("LOGIN="+login);
		dados.add("SENHA="+senha);
		dados.add("GERENTE="+gerente);
		
		return dados;
	}
}

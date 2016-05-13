package data.model;

import java.util.ArrayList;

public class Funcionario extends PessoaFisica implements ObjetoPersistente{
	private String login;
	private String senha;
	private String gerente;
	private String ativo;
	
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
	public String getAtivo() {
		return this.ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados são lidos da seguinte forma
		 * 1ª posição contém a chave, 2ª contém o valor
		 * A chave primára fica sempre na posição 0, neste caso o CPF é a chave primária
		 */
		
		dados.add(0,"CPF="+cpf);
		dados.add(1,"NOME="+nome);
		dados.add(2,"LOGIN="+login);
		dados.add(3,"SENHA="+senha);
		dados.add(4,"GERENTE="+gerente);
		dados.add(5,"ATIVO="+ativo);
		
		return dados;
	}
}

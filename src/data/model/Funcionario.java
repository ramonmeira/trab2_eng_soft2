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
	public void setDados(ArrayList<String> dados) {
		this.cpf = dados.get(0).substring(dados.get(0).indexOf("=") + 1);
		this.nome = dados.get(1).substring(dados.get(1).indexOf("=") + 1);
		this.login = dados.get(2).substring(dados.get(2).indexOf("=") + 1);
		this.senha = dados.get(3).substring(dados.get(3).indexOf("=") + 1);
		this.gerente = dados.get(4).substring(dados.get(4).indexOf("=") + 1);
		this.ativo = dados.get(5).substring(dados.get(5).indexOf("=") + 1);
	}
	
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados s�o lidos da seguinte forma
		 * 1� posi��o cont�m a chave, 2� cont�m o valor
		 * A chave prim�ra fica sempre na posi��o 0, neste caso o CPF � a chave prim�ria
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

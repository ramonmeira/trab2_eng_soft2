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
		 */
		
		dados.add("CPF");
		dados.add(cpf);
		
		dados.add("NOME"); //Neste caso NOME é a chave do valor contido na variável nome.
		dados.add(nome);
		
		dados.add("CPF");
		dados.add(cpf);
		
		dados.add("RG");
		dados.add(rg);
		
		dados.add("ORGAO EXPEDIDOR");
		dados.add(orgaoExpedidor);
		
		dados.add("UF EXPEDIDOR");
		dados.add(ufExpepdidor);
		
		dados.add("DATA EMISSAO");
		dados.add(dataEmissao);
		
		dados.add("DATA NASCIMENTO");
		dados.add(dataNascimento);
		
		dados.add("NACIONALIDADE");
		dados.add(nacionalidade);
		
		dados.add("NATURALIDADE");
		dados.add(naturalidade);
		
		dados.add("UF NASCIMENTO");
		dados.add(ufNascimento);
		
		dados.add("SEXO");
		dados.add(sexo);
		
		dados.add("CEP");
		dados.add(cep);
		
		dados.add("LOGRADOURO");
		dados.add(logradouro);
		
		dados.add("NUMERO");
		dados.add(numero);
		
		dados.add("COMPLEMENTO");
		dados.add(complemento);
		
		dados.add("CIDADE");
		dados.add(cidade);
		
		dados.add("UF ENDERECO");
		dados.add(ufEndereco);
		
		dados.add("TEL RESIDENCIAL");
		dados.add(telResidencial);
		
		dados.add("TEL CELULAR");
		dados.add(telCelular);
		
		dados.add("EMAIL");
		dados.add(email);
		
		dados.add("EMAIL COMERCIAL");
		dados.add(emailComercial);
		
		dados.add("LOGIN");
		dados.add(login);
		
		dados.add("SENHA");
		dados.add(senha);
		
		dados.add("GERENTE");
		dados.add(gerente);		
		
		return dados;
	}
}

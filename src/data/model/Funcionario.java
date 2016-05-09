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
		
		dados.add("CPF="+cpf);
		dados.add("NOME="+nome); //Neste caso NOME é a chave do valor contido na variável nome.
		dados.add("RG="+rg);
		dados.add("ORGAO EXPEDIDOR="+orgaoExpedidor);
		dados.add("UF EXPEDIDOR="+ufExpepdidor);
		dados.add("DATA EMISSAO="+dataEmissao);
		dados.add("DATA NASCIMENTO="+dataNascimento);
		dados.add("NACIONALIDADE="+nacionalidade);
		dados.add("NATURALIDADE="+naturalidade);
		dados.add("UF NASCIMENTO="+ufNascimento);
		dados.add("SEXO="+sexo);
		dados.add("CEP="+cep);
		dados.add("LOGRADOURO="+logradouro);
		dados.add("NUMERO="+numero);
		dados.add("COMPLEMENTO="+complemento);		
		dados.add("CIDADE="+cidade);		
		dados.add("UF ENDERECO="+ufEndereco);
		dados.add("TEL RESIDENCIAL="+telResidencial);		
		dados.add("TEL CELULAR="+telCelular);
		dados.add("EMAIL="+email);
		dados.add("EMAIL COMERCIAL="+email);
		dados.add("LOGIN="+login);
		dados.add("SENHA="+senha);
		dados.add("GERENTE="+gerente);
		
		return dados;
	}
}

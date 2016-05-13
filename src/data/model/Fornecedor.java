package data.model;

import java.util.ArrayList;

public class Fornecedor implements ObjetoPersistente{
	private String razaoSocial;
	private String cnpj;
	private String ativo;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public void setDados(ArrayList<String> dados) {
		this.cnpj = dados.get(0).substring(dados.get(0).indexOf("=") + 1);
		this.razaoSocial = dados.get(1).substring(dados.get(1).indexOf("=") + 1);
		this.ativo = dados.get(2).substring(dados.get(2).indexOf("=") + 1);
	}
	
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados são lidos da seguinte forma
		 * 1ª posição contém a chave, 2ª contém o valor
		 * A chave primára fica sempre na posição 0, neste caso o CPF é a chave primária
		 */
		
		dados.add(0,"CNPJ="+cnpj);
		dados.add(1,"RAZAO SOCIAL="+razaoSocial);
		dados.add(2,"ATIVO="+ativo);
		
		return dados;
	}
}

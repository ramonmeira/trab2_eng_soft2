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
		 * Os dados s�o lidos da seguinte forma
		 * 1� posi��o cont�m a chave, 2� cont�m o valor
		 * A chave prim�ra fica sempre na posi��o 0, neste caso o CPF � a chave prim�ria
		 */
		
		dados.add(0,"CNPJ="+cnpj);
		dados.add(1,"RAZAO SOCIAL="+razaoSocial);
		dados.add(2,"ATIVO="+ativo);
		
		return dados;
	}
}

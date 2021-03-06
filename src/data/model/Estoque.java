package data.model;

import java.util.ArrayList;

public class Estoque implements ObjetoPersistente{
	private String codEan;
	private String modelo;
	private String qtd;
	
	public String getCodEan() {
		return codEan;
	}
	public void setCodEan(String codEan) {
		this.codEan = codEan;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getQtd() {
		return qtd;
	}
	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
	
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados s�o lidos da seguinte forma
		 * 1� posi��o cont�m a chave, 2� cont�m o valor
		 * A chave prim�ra fica sempre na posi��o 0, neste caso o CPF � a chave prim�ria
		 */
		
		dados.add(0,"CODIGO EAN="+codEan);
		dados.add(1,"MODELO="+modelo);
		dados.add(2, "QUANTIDADE="+qtd);
		
		return dados;
	}
}

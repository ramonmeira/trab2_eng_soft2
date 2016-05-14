package data.model;

import java.util.ArrayList;

public class Produto implements ObjetoPersistente{
	private String modelo;
	private String codEan;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCodEan() {
		return codEan;
	}
	public void setCodEan(String codEan) {
		this.codEan = codEan;
	}
	
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados são lidos da seguinte forma
		 * 1ª posição contém a chave, 2ª contém o valor
		 * A chave primára fica sempre na posição 0, neste caso o CPF é a chave primária
		 */
		
		dados.add(0,"CODIGO EAN="+codEan);
		dados.add(1,"MODELO="+modelo);
		
		return dados;
	}
}

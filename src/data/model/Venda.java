package data.model;

import java.util.ArrayList;

public class Venda implements ObjetoPersistente{
	
	public String cpfCliente;
	public String clienteNome;
	public String cpfVendedor;
	public String vendedorNome;
	public ArrayList<String> produtos;
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(String cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
	}

	public String getVendedorNome() {
		return vendedorNome;
	}

	public void setVendedorNome(String vendedorNome) {
		this.vendedorNome = vendedorNome;
	}
	
	public void adicionaProduto(String produto) {
		produtos.add(produto);
	}
	
	public Venda() {
		produtos = new ArrayList<String>();
	}
	
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		dados.add(0,"CPF CLIENTE="+cpfCliente);
		dados.add(1,"NOME CLIENTE="+clienteNome);
		dados.add(2,"CPF VENDEDOR="+cpfVendedor);
		dados.add(3,"NOME VENDEDOR="+vendedorNome);
		if(produtos.size() > 0) {
			int i = 0;
			for(String produto : produtos) {
				dados.add(i+4,"PRODUTO " + String.valueOf(i + 1) + "=" + produto);
				i++;
			}
		}		
		return dados;
	}

}

package data.model;

import java.util.ArrayList;

public class Cliente extends PessoaFisica implements ObjetoPersistente{
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados são lidos da seguinte forma
		 * 1ª posição contém a chave, 2ª contém o valor
		 */
		
		//Neste caso NOME é a chave do valor contido na variável nome.
		dados.add(0,"CPF="+cpf);							//0
		dados.add(1,"NOME="+nome); 						//1	
		
		return dados;
	}
}

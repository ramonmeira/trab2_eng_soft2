package data.model;

import java.util.ArrayList;

public class Cliente extends PessoaFisica implements ObjetoPersistente{
	public ArrayList<String> getDadosSerializados() {
		ArrayList<String> dados = new ArrayList<String>();
		
		/*
		 * Os dados s�o lidos da seguinte forma
		 * 1� posi��o cont�m a chave, 2� cont�m o valor
		 */
		
		//Neste caso NOME � a chave do valor contido na vari�vel nome.
		dados.add(0,"CPF="+cpf);							//0
		dados.add(1,"NOME="+nome); 						//1	
		
		return dados;
	}
}

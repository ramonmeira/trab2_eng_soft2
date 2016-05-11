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
		dados.add(1, "NOME="+nome); 						//1
		dados.add(2, "RG="+rg);								//2
		dados.add(3, "ORGAO EXPEDIDOR="+orgaoExpedidor);	//3
		dados.add(4, "UF EXPEDIDOR="+ufExpepdidor);			//4
		dados.add(5, "DATA EMISSAO="+dataEmissao);			//5
		dados.add(6, "DATA NASCIMENTO="+dataNascimento);	//6
		dados.add(7, "NACIONALIDADE="+nacionalidade);		//7
		dados.add(8, "NATURALIDADE="+naturalidade);			//8
		dados.add(9, "UF NASCIMENTO="+ufNascimento);		//9
		dados.add(10, "SEXO="+sexo);						//10
		dados.add(11, "CEP="+cep);							//11
		dados.add(12, "LOGRADOURO="+logradouro);			//12
		dados.add(13, "NUMERO="+numero);					//13
		dados.add(14, "COMPLEMENTO="+complemento);			//14
		dados.add(15, "CIDADE="+cidade);					//15
		dados.add(16, "UF ENDERECO="+ufEndereco);			//16
		dados.add(17, "TEL RESIDENCIAL="+telResidencial);	//17
		dados.add(18, "TEL CELULAR="+telCelular);			//18
		dados.add(19, "EMAIL="+email);						//19
		dados.add(20, "EMAIL COMERCIAL="+email);			//20		
		
		return dados;
	}
}

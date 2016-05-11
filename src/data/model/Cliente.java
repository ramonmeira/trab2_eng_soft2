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
		dados.add("CPF="+cpf);							//0
		dados.add("NOME="+nome); 						//1
		dados.add("RG="+rg);							//2
		dados.add("ORGAO EXPEDIDOR="+orgaoExpedidor);	//3
		dados.add("UF EXPEDIDOR="+ufExpepdidor);		//4
		dados.add("DATA EMISSAO="+dataEmissao);			//5
		dados.add("DATA NASCIMENTO="+dataNascimento);	//6
		dados.add("NACIONALIDADE="+nacionalidade);		//7
		dados.add("NATURALIDADE="+naturalidade);		//8
		dados.add("UF NASCIMENTO="+ufNascimento);		//9
		dados.add("SEXO="+sexo);						//10
		dados.add("CEP="+cep);							//11
		dados.add("LOGRADOURO="+logradouro);			//12
		dados.add("NUMERO="+numero);					//13
		dados.add("COMPLEMENTO="+complemento);			//14
		dados.add("CIDADE="+cidade);					//15
		dados.add("UF ENDERECO="+ufEndereco);			//16
		dados.add("TEL RESIDENCIAL="+telResidencial);	//17
		dados.add("TEL CELULAR="+telCelular);			//18
		dados.add("EMAIL="+email);						//19
		dados.add("EMAIL COMERCIAL="+email);			//20		
		
		return dados;
	}
}

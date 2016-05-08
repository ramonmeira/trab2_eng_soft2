package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cliente extends PessoaFisica implements ObjetoPersistencia{
	public ArrayList<String> obterDadosSerializados() {
		ArrayList<String> dadosSerializados = new ArrayList<String>();
		
		dadosSerializados.add(nome);
		dadosSerializados.add(cpf);
		dadosSerializados.add(orExp);
		dadosSerializados.add(ufExp);
		dadosSerializados.add((new SimpleDateFormat("dd/MM/yyyy")).format(dtEmissao));
		dadosSerializados.add((new SimpleDateFormat("dd/MM/yyyy")).format(dtNascimento));
		dadosSerializados.add(sexo);
		dadosSerializados.add(cep);
		dadosSerializados.add(logradouro);
		dadosSerializados.add(numero);
		dadosSerializados.add(complemente);
		dadosSerializados.add(cidade);
		dadosSerializados.add(ufEnd);
		dadosSerializados.add(telResi);
		dadosSerializados.add(telCel);
		dadosSerializados.add(email);
		dadosSerializados.add(emailComerc);
		
		return dadosSerializados;
	}
}

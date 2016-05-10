package data.tools;

import java.util.ArrayList;

import data.model.ObjetoPersistente;

public class fileDao {
	public boolean existeObjeto(ObjetoPersistente objeto, String arquivo) {
		ArrayList<String> dados = objeto.getDadosSerializados();		
		ArrayList<String> linhas = FileOperations.getFileLines(arquivo);
		return linhas.contains(dados.get(0));
	}
	
	public void adicionaObjeto(ObjetoPersistente objeto, String arquivo) {
		ArrayList<String> linhas = FileOperations.getFileLines(arquivo);
		linhas.addAll(objeto.getDadosSerializados());
		FileOperations.writeList(linhas, arquivo);
	}
	
	public void atualizaObjeto(ObjetoPersistente objeto, String arquivo) {
		ArrayList<String> dados = objeto.getDadosSerializados();		
		ArrayList<String> linhas = FileOperations.getFileLines(arquivo);
		int indiceChave = linhas.indexOf(dados.get(0));
		
		//Apagando os dados antigos
		for(int i = indiceChave + 1; i < (indiceChave + dados.size()); i++) {
			int j = 1;
			linhas.remove(i);
			linhas.add(i, dados.get(j)); //A chave nunca é atualizada
			j++;
		}	
	}
	
	public void removeObjeto(ObjetoPersistente objeto, String arquivo) {
		ArrayList<String> dados = objeto.getDadosSerializados();		
		ArrayList<String> linhas = FileOperations.getFileLines(arquivo);
		int indiceChave = linhas.indexOf(dados.get(0));
		
		//Apagando os dados antigos
		for(int i = indiceChave; i < (indiceChave + dados.size()); i++) {
			linhas.remove(i);
		}	
	}
	
	public boolean loginValido(String login, String senha) {
		ArrayList<String> linhas = FileOperations.getFileLines("funcionarios");
		if(linhas.contains("LOGIN="+login)){
			if(linhas.get(linhas.indexOf("LOGIN="+login) + 1).substring(6).equals(senha)) {
				return true;
			}
		}
		return false;
	}
}

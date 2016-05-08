package view.models;

import java.io.IOException; 
import java.io.Serializable;
import java.util.ArrayList;

import view.models.Pessoa;
import view.models.PessoaTableModel;
import view.models.DataStore;

public class CargaPessoas implements Serializable  {

	public CargaPessoas(PessoaTableModel modelP) {
		DataStore datastore = DataStore.getInstance();
		try{
			ArrayList<Pessoa> p = new ArrayList<Pessoa>();
			Pessoa pessoa1 = new Pessoa("Andre","04998083554","deco123");
			p.add(pessoa1);
			datastore.savePessoas(p);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}

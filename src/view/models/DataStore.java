package view.models;
import java.util.ArrayList; 
import java.io.*;

import view.models.Pessoa;
@SuppressWarnings("serial")
public class DataStore implements Serializable {
		
	private static DataStore instance = null;
		
	private static String pessoasData = "pessoas.obj";
		
	private DataStore() {
			
	}

	public static DataStore getInstance() {
		if(instance == null) {
			instance = new DataStore();		
		}		
		return instance;
	}

	public static void savePessoas(ArrayList<Pessoa> vec) throws IOException {
		FileOutputStream f = new FileOutputStream(pessoasData);
		ObjectOutputStream oos = new ObjectOutputStream(f);
		oos.writeObject(vec);
		oos.close();
		f.close();		
	}
	
	public static ArrayList<Pessoa> loadPessoas() throws Exception {
		FileInputStream f = new FileInputStream(pessoasData);
		ObjectInputStream ois = new ObjectInputStream(f);
		ArrayList<Pessoa> vec = (ArrayList<Pessoa>)ois.readObject();
		ois.close();
		f.close();
		return vec;
	}
	
	
	
}


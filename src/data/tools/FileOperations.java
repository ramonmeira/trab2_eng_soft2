package data.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOperations {
	
	public static void initializeFiles() {
		createFile("clientes.txt");
		createFile("funcionarios.txt");
		createFile("fornecedores.txt");
		createFile("produtos.txt");
		createFile("estoque.txt");
		createFile("vendas.txt");
	}
	
	private static void createFile(String fileName) {
		File file = new File(fileName);
		if(!file.exists() && !file.isDirectory()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeString(String writeStrinf, String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", true));
			bw.write(writeStrinf);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeList(ArrayList<String> lines, String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", false));
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getFileLines(String fileName) {
		ArrayList<String> fileLines;
		try {
			fileLines = new ArrayList<String>(Files.readAllLines(Paths.get(fileName + ".txt"), Charset.defaultCharset()));
			return fileLines;
		} catch (IOException e) {
			e.printStackTrace();
		};
		return null;
	}
}

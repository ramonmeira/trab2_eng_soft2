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
	
	private static File clientes;
	private static File funcionarios;
	private static File fornecedores;
	private static File produtos;
	private static File estoque;
	
	public static void initializeFiles() {
		clientes = createFile(clientes, "clientes.txt");
		funcionarios = createFile(funcionarios, "funcionarios.txt");
		fornecedores = createFile(fornecedores, "fornecedores.txt");
		produtos = createFile(produtos, "produtos");
		estoque = createFile(estoque, "extoque.txt");
	}
	
	private static File createFile(File file, String fileName) {
		file = new File(fileName);
		if(!file.exists() && file.isDirectory()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	public void writeString(String writeStrinf, String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", false));
			bw.write(writeStrinf);
			bw.newLine();
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

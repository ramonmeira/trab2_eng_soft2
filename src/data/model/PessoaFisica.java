package data.model;

public abstract class PessoaFisica {
	protected String nome;
	protected String cpf;
	
//-=-=-=-=-=-=-=-=-=-=-=-=- Getters e Setters -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
}

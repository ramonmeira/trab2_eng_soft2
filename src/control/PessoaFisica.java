package control;

import java.util.Date;

public abstract class PessoaFisica {
	protected String nome;
	protected String cpf;
	protected String orExp;
	protected String ufExp;
	protected Date dtEmissao;
	protected Date dtNascimento;
	protected String sexo;
	protected String cep;
	protected String logradouro;
	protected String numero;
	protected String complemente;
	protected String cidade;
	protected String ufEnd;
	protected String telResi;
	protected String telCel;
	protected String email;
	protected String emailComerc;
	
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
	public String getOrExp() {
		return orExp;
	}
	public void setOrExp(String orExp) {
		this.orExp = orExp;
	}
	public String getUfExp() {
		return ufExp;
	}
	public void setUfExp(String ufExp) {
		this.ufExp = ufExp;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemente() {
		return complemente;
	}
	public void setComplemente(String complemente) {
		this.complemente = complemente;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUfEnd() {
		return ufEnd;
	}
	public void setUfEnd(String ufEnd) {
		this.ufEnd = ufEnd;
	}
	public String getTelResi() {
		return telResi;
	}
	public void setTelResi(String telResi) {
		this.telResi = telResi;
	}
	public String getTelCel() {
		return telCel;
	}
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailComerc() {
		return emailComerc;
	}
	public void setEmailComerc(String emailComerc) {
		this.emailComerc = emailComerc;
	}
}

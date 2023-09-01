package br.com.sprint.model;

public class Usuario {
	
	private int codUsuario;
	private String primeiroNome;
	private String meioNome;
	private String ultimoNome;
	private String email;
	
	
	public Usuario(String primeiroNome, String meioNome, String ultimoNome, String email) {
		this.primeiroNome = primeiroNome;
		this.meioNome = meioNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}
	
	public Usuario() {}



	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getMeioNome() {
		return meioNome;
	}
	public void setMeioNome(String meioNome) {
		this.meioNome = meioNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

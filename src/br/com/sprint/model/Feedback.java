package br.com.sprint.model;

import java.sql.Date;

public class Feedback {
	
	private int 	codFeedback;
	private String 	mensagem;
	private Date 	dataEnvio; 
	private Date 	horaEnvio;
	private int 	likes;
	
	private int codCategoria;
	private int codUsuario;
	private int codPrioridade;
	
	
	public Feedback(String mensagem, Date dataEnvio, Date horaEnvio, int likes, int codCategoria, int codUsuario, int codPrioridade) {
		this.mensagem = mensagem;
		this.dataEnvio = new Date(System.currentTimeMillis());
		this.horaEnvio = new Date(System.currentTimeMillis());
		this.likes = 0;
		
		this.codCategoria = codCategoria;
		this.codUsuario = codUsuario;
		this.codPrioridade = codPrioridade;
	}
	
	public Feedback() {}


	public int getCodFeedback() {
		return codFeedback;
	}


	public void setCodFeedback(int codFeedback) {
		this.codFeedback = codFeedback;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Date getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}


	public Date getHoraEnvio() {
		return horaEnvio;
	}


	public void setHoraEnvio(Date horaEnvio) {
		this.horaEnvio = horaEnvio;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getCodCategoria() {
		return codCategoria;
	}


	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}


	public int getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}


	public int getCodPrioridade() {
		return codPrioridade;
	}


	public void setCodPrioridade(int codPrioridade) {
		this.codPrioridade = codPrioridade;
	}
}

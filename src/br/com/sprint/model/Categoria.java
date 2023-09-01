package br.com.sprint.model;

public class Categoria {
	
	private int codCategoria;
	private String nome;
	private String descricao;
	
	
	public Categoria (String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Categoria () {}


	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

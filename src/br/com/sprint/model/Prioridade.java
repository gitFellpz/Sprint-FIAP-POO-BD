package br.com.sprint.model;

public class Prioridade {
	
	private int codPrioridade;
    private String nome;
    private String descricao;
    
    
	public Prioridade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Prioridade() {}


	public int getCodPrioridade() {
		return codPrioridade;
	}
	public void setCodPrioridade(int codPrioridade) {
		this.codPrioridade = codPrioridade;
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

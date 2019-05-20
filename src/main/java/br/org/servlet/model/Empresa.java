package br.org.servlet.model;

public class Empresa {

	private Long id;
	private String nome;
	private String dataAbertura;
	
	

	public Empresa(String nome, String dataAbertura) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	
	public Empresa() {

	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public String getDataAbertura() {
		return dataAbertura;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", dataAbertura=" + dataAbertura + ", id=" + id + "]";
	}


}

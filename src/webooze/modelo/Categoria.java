package webooze.modelo;

public class Categoria extends EntidadeDominio {
	private String nome;
	private int diasValidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDiasValidade() {
		return diasValidade;
	}
	public void setDiasValidade(int diasValidade) {
		this.diasValidade = diasValidade;
	}
}

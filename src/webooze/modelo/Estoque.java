package webooze.modelo;

public class Estoque extends EntidadeDominio {
	private Long quantidadeAtual;
	private Long quantidadeMaxima;
	private Long quantidadeMinima;

	public Long getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(Long quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public Long getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(Long quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	public Long getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Long quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
}

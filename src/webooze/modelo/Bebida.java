package webooze.modelo;

import java.util.Date;

public class Bebida extends EntidadeDominio {
	private String nome;
	private String fornecedor;
	private String fabricante;
	private Categoria categoria;
	private String ingredientes;
	private Date dataFabricacao;
	private Date dataValidade;
	private boolean alcoolica;
	private double teorAlcool;
	private boolean consumivel;
	private double preco;
	private Estoque estoque;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public boolean isAlcoolica() {
		return alcoolica;
	}

	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}

	public double getTeorAlcool() {
		return teorAlcool;
	}

	public void setTeorAlcool(double teorAlcool) {
		this.teorAlcool = teorAlcool;
	}

	public boolean isConsumivel() {
		return consumivel;
	}

	public void setConsumivel(boolean consumivel) {
		this.consumivel = consumivel;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}

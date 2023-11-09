package model;

public class ServicoBean {
	private int id;
	private String descricao;
	private double valor;
			
	public ServicoBean() {
		
	}
	
	public ServicoBean(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public ServicoBean(int id, String descricao, double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	} 
	
	
	
}

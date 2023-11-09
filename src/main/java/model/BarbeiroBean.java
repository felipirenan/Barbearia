package model;

public class BarbeiroBean {
	private int id;
	private String nome; 
	private String telefone;
	
	public BarbeiroBean() {
		
	}
	
	public BarbeiroBean(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		
	}
	
	public BarbeiroBean(int id ,String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		
	}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}

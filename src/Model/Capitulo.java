package Model;

public class Capitulo {
	
	private String nome;
	private String link;
	
	public Capitulo(String nome, String link) {
		super();
		this.nome = nome;
		this.link = link;
	}

	public Capitulo() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}

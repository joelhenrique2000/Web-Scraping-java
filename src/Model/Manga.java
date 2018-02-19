package Model;

import java.util.List;

public class Manga {
	private String titulo;
	private String genero;
	private String descricao;
	private List<Capitulo> capitulos;
	
	public Manga() {
		
	}
	
	public Manga(String titulo, String genero, String descricao) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

}

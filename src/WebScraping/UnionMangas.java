package WebScraping;

import java.io.IOException;

import WebScraping.unionmangas.PaginaCapitulos;
import WebScraping.unionmangas.PaginaMangas;

public class UnionMangas {
	private PaginaMangas paginaMangas;
	private PaginaCapitulos paginaCapitulos;
	
	public UnionMangas(PaginaMangas paginaMangas, PaginaCapitulos paginaCapitulos) {
		super();
		this.paginaMangas = paginaMangas;
		this.paginaCapitulos = paginaCapitulos;
	}

	public PaginaMangas getPaginaMangas() {
		return paginaMangas;
	}
	
	public void setPaginaMangas(PaginaMangas paginaMangas) {
		this.paginaMangas = paginaMangas;
	}
	
	public PaginaCapitulos getPaginaCapitulos() {
		return paginaCapitulos;
	}
	
	public void setPaginaCapitulos(PaginaCapitulos paginaCapitulos) {
		this.paginaCapitulos = paginaCapitulos;
	}
	
}

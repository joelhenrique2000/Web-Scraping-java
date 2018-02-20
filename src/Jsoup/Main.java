package Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.Capitulo;
import Model.Manga;
import WebScraping.UnionMangas;
import WebScraping.unionmangas.PaginaCapitulos;
import WebScraping.unionmangas.PaginaMangas;

public class Main {
	
	public static void main(String[] args) {

		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite a url do manga, exemplo: http://unionmangas.cc/manga/one-piece");
			String urlManga = sc.next();
			
			PaginaCapitulos paginaCapitulos = new PaginaCapitulos();
			PaginaMangas paginaMangas = new PaginaMangas("http://unionmangas.cc/manga/one-piece");
			UnionMangas unionMangas = new UnionMangas(paginaMangas,paginaCapitulos);

			Manga manga = new Manga(unionMangas.getPaginaMangas().getTitulo(), unionMangas.getPaginaMangas().getGenero(), unionMangas.getPaginaMangas().getDescricao(), unionMangas.getPaginaMangas().getCapitulos());

			System.out.printf("+-------------------------------------+\n"
					+ "Nome do manga: %s\n"
					+ "Generos do manga: %s\n"
					+ "Descricao do manga: %s\n"
					+ "+-------------------------------------+\n",
					manga.getTitulo(),manga.getGenero(),manga.getDescricao());
			
			for(Capitulo cap : manga.getCapitulos()) {
				unionMangas.getPaginaCapitulos().salvar(cap);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}

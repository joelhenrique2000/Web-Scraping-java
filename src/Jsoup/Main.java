package Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.Capitulo;
import Model.Manga;
import WebScraping.unionmangas.PaginaCapitulo;
import WebScraping.unionmangas.PaginaManga;

public class Main {
	
	private static Document documentHTML;
	
	public static void main(String[] args) {

		try {

			documentHTML = Jsoup.connect("http://unionmangas.cc/manga/one-piece").userAgent("Mozilla").timeout(0).get();
			
			PaginaManga paginaManga = new PaginaManga();
			PaginaCapitulo paginaCapitulo = new PaginaCapitulo();

			Manga manga = new Manga(paginaManga.getTitulo(), paginaManga.getGenero(), paginaManga.getDescricao(), paginaManga.getCapitulos());

			System.out.printf("+-------------------------------------+\n"
					+ "Nome do manga: %s\n"
					+ "Generos do manga: %s\n"
					+ "Descricao do manga: %s\n"
					+ "+-------------------------------------+\n",
					manga.getTitulo(),manga.getGenero(),manga.getDescricao());
			
			System.out.println();
			
			for(Capitulo cap : manga.getCapitulos()) {
				new SalvarCapitulo().salvar(cap);
			}
			

			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}

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

public class Main {
	
	private static Document documentHTML;
	
	public static void main(String[] args) {

		try {

			documentHTML = Jsoup.connect("http://unionmangas.cc/manga/one-piece").userAgent("Mozilla").timeout(0).get();
			
			Manga manga = new Manga();
			List<Capitulo> caps = capitulos();
			
			manga.setDescricao(getDescricao());
			manga.setTitulo(getTitulo());
			manga.setGenero(getGenero());
			manga.setCapitulos(caps);

			System.out.println("Titulo: " + manga.getTitulo());
			System.out.println("Genero: " + manga.getGenero());
			System.out.println("Descrição: " + manga.getDescricao());

			System.out.println();
			
			for(Capitulo cap : manga.getCapitulos()) {
				new SalvarCapitulo().salvar(cap);
			}
			

			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public static void salvarImg(Capitulo cap) throws IOException {

	}
	
	public static String getTitulo() {
        return documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.row").eq(0).text();
	}
	
	public static String getGenero() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.row").eq(2);
		for(Element element : elements) {
			return element.select("div").eq(4).select("a").text();
		}
		
		return "desconhecido";
	}
	
	public static String getDescricao() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.row").eq(2);
		for(Element element : elements) {
			return element.select("div").eq(9).text();
		}
		return null;

	}
	
	public static List<Capitulo> capitulos() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.lancamento-linha");
		ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
		
		for(Element element : elements) {
			
			Capitulo capitulo = new Capitulo();
			
			String nome = element.select("div.col-xs-6.col-md-6 a").eq(0).text();
			
			capitulo.setNome(nome);
			
			Elements capituloHTML = element.select("div.col-xs-6.col-md-6").eq(0);
			for(Element linkCap : capituloHTML) {
				
				String link = linkCap.select("a").attr("href");
				
				capitulo.setLink(link);
			}
			
			capitulos.add(capitulo);
		}
		
		return capitulos;
	}
	
}

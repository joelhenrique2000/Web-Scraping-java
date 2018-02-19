package WebScraping.unionmangas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.Capitulo;

public class PaginaManga {
	
	private static Document documentHTML;
	
	public PaginaManga() throws IOException {
		documentHTML = Jsoup.connect("http://unionmangas.cc/manga/one-piece").userAgent("Mozilla").timeout(0).get();
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
	
	public static List<Capitulo> getCapitulos() {
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

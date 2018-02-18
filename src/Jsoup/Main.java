package Jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	
	private static Document documentHTML;
	
	public static void main(String[] args) {

		try {

			documentHTML = Jsoup.connect("http://unionmangas.cc/manga/fairy-tail").get();
			
			System.out.println("Titulo: " + getTitulo());
			System.out.println("Genero: " + getGenero());
			System.out.println(getAutor());
			System.out.println("Descrição: " + getDescricao());

			System.out.println();
			
			capitulos();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
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
	
	public static String getAutor() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.row").eq(2);
		for(Element element : elements) {
			Elements autor = element.select("div").eq(5);
			for(Element element2 : autor) {
				return element2.text();
			}
		}
		return "";
	}
	
	public static String getDescricao() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.row").eq(2);
		for(Element element : elements) {
			return element.select("div").eq(9).text();
		}
		return null;

	}
	
	public static void capitulos() {
		Elements elements = documentHTML.select("div.col-md-8.tamanho-bloco-perfil div.lancamento-linha");
		for(Element element : elements) {
			System.out.println(element.text());
		}
	}
	
}

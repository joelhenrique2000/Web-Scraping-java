package WebScraping.unionmangas;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Jsoup.SalvarCapitulo;
import Model.Capitulo;

public class PaginaCapitulos {
	
	public void salvar(Capitulo capitulo) {
		Document documentHTML;int i =0;
		try {
			documentHTML = Jsoup.connect(capitulo.getLink()).userAgent("Mozilla").timeout(0).get();
			
			Elements elem = documentHTML.select("div.row").eq(0);
			
			for(Element el : elem) {
				
				Elements pato = el.select("img");
				
				int numero = 0;
				
				for(Element a : pato) {
					//System.out.println(a.attr("src"));
					SalvarCapitulo salvarDir = new SalvarCapitulo(capitulo.getNome());
					salvarDir.salvarDir("http:"+a.attr("src"),numero);
					
					numero += 1;
				}

				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

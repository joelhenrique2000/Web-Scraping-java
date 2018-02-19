package Jsoup;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.Capitulo;

public class SalvarCapitulo {

	
	public void salvar(Capitulo capitulo) {
		Document documentHTML;int i =0;
		try {
			documentHTML = Jsoup.connect(capitulo.getLink()).userAgent("Mozilla").timeout(0).get();
			
			Elements elem = documentHTML.select("div.row").eq(0);
			
			for(Element el : elem) {
				
				Elements pato = el.select("img");
				
				int numero = 0;
				
				for(Element a : pato) {
					System.out.println(a.attr("src"));
					salvarDir("http:"+a.attr("src"),numero);
					numero += 1;
				}

				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvarDir(String urlImagem, int numero) {

        try {
    		final String urlStr = urlImagem;
    		final URL url = new URL(urlStr);
    		final HttpURLConnection connection = (HttpURLConnection) url
    		        .openConnection();
    		connection.setRequestProperty(
    		    "User-Agent",
    		    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
    		final BufferedImage image = ImageIO.read(connection.getInputStream());
    		
            ImageIO.write(image, "jpg",new File("C:\\Users\\Joel\\Desktop\\pato\\"+numero+".png"));
            //ImageIO.write(image, "gif",new File("C:\\out.gif"));
            //ImageIO.write(image, "png",new File("C:\\out.png"));
             
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
	}
	

}

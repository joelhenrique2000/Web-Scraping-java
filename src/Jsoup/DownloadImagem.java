package Jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DownloadImagem {
	public static void main(String[] args) {
		Document documentHTML;
		
		try {
			documentHTML = Jsoup.connect("").get();
			
			
		}catch(IOException e) {
			
		}
	}
}

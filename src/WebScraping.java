import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;


public class WebScraping{
	
	final static Logger logger = Logger.getLogger(WebScraping.class);
	
	private final static String URL = "https://www.tekstowo.pl/piosenka,";
	
	public static String getSongLyrics(String getsinger, String getsong) throws IOException {
	logger.info("Entering the getSongLyrics Method....");
	final String URL = "https://www.tekstowo.pl/piosenka,";
	String myLyrics = " ";
	String collectEnglishLyrics = null;
	logger.info("Entering Website....");
    Document document = Jsoup.connect(URL + getsinger.replace(" ", "_").toLowerCase() + "," + getsong.replace(" ", "_").toLowerCase()+".html").get();
    String gettitle = document.title();
    System.out.println(gettitle);
    Element englishlyrics = document.select("div.inner-text").get(0); 

     
     //getting ENGLISH element's child nodes by element.childNotes individually and print all.
     for (Node child : englishlyrics.childNodes()) {
	        if (child instanceof TextNode) {
	        	// System.out.println(((TextNode) child).text());
	        	myLyrics= myLyrics + (((TextNode)child).getWholeText());
	        	
             }
	     }
     System.out.println(myLyrics);
     System.out.println("\n");
     logger.info("Exit the method name getSongLyrics");
	return myLyrics;

    }
 }


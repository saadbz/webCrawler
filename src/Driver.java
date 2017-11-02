import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Driver
{
    public static int  i = 0;
    public static void main(String[] args){
//        ArrayList <UrlObject> as = new ArrayList<>();
        LinkedList as = new LinkedList();
       Crawler crawler = new Crawler();
       UrlObject urlObject = new UrlObject();
       urlObject.setVisited(false);
       urlObject.setUrl("http://www.cse.uaa.alaska.edu/~mcenek/csce311/");
       crawler.goQ(urlObject, as, 0);
       for (int i =1; i<= as.size(); i++){
           UrlObject u = (UrlObject) as.get(i);
           System.out.println(u.isVisited());
           System.out.println(u.getTitle());
           System.out.println(u.getUrl());
       }
    }
}

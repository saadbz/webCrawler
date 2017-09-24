import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Driver
{
    public static void main(String[] args) {
        ArrayList <UrlObject> as = new ArrayList<>();
       Crawler crawler = new Crawler();
       UrlObject urlObject = new UrlObject();
       urlObject.setVisited(true);
       urlObject.setUrl("http://www.cse.uaa.alaska.edu/~mcenek/csce311/");
       as.add(urlObject);


       crawler.goQ(urlObject, as, 0);


        for (UrlObject o: as)
        {
            System.out.println(o.getUrl().toString());
            System.out.println(o.isVisited());

        }
    }




}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Crawler{
    public static int  i = 1;
    public void goQ(UrlObject url, LinkedList as, int t) {
        try {
            if (url.isVisited() == false) {
                Document doc = null;
                try {
                    doc = Jsoup.connect(url.getUrl()).get();
                    String title = doc.title();
                    url.setTitle(title);
                    url.setVisited(true);
                    as.add(url);
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements anchorTag = doc.select("a[href]");
                for (Element link : anchorTag) {
                    String s = link.absUrl("href");
                    UrlObject urlObject = new UrlObject();
                    urlObject.setVisited(false);
                    urlObject.setUrl(s);
                    as.add(urlObject);
                }
                goQ((UrlObject) as.get(i), as, 0);
            } else{
                i++;
                goQ((UrlObject) as.get(i), as, 0);
            }
        } catch (Exception e) {
            return;
        }
    }
}

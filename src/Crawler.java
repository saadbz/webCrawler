import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Crawler{

    public void goQ(UrlObject url, ArrayList<UrlObject> as, int t)
    {
        Document doc = null;
        try
        {
            doc = Jsoup.connect(url.getUrl()).get();
            url.setVisited(true);
            as.set(t, url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements anchorTag = doc.select("a[href]");
        for (Element link : anchorTag)
        {

            String s = link.absUrl("href");
            UrlObject urlObject = new UrlObject();
            urlObject.setVisited(false);
            urlObject.setUrl(s);
            as.add(urlObject);
            //System.out.println(s);
        }
        int i = 0;
        while(true)
        {

            goQ(as.get(0), as, i);
            i ++;
            if (i == as.size())
            {
                i = 0;
                break;
            }
        }

    }


}

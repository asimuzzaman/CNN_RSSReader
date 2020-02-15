import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
	Writer class
**/
public class Writer implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Fetching RSS feed data from CNN in thread# " + Thread.currentThread().getId());

            //reader section
            try {
                FileWriter write = new FileWriter("d:\a.rss");
                write.write(readRSSFeed("http://rss.cnn.com/rss/edition.rss"));
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //reader section ends
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private  String readRSSFeed(String urlAddress){
        try{
            URL rssUrl = new URL (urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));

            String result= "";
            String line;
            while((line=in.readLine())!=null) {
                result += line + "\n";
            }
            in.close();
            System.out.println("Successfully fetched data from RSS feed.");

            return result;
        } catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        } catch (IOException ioe){
            System.out.println("Error reading from feed.");
        }
        return null;
    }
}

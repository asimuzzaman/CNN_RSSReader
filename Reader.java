import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Reader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Fetching JPG image references from a.rss in thread# " + Thread.currentThread().getId());

            showRSS("a.rss");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void showRSS(String fileName) {
        try {
            FileReader read = new FileReader(fileName);
            Scanner scan = new Scanner(read);

            String result = "";
            String line;
            String startText = "url=\""; //start string for searching
            String endText = ".jpg\""; //end string for searching

            while(scan.hasNextLine()) {
                int startAt = 0;
                int endAt = 0;

                line = scan.nextLine();

                while (startAt >= 0) {
                    startAt = line.indexOf("url=\"", endAt); //calc start index of necessary portion of string

                    if (startAt >= 0) {
                        endAt = line.indexOf(".jpg\"", startAt); //calc end index of necessary portion of string

                        //avoiding bug due to non jpg image starts here
                        int diffUrlToJpg = endAt - startAt;
                        int diffUrlToUrl = line.indexOf("url=\"", startAt+4) - startAt; //4 for " url" "

                        if (diffUrlToUrl > 0 && diffUrlToJpg > diffUrlToUrl) { //found the non JPG reference, checking > 0 to detect end of file
                            int nearestUrl = startAt;

                            while(nearestUrl < endAt) {
                                startAt = nearestUrl;
                                nearestUrl = line.indexOf("url=\"", startAt+4);
                            }

                        }
                        //avoiding... ends here
                        result += line.substring(startAt + "url=\"".length(), endAt) + ".jpg\n"; //concat the searched and necessary part of string
                    }
                }
            }
            scan.close();

            System.out.println(result); //displaying final string
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

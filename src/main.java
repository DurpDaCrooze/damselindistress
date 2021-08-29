import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("Getting your lady :))");
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Woman")
                .get();

        try{
            URL url = new URL("https:" + doc.select("#mw-content-text > div.mw-parser-output > div:nth-child(5) > div > a > img").attr("src"));
            Image img = ImageIO.read(url);
            File newFile = new File("pic.jpg");

            System.out.println("url:" + url);

            if(newFile.createNewFile()){
                ImageIO.write((RenderedImage) img, "jpg", newFile);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Done!");
    }

}

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://aambassador.com/images/car/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String resource = "";
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null){
                resource += temp;
            }
            System.out.println(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

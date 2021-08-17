import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://scar3crow.com/wallpapers/");
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
            //<a href="1210836281769.jpg">
            String reg = "<a href=" + "\".*?\\.jpg\"";
            List<String> links = getLinks(resource, Pattern.compile(reg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getLinks (String res, Pattern pattern){
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(res);
        while (matcher.find()){
            list.add(res.substring(matcher.start(), matcher.end()));
        }
        return list;
    }
}

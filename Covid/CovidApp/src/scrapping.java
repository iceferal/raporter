import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class scrapping {

    public static String adress = "https://rcb.gov.pl/raport-dobowy-covid-19/";
    public static String section = "div.post-content";
    public static String data;
    public static String today;
    public static String all;
    public static String dzisiaj;
    public static String zgony;
    public static String wyzdrowialo;
    public int kraj_lacznie;
    public int kraj_zmarlo;
    public int kraj_wyzdrowialo;

    
    public static String getData() throws Exception {
        setData();
        return data;    }

    public static void setData() throws Exception {
        Document doc = Jsoup.connect(adress).timeout(6000).get();
        Elements body = doc.select(section);
        String tmp = body.select("h1").toString();
        tmp = tmp.replaceAll("<h1><strong>", "");
        data = tmp.replaceAll("((<.strong).*(<.h1>))", "");    
        String datas = body.select("p").toString();
        today = datas.split("\n")[0];
        all = datas.split("\n")[1];    }

    public static String getDzisiaj() throws Exception {
        setDzisiaj();
        return dzisiaj;    }        

    public static void setDzisiaj() throws Exception{
        String tmp = today.replaceAll("&nbsp;", "");
        tmp = tmp.replaceAll("\\D", " ");
        tmp = tmp.replaceAll("\s*", " ");
        tmp = tmp.split("  ")[1];
        dzisiaj = tmp.replaceAll(" ", "");    }

    public static String getZgony() throws Exception {
        setZgony();
        return zgony;    }

    public static void setZgony() throws Exception {
        String tmp = today.replaceAll("&nbsp;", "");
        tmp = tmp.replaceAll("\\D", " ");
        tmp = tmp.replaceAll("\s*", " ");
        tmp = tmp.split("  ")[2];
        zgony = tmp.replaceAll(" ", "");    }   
        
    public static String getWyzdrowialo() throws Exception {
        setWyzdrowialo();
        return wyzdrowialo;    }

    public static void setWyzdrowialo() throws Exception {
        String tmp = today.replaceAll("&nbsp;", "");
        tmp = tmp.replaceAll("\\D", " ");
        tmp = tmp.replaceAll("\s*", " ");
        tmp = tmp.split("  ")[3];
        wyzdrowialo = tmp.replaceAll(" ", "");    }        

    // public static void main(String[] args) throws Exception {

    //     Document doc = Jsoup.connect("https://rcb.gov.pl/raport-dobowy-covid-19/").timeout(6000).get();
    //     Elements body = doc.select("div.post-content");
    //     String datas = body.select("p").toString();
    //     String today = datas.split("\n")[1];
    //     String tmp = today.replaceAll("&nbsp;", "");
    //     tmp = tmp.replaceAll("\\D", " ");
    //     tmp = tmp.replaceAll("\s*", " ");
    //     String kupa = tmp.split("  ")[2];
    //     System.out.println(kupa);
    // }
}

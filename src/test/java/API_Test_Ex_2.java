import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class API_Test_Ex_2 {

    public static void main(String[] args) throws IOException {
        MyGETRequest();
          }


     public static void MyGETRequest() throws IOException {

// HTTPS
         //System.setProperty("https.proxyHost", "https://web-cache.ird.govt.nz");
         //System.setProperty("https.proxyPort", "8080");

// settings proxy credentials
        // System.setProperty("http.proxyUser", "ed\17rpen");
         //System.setProperty("http.proxyPassword", "Passwd^100MLAN1");

        URL urlForGetRequest = new URL("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();



         boolean useproxy = true;
         useproxy = conection.usingProxy();
         System.out.println(useproxy);

        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here

         try {
             conection.setConnectTimeout(25000);
        int responseCode = conection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);}
            catch ( java.net.SocketTimeoutException e)  {
           }
         System.out.println("TO error");
         }

    }




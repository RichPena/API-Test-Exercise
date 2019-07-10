import jdk.nashorn.internal.AssertsEnabled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.lang.String;
import java.util.regex.Pattern;

public class API_Test_Ex_4 {

    public static void main(String[] args) throws IOException {
        MyGETRequest();
    }

    public static void MyGETRequest() throws IOException {
        URL urlForGetRequest = new URL("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();

        System.out.println("POST Response Code :  " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            //System.out.println("JSON String Result " + response.toString());

            String JsonResponse = response.toString();
            String[] output = JsonResponse.split(Pattern.quote(","));
            System.out.println(output.length);

            int i = 0;
            int x = output.length;


            while (i <= (output.length-2)) {
                String readArray = output[i];
                String readArrayNext = output[i+1];

                if ((readArray.contains("Name")) && (readArray.contains("Carbon credits")))
                {
                    System.out.println("Acceptance Criteria 1");
                    System.out.println(output[i]);
                    System.out.println("Passed");
                }

                Boolean matchOne = ((readArray.contains("Name")) && (readArray.contains("Carbon credits")));

                //if (readArray.contains("Name")) {
                //assert matchOne == true : "Test 1 Failed";}

                if ((readArray.contains("CanRelist")) && (readArray.contains("true")))
                {
                System.out.println("Acceptance Criteria 2");
                System.out.println(output[i]);
                System.out.println("Passed");
                }

                if (((readArray.contains("Name")) && (readArray.contains("Gallery"))
                     && (readArrayNext.contains("Description")) && (readArrayNext.contains("2x larger image"))))
                {
                    System.out.println("Acceptance Criteria 3");
                    System.out.println(output[i]);
                    System.out.println(output[i+1]);
                    System.out.println("Passed");
                }

                i++;
            }

        }
    }

}
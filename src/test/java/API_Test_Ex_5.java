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

public class API_Test_Ex_5 {
    public static void main(String[] args) throws IOException {
        MyGETRequest();
    }

    static void firstCheck(String tempArray){
        if ((tempArray.contains("Name")) && (tempArray.contains("Carbon credits")))
        {
            System.out.println("Acceptance Criteria 1");
            System.out.println(tempArray);
            System.out.println("Passed");
        }
    }

    static void secondCheck(String tempArray){
        if ((tempArray.contains("CanRelist")) && (tempArray.contains("true")))
        {
            System.out.println("Acceptance Criteria 2");
            System.out.println(tempArray);
            System.out.println("Passed");


             }
    }

    static void thirdCheck(String tempArray, String tempArrayNext){
        if (((tempArray.contains("Name")) && (tempArray.contains("Gallery"))
                && (tempArrayNext.contains("Description")) && (tempArrayNext.contains("2x larger image"))))
        {
            System.out.println("Acceptance Criteria 3");
            System.out.println(tempArray);
            System.out.println(tempArrayNext);
            System.out.println("Passed");
        }
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

                firstCheck(readArray);
                //secondCheck(readArray);
                //thirdCheck(readArray,readArrayNext);

                Boolean matchOne = ((readArray.contains("Name")) && (readArray.contains("Carbon credits")));
                assert matchOne == true : "Test 1 Failed";

                i++;
            }

        }
    }

}

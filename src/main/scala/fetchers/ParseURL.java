package fetchers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class ParseURL {


    public static response parse(String url) throws MalformedURLException, IOException {

        long unixTime;
        String genreJson = IOUtils.toString(new URL(url));
        JSONObject json = new JSONObject(genreJson);
        // get the title

        String updated = json.getJSONObject("time").getString("updated");
        Float rate = json.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float");
        // get the data

        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss z");
        try {
            Date date = dateFormat.parse(updated);
            unixTime = (long) date.getTime() / 1000;
        } catch(java.text.ParseException e) {
            System.out.println(e.getMessage());
            unixTime =  System.currentTimeMillis() / 1000L;
        }
        System.out.println("Bitcoin price is: " + rate.toString() + " at "+ updated);
        // get the first genre

        return new response(unixTime, rate);
    }

    public static class response{

        public long time;
        public float rate;

        public response(long time, float rate){
            this.rate = rate;
            this.time = time;
        }
    }
}

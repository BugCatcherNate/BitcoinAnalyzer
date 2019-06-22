package fetchers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class ParseURL {


    public static response parse(String url) throws MalformedURLException, IOException {

        String genreJson = IOUtils.toString(new URL(url));
        JSONObject json = new JSONObject(genreJson);
        // get the title

        String updated = json.getJSONObject("time").getString("updated");
        Float rate = json.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float");
        // get the data

        System.out.println("Bitcoin price is: " + rate.toString() + " at "+ updated);
        // get the first genre

        return new response(updated, rate);
    }

    public static class response{

        public String time;
        public float rate;

        public response(String time, float rate){
            this.rate = rate;
            this.time = time;
        }
    }
}

package com.relationshipone;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpService {

    private String baseUrl;
    private JsonService jsonService;

    public HttpService(String urlStr)  {
        baseUrl = urlStr;
    }

    /**
     * An indirect call to the JSON service.
     * @param keys The keys to print values for (if they exist)
     */
    public void getJson(String[] keys) {
        this.jsonService.getJson(keys);
    }

    /**
     * Method that makes a HTTP request with a query string (only 1 parameter).
     * @param param
     * @param value
     * @throws IOException
     */
    public void singleQuery(String param, String value) throws IOException {

        // Open connection
        URL url = new URL(baseUrl + "?" + param + "=" + value);
        URLConnection conn = url.openConnection();
        conn.connect();

        JsonElement response = JsonParser.parseReader(
                new InputStreamReader(conn.getInputStream())
        );
        this.jsonService = new JsonService(response);
    }
}

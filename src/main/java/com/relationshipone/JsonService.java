package com.relationshipone;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonService {

    JsonElement json;

    public JsonService(JsonElement json) {
        this.json = json;
    }

    /**
     * Prints the json data and handles it appropriately if it is a JSON array.
     * @param keys The keys to print values for (if they exist)
     */
    public void getJson(String[] keys)  {

        if ( json.isJsonArray() ) {

            // Iterate over JSONArray, the requested keys.
            for (int i = 0; i < json.getAsJsonArray().size(); i++) {

                System.out.println("/**** Entry: " + (i+1) + " ****/");
                JsonObject entry = json.getAsJsonArray().get(i).getAsJsonObject();
                for (String key : keys) {
                    if (entry.get(key) != null) {
                        System.out.println(key + ": " + entry.get(key).getAsString());
                    }
                }
            }
        }

        else if ( json.isJsonObject() ) {
            JsonObject entry = json.getAsJsonObject();
            for (String key : keys) {
                if (entry.get(key) != null) {
                    System.out.println( key + ": " + entry.get(key).getAsString() );
                }
            }
        }

        else {
            System.out.println("!!! ERROR: Did not receive valid JSON.");
        }
    }

}

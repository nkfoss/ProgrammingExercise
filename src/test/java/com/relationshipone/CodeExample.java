package com.relationshipone;

import org.junit.Test;

import java.io.IOException;

/**
 * Given the unsecured endpoint
 *      https://api.appcloud.relationshipone.com/appcloud/apps
 * and the query parameter
 *      eloquapackageId
 * of value
 *      153
 * retrieve all app records (there are 3) and print to the logs (system console is fine) the
 *      1. app name
 *      2. documentation link (if available)
 *
 * Use the example() test as a run container to invoke your code.
 * Put your code in src/main/java as though it would be production code.
 * Make as many classes as you like. Use whatever libraries you like.
 * Don't over-engineer, but separate responsibility into different classes where reasonable.
 */
public class CodeExample {

    @Test
    public void example() throws IOException {

        // Hardcoded for this example. In reality, URL and query string would come from elsewhere.
        HttpService httpService = new HttpService(
                "https://api.appcloud.relationshipone.com/appcloud/apps"
        );

        httpService.singleQuery("eloquapackageId", "153");
        httpService.getJson(new String[]{ "name", "documentationUrl" });

    }
}

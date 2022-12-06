package api.bottleofench.httplibrary;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpLibrary {
    public static String get(String urlWithParams, String token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParams);
        get.setHeader("Authorization", token);
        HttpResponse response = httpClient.execute(get);
        return new BasicResponseHandler().handleResponse(response);
    }

    public static String post(String urlWithParams, String token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost get = new HttpPost(urlWithParams);
        get.setHeader("Authorization", token);
        HttpResponse response = httpClient.execute(get);
        return new BasicResponseHandler().handleResponse(response);
    }
}

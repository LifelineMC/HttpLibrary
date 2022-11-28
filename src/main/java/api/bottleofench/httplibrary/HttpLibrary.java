package api.bottleofench.httplibrary;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class HttpLibrary {
    public static String get(String urlWithParams, String token) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParams);
        get.setHeader("Authorization", token);
        HttpResponse httpResponse = httpclient.execute(get);
        StringBuilder builder = new StringBuilder();
        new Scanner(httpResponse.getEntity().getContent()).forEachRemaining(builder::append);
        return builder.toString();
    }

    public static String post(String urlWithParams, String token) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(urlWithParams);
        post.setHeader("Authorization", token);
        HttpResponse httpResponse = httpclient.execute(post);
        StringBuilder builder = new StringBuilder();
        new Scanner(httpResponse.getEntity().getContent()).forEachRemaining(builder::append);
        return builder.toString();
    }
}

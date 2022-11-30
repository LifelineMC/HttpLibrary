package api.bottleofench.httplibrary;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class HttpLibrary {
    public static String get(String urlWithParams, String token) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParams);
        get.setHeader("Authorization", token);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpclient.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        try {
            new Scanner(httpResponse.getEntity().getContent()).forEachRemaining(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String post(String urlWithParams, String token) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(urlWithParams);
        post.setHeader("Authorization", token);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpclient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        try {
            new Scanner(httpResponse.getEntity().getContent()).forEachRemaining(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

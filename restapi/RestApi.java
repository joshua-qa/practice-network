import okhttp3.*;

import java.io.IOException;

public class RestApi {
    private static OkHttpClient client = new OkHttpClient();

    public static String request(String method, String host, String path) throws IOException {
        switch (method) {
            case "GET":
                return getRequestWithHeader(host, path);
            default:
                return "parameter check please.";
        }
    }

    public static String request(String method, String host, String path, String body) throws IOException {
        switch (method) {
            case "POST":
                return postRequest(host, path, body);
            case "PUT":
                return putRequest(host, path, body);
            case "DELETE":
                return deleteRequest(host, path, body);
            default:
                return "parameter check please.";
        }
    }

    public static String getRequest(String host, String path) throws IOException {
        String requestUrl = host + path;

        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String getRequestWithHeader(String host, String path) throws IOException {
        String requestUrl = host + path;

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("X-Auth-Token", X_AUTH_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String postRequest(String host, String path, String body) throws IOException {
        String requestUrl = host + path;

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("X-Auth-Token", X_AUTH_TOKEN)
                .post(RequestBody.create(MediaType.parse("application/json"), body))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String putRequest(String host, String path, String body) throws IOException {
        String requestUrl = host + path;

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("X-Auth-Token", X_AUTH_TOKEN)
                .put(RequestBody.create(MediaType.parse("application/json"), body))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String deleteRequest(String host, String path, String body) throws IOException {
        String requestUrl = host + path;

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("X-Auth-Token", X_AUTH_TOKEN)
                .delete(RequestBody.create(MediaType.parse("application/json"), body))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}

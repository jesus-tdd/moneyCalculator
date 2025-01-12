package software.ulpgc.moneycalc.apps.windows.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class APIConnection {
    private final HttpURLConnection connection;

    public APIConnection(HttpURLConnection connection) throws IOException {
        this.connection = connection;
        connection.setRequestMethod("GET");
    }

    public void disconnect() {
        connection.disconnect();
    }

    private boolean responseIsOk() throws IOException {
        return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
    }

    public String parseResponse() throws IOException {
        if (!responseIsOk()) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
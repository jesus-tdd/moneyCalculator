package software.ulpgc.moneycalc.apps.windows.persistence;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.API;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class APICurrencyLoader implements CurrencyLoader {
    private final API api;

    public APICurrencyLoader(API api) {
        this.api = api;
    }


    @Override
    public List<Currency> load() {
        String response;
        try {
            response =  getCurrenciesFromApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getCurrencies(response);

    }

    private List<Currency> getCurrencies(String response) {
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        JsonObject symbols = jsonResponse.getAsJsonObject("symbols");
        List<Currency> currencies = new ArrayList<>();
        for (String key : symbols.keySet()) {
            currencies.add(new Currency(symbols.get(key).getAsString(), key, ""));
        }
        return currencies;
    }

    private String getCurrenciesFromApi() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) api.connect("symbols");
        connection.setRequestMethod("GET");

        String response = "";
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            response = parseResponse(connection);
        }
        connection.disconnect();
        return response;
    }

    private String parseResponse(HttpURLConnection connection) throws IOException {
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

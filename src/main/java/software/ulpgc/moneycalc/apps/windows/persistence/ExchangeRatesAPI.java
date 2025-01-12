package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.architecture.persistence.API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRatesAPI implements API {
    private final String connectUrl;
    private final String apiKey;

    public ExchangeRatesAPI(String apiKey) {
        this.connectUrl = "https://exchange-rates.abstractapi.com/v1/";
        this.apiKey = apiKey;
    }

    @Override
    public APIConnection connect(String endpoint) throws IOException {
        URL url = new URL(connectUrl + endpoint + "/?api_key=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return new APIConnection(connection);
    }

    @Override
    public APIConnection connect(String endpoint, String parameter) throws IOException {
        URL url = new URL(connectUrl + endpoint + "/?api_key=" + apiKey + "&" + parameter);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return new APIConnection(connection);
    }
}

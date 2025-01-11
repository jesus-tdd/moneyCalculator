package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.architecture.persistence.API;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRatesAPI implements API {
    private final String connectUrl;
    private final String apiKey;

    public ExchangeRatesAPI(String apiKey) {
        this.connectUrl = "http://api.exchangeratesapi.io/v1/";
        this.apiKey = apiKey;
    }

    @Override
    public URLConnection connect(String endpoint) throws IOException {
        URL url = new URL(connectUrl + endpoint + "?access_key=" + apiKey);
        return url.openConnection();
    }

    @Override
    public URLConnection connect(String endpoint, String parameter) throws IOException {
        URL url = new URL(connectUrl + endpoint + "?access_key=" + apiKey + "&" + parameter);
        return url.openConnection();
    }
}

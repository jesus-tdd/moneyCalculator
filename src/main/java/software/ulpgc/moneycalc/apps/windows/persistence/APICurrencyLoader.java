package software.ulpgc.moneycalc.apps.windows.persistence;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.API;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyLoader;

import java.io.IOException;
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
        JsonObject symbols = jsonResponse.getAsJsonObject("exchange_rates");
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("", "EUR", ""));
        for (String key : symbols.keySet()) {
            currencies.add(new Currency("", key, ""));
        }
        return currencies;
    }

    private String getCurrenciesFromApi() throws IOException {
        APIConnection connection = api.connect("live", "base=EUR");
        String response = connection.parseResponse();
        connection.disconnect();
        return response;
    }
}

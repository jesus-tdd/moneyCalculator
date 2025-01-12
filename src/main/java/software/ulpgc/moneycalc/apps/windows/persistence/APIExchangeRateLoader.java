package software.ulpgc.moneycalc.apps.windows.persistence;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.model.ExchangeRate;
import software.ulpgc.moneycalc.architecture.persistence.API;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateLoader;

import java.io.IOException;
import java.time.LocalDate;

public class APIExchangeRateLoader implements ExchangeRateLoader {
    private final API api;

    public APIExchangeRateLoader(API api) {
        this.api = api;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to, LocalDate date) {
        String response;
        try {
            response = getExchangeRateFromApi(from, to);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double exchangeRate = getExchangeRate(response, to);
        return new ExchangeRate(from, to, exchangeRate, LocalDate.now());
    }

    private String getExchangeRateFromApi(Currency from, Currency to) throws IOException {
        APIConnection connection = api.connect("convert", "base=" + from.code() + "&target=" + to.code());
        String response = connection.parseResponse();
        connection.disconnect();
        return response;
    }

    private double getExchangeRate(String response, Currency to) {
        JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();
        return jsonResponse.get("exchange_rate").getAsDouble();
    }
}

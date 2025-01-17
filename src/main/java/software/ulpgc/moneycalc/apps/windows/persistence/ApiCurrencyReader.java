package software.ulpgc.moneycalc.apps.windows.persistence;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyReader;

import java.io.IOException;

public class ApiCurrencyReader implements CurrencyReader {
    private final ExchangeRatesApi api;

    public ApiCurrencyReader(ExchangeRatesApi api) {
        this.api = api;
    }


    @Override
    public String read() throws IOException {
        Connection.Response response = Jsoup.connect(api.GET_CURRENCIES)
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException();
        return response.body();
    }
}

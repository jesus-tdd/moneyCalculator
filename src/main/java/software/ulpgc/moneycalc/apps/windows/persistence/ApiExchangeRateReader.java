package software.ulpgc.moneycalc.apps.windows.persistence;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateReader;

import java.io.IOException;
import java.time.LocalDate;

public class ApiExchangeRateReader implements ExchangeRateReader {
    private final ExchangeRatesApi api;

    public ApiExchangeRateReader(ExchangeRatesApi api) {
        this.api = api;
    }

    @Override
    public String read(Currency from, Currency to, LocalDate date) throws IOException {
        Connection.Response response = Jsoup.connect(api.GET_EXCHANGE_RATE + "&base=" + from.code() + "&target=" + to.code())
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();
        if(response.statusCode() != 200) throw new RuntimeException();
        return response.body();
    }
}

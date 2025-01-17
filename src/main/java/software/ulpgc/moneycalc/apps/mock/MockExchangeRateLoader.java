package software.ulpgc.moneycalc.apps.mock;

import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.model.ExchangeRate;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateReader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateReader {
    @Override
    public String read(Currency from, Currency to, LocalDate date) {
        return "1.2";
    }
}

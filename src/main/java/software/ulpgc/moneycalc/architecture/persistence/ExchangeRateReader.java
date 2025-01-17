package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.architecture.model.Currency;

import java.io.IOException;
import java.time.LocalDate;

public interface ExchangeRateReader {
    String read(Currency from, Currency to, LocalDate date) throws IOException;
}

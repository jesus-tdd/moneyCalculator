package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.model.ExchangeRate;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateAdapter;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateDeserializer;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateReader;

import java.io.IOException;
import java.time.LocalDate;

public class ExchangeRateLoader {
    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public ExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public ExchangeRate load(Currency from, Currency to, LocalDate date) throws IOException {
        return adapter.adapt(deserializer.deserialize(reader.read(from, to, date)));
    }
}

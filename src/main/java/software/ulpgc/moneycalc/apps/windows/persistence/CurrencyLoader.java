package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyAdapter;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyDeserializer;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyReader;

import java.io.IOException;
import java.util.List;

public class CurrencyLoader {
    private final CurrencyReader reader;
    private final CurrencyDeserializer deserializer;
    private final CurrencyAdapter adapter;

    public CurrencyLoader(CurrencyReader reader, CurrencyDeserializer deserializer, CurrencyAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public List<Currency> load() throws IOException {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}

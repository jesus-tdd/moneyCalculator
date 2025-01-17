package software.ulpgc.moneycalc.apps.mock;

import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyReader;

import java.util.List;

public class MockCurrencyLoader implements CurrencyReader {
    @Override
    public String read() {
        return "EUR, USD";
    }
}

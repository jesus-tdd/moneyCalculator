package software.ulpgc.moneycalc.apps.mock;

import software.ulpgc.moneycalc.architecture.persistence.CurrencyReader;

public class MockCurrencyLoader implements CurrencyReader {
    @Override
    public String read() {
        return "EUR, USD";
    }
}

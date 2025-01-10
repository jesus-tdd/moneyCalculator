package software.ulpgc.moneycalc.apps.mock;

import software.ulpgc.moneycalc.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalc.architecture.model.Currency;

import java.util.List;

public class MockCurrencyDialog implements CurrencyDialog {
    private final List<Currency> currencies;

    public MockCurrencyDialog(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @Override
    public software.ulpgc.moneycalc.architecture.model.Currency get() {
        return currencies.get(0);
    }
}

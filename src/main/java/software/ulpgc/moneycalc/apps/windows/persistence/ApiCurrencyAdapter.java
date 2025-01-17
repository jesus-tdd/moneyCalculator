package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.apps.windows.persistence.pojo.GetCurrencyResponse;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ApiCurrencyAdapter implements CurrencyAdapter {
    @Override
    public List<Currency> adapt(Object object) {
        GetCurrencyResponse response = (GetCurrencyResponse) object;
        return adapt(response.base(), response.exchange_rates().keySet());
    }

    public List<Currency> adapt(String base,Set<String> keys) {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("", base, ""));
        for (String key : keys) {
            currencies.add(new Currency("", key, ""));
        }
        return currencies;
    }
}

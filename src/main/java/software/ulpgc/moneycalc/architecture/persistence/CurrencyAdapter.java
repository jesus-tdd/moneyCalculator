package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.architecture.model.Currency;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object object);
}

package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}

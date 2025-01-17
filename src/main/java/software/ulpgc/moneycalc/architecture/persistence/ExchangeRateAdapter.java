package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.architecture.model.ExchangeRate;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object);
}

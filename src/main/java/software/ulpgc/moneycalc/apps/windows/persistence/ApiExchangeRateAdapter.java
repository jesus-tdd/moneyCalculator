package software.ulpgc.moneycalc.apps.windows.persistence;

import software.ulpgc.moneycalc.apps.windows.persistence.pojo.GetExchangeRateResponse;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.model.ExchangeRate;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateAdapter;

import java.time.LocalDate;

public class ApiExchangeRateAdapter implements ExchangeRateAdapter {

    @Override
    public ExchangeRate adapt(Object object) {
        return adapt(((GetExchangeRateResponse) object));
    }

    private ExchangeRate adapt(GetExchangeRateResponse response) {
        return new ExchangeRate(
                new Currency( "", response.base(), ""),
                new Currency("", response.target(), ""),
                response.exchange_rate(),
                LocalDate.now()
        );
    }
}

package software.ulpgc.moneycalc.apps.windows.persistence;

public class ExchangeRatesApi {
    public final String GET_CURRENCIES;
    public final String GET_EXCHANGE_RATE;
    private final String key;

    public ExchangeRatesApi(String key) {
        this.key = key;
        this.GET_CURRENCIES = generateGetCurrenciesUrl();
        this.GET_EXCHANGE_RATE = generateGetExchangeRateUrl();
    }

    private String generateGetExchangeRateUrl() {
        return "https://exchange-rates.abstractapi.com/v1/convert/?api_key=" + key; // base and are target appended in reader
    }

    private String generateGetCurrenciesUrl() {
        return "https://exchange-rates.abstractapi.com/v1/live/?api_key=" + key + "&base=EUR";
    }
}

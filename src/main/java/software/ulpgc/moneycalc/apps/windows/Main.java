package software.ulpgc.moneycalc.apps.windows;

import software.ulpgc.moneycalc.apps.windows.persistence.*;
import software.ulpgc.moneycalc.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalc.architecture.model.Currency;

import java.io.IOException;
import java.util.List;

public class Main {
    static final String apiKey = "82e8d9666c924effa1a5f753ccee0d7a";

    public static void main(String[] args) throws IOException {
        ExchangeRatesApi api = new ExchangeRatesApi(apiKey);
        List<Currency> currencies = createApiCurrencyLoader(api).load();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                createApiExchangeRateLoader(api),
                mainFrame.getMoneyDisplay()
        );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);
    }

    private static ExchangeRateLoader createApiExchangeRateLoader(ExchangeRatesApi api) {
        return new ExchangeRateLoader(
                new ApiExchangeRateReader(api),
                new ApiExchangeRateDeserializer(),
                new ApiExchangeRateAdapter()
        );
    }

    private static CurrencyLoader createApiCurrencyLoader(ExchangeRatesApi api) {
        return new CurrencyLoader(
                new ApiCurrencyReader(api),
                new ApiCurrencyDeserializer(),
                new ApiCurrencyAdapter()
        );
    }
}

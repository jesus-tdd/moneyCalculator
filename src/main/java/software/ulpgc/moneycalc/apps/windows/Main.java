package software.ulpgc.moneycalc.apps.windows;

import software.ulpgc.moneycalc.apps.windows.persistence.APICurrencyLoader;
import software.ulpgc.moneycalc.apps.windows.persistence.APIExchangeRateLoader;
import software.ulpgc.moneycalc.apps.windows.persistence.ExchangeRatesAPI;
import software.ulpgc.moneycalc.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalc.architecture.model.Currency;

import java.util.List;

public class Main {
    static final String apiKey = "82e8d9666c924effa1a5f753ccee0d7a";

    public static void main(String[] args) {
        ExchangeRatesAPI api = new ExchangeRatesAPI(apiKey);
        List<Currency> currencies = new APICurrencyLoader(api).load();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                new APIExchangeRateLoader(api),
                mainFrame.getMoneyDisplay()
        );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);
    }
}

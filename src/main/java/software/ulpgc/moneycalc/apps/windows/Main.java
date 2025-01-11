package software.ulpgc.moneycalc.apps.windows;

import software.ulpgc.moneycalc.apps.mock.MockExchangeRateLoader;
import software.ulpgc.moneycalc.apps.windows.persistence.APICurrencyLoader;
import software.ulpgc.moneycalc.apps.windows.persistence.ExchangeRatesAPI;
import software.ulpgc.moneycalc.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalc.architecture.model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExchangeRatesAPI api = new ExchangeRatesAPI("d32be90457df4aa5ae81d9546dfb8a20");
        List<Currency> currencies = new APICurrencyLoader(api).load();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                new MockExchangeRateLoader(),
                mainFrame.getMoneyDisplay()
        );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);
    }
}

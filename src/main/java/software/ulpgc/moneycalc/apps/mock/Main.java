package software.ulpgc.moneycalc.apps.mock;

import software.ulpgc.moneycalc.architecture.control.Command;
import software.ulpgc.moneycalc.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateReader;
import software.ulpgc.moneycalc.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalc.architecture.view.MoneyDialog;
import software.ulpgc.moneycalc.architecture.view.MoneyDisplay;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*List<Currency> currencies = new MockCurrencyLoader().read();
        MoneyDialog moneyDialog = new MockMoneyDialog(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog(currencies);
        ExchangeRateReader loader = new MockExchangeRateLoader();
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        Command command = new ExchangeCommand(
                moneyDialog,
                currencyDialog,
                loader,
                moneyDisplay
                );
        command.execute();*/
    }
}
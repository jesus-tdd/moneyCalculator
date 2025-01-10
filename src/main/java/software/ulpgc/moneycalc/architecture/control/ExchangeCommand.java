package software.ulpgc.moneycalc.architecture.control;

import software.ulpgc.moneycalc.ExchangeRateLoader;
import software.ulpgc.moneycalc.architecture.model.Currency;
import software.ulpgc.moneycalc.architecture.model.ExchangeRate;
import software.ulpgc.moneycalc.architecture.model.Money;
import software.ulpgc.moneycalc.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalc.architecture.view.MoneyDialog;
import software.ulpgc.moneycalc.architecture.view.MoneyDisplay;

import java.time.LocalDate;

public class ExchangeCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency= currencyDialog.get();

        ExchangeRate exchangeRate = loader.load(money.currency(), currency, LocalDate.now());
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);

        moneyDisplay.show(result);
    }
}

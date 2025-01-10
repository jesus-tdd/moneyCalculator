package software.ulpgc.moneycalc;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date) {
}

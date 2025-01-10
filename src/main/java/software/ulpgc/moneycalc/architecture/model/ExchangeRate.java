package software.ulpgc.moneycalc.architecture.model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date) {
}

package software.ulpgc.moneycalc.apps.windows.persistence.pojo;

public record GetExchangeRateResponse(String base, String target, int base_amount, double converted_amount, double exchange_rate, int last_updated) {
}

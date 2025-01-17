package software.ulpgc.moneycalc.apps.windows.persistence.pojo;

import java.util.Map;

public record GetCurrencyResponse (String base, int last_updated, Map<String, Double> exchange_rates){
}

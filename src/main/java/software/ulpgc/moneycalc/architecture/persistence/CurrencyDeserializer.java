package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.apps.windows.persistence.pojo.GetCurrencyResponse;

public interface CurrencyDeserializer {
    Object deserialize(String content);
}

package software.ulpgc.moneycalc.apps.windows.persistence;

import com.google.gson.Gson;
import software.ulpgc.moneycalc.apps.windows.persistence.pojo.GetCurrencyResponse;
import software.ulpgc.moneycalc.architecture.persistence.CurrencyDeserializer;

public class ApiCurrencyDeserializer implements CurrencyDeserializer {
    @Override
    public Object deserialize(String content) {
        return new Gson().fromJson(content, GetCurrencyResponse.class);
    }
}

package software.ulpgc.moneycalc.apps.windows.persistence;

import com.google.gson.Gson;
import software.ulpgc.moneycalc.apps.windows.persistence.pojo.GetExchangeRateResponse;
import software.ulpgc.moneycalc.architecture.persistence.ExchangeRateDeserializer;

public class ApiExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String content) {
        return new Gson().fromJson(content, GetExchangeRateResponse.class);
    }
}

package software.ulpgc.moneycalc.architecture.persistence;

public interface ExchangeRateDeserializer {
    Object deserialize(String content);
}

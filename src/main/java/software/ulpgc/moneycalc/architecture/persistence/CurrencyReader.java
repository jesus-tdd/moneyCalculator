package software.ulpgc.moneycalc.architecture.persistence;

import java.io.IOException;

public interface CurrencyReader {
    String read() throws IOException;
}

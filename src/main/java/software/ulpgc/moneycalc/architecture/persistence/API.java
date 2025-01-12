package software.ulpgc.moneycalc.architecture.persistence;

import software.ulpgc.moneycalc.apps.windows.persistence.APIConnection;

import java.io.IOException;

public interface API {
    APIConnection connect(String endpoint, String parameter) throws IOException;
}

package software.ulpgc.moneycalc.architecture.persistence;

import java.io.IOException;
import java.net.URLConnection;

public interface API {
    URLConnection connect(String endpoint) throws IOException;
    URLConnection connect(String endpoint, String parameter) throws IOException;
}

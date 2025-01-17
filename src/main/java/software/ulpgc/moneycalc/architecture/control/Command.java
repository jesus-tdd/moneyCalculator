package software.ulpgc.moneycalc.architecture.control;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}

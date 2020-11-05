package core.loggers;

import core.beans.Event;

import java.io.IOException;

public interface IEventLogger {
    void logEvent (Event event) throws IOException;
}

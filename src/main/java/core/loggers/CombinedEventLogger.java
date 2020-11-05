package core.loggers;

import core.beans.Event;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class CombinedEventLogger implements IEventLogger {
    private final Collection<IEventLogger> loggers;

    public CombinedEventLogger(Collection<IEventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for (IEventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

    public Collection<IEventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}

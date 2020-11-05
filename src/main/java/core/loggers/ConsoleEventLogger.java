package core.loggers;

import core.beans.Event;

public class ConsoleEventLogger  implements IEventLogger{
    public void logEvent (Event event) {
        System.out.println(event.toString());
    }
}

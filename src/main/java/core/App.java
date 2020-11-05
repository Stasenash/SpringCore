package core;

import core.beans.Client;
import core.beans.Event;
import core.beans.EventType;
import core.loggers.IEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {

    private Client client;
    private IEventLogger defaultLogger;
    private Map<EventType, IEventLogger> loggers;

    App(Client client, IEventLogger eventLogger, Map<EventType, IEventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    App(){}

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        app.logEvents(ctx);
        ctx.close();
    }

    private void logEvents (ApplicationContext ctx) throws IOException {
        Event event = ctx.getBean(Event.class);
        logEvent(EventType.INFO, event, "Some event for user 1");

        event = ctx.getBean(Event.class);
        logEvent(EventType.INFO, event, "One more event for user 1");

        event = ctx.getBean(Event.class);
        logEvent(EventType.ERROR, event, "ERROR event for user 1");

        event = ctx.getBean(Event.class);
        logEvent(EventType.FATAL, event, "FATAL event for user 1");

        event = ctx.getBean(Event.class);
        logEvent(EventType.WARNING, event, "WARNING event for user 1");
    }

    private void logEvent (EventType eventType, Event event, String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getFullName() + " from " + client.getCity());
        event.setMsg(message);

        IEventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }
}

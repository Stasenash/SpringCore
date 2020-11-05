package core.loggers;

import core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileEventLogger implements IEventLogger {
    private String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void init() throws IOException {
        file = new File(filename);
        if (!file.exists())
            file.createNewFile();

        if (file.exists() && !file.canWrite())
            throw new IllegalArgumentException("Can't write to file " + filename);
    }

    public void logEvent(Event event) {
            try {
                FileUtils.writeStringToFile(file, event.toString() + "\n", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

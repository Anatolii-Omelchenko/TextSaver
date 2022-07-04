package prog.academu.textsaver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Saver {

    @Save
    public static void save(String text, String path) throws IOException {
        Files.writeString(Path.of(path), text + System.lineSeparator(), StandardOpenOption.APPEND);
        System.out.println("The text <" + text + "> was successfully written to the " + path + " file.");
    }
}

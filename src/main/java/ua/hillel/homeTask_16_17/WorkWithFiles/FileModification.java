package ua.hillel.homeTask_16_17.WorkWithFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileModification {
    public void changeFile() throws IOException {
        String text = "This file was changed";
        File[] filesInFolder = new File("target/downloads").listFiles();
        FileWriter writer = new FileWriter(filesInFolder[0]);
        writer.write(text);
        writer.close();
    }
}

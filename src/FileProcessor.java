import java.io.*;
import java.util.Arrays;
import java.util.List;

abstract class FileProcessor {
    private final List<String> inputFiles;
    private final String outputFile;

    public FileProcessor(String line) {
        String[] files = line.split(" ");
        if (files.length < 2)
            throw new IllegalArgumentException("Необходимо ввести как минимум один входной файл и один выходной файл!");

        this.inputFiles = Arrays.asList(Arrays.copyOfRange(files, 0, files.length - 1));
        this.outputFile = files[files.length - 1];
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public abstract void processFiles() throws IOException;

}

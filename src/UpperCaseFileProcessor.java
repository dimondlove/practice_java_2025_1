import java.io.*;

public class UpperCaseFileProcessor extends FileProcessor {
    public UpperCaseFileProcessor(String line) {
        super(line);
    }

    @Override
    public void processFiles() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getOutputFile()))) {
            for (String inputFile : getInputFiles()) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        bufferedWriter.write(line.toUpperCase());
                        bufferedWriter.newLine();
                    }
                }
            }
        }
    }
}

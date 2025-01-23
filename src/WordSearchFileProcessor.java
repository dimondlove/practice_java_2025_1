import java.io.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchFileProcessor extends FileProcessor {
    private final Set<String> searchWords;

    public WordSearchFileProcessor(String line) throws IOException {
        super(line);
        searchWords = loadSearchWords(line.split(" ")[0]);
    }

    private Set<String> loadSearchWords(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            Set<String> words = new HashSet<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitWords = line.split("\\W+");
                words.addAll(Arrays.asList(splitWords));
            }
            return words;
        }
    }

    @Override
    public void processFiles() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getOutputFile()))) {
            List<String> inputFiles = getInputFiles();

            for (int i = 1; i < inputFiles.size() - 1; i++) {
                if (doesFileContainWords(inputFiles.get(i))) {
                    bufferedWriter.write(inputFiles.get(i));
                    bufferedWriter.newLine();
                }
            }
        }
    }

    private boolean doesFileContainWords(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (searchWords.contains(word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

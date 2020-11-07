package pl.naru.workers;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileWorker {


    public List<String> retrieveFileData(String filePath) throws FileNotFoundException {
        File inputFile = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        return transformFileDataToList(bufferedReader);
    }

    private List<String> transformFileDataToList(BufferedReader bufferedReader) {
        List<String> lines = bufferedReader.lines().map(String::toLowerCase).collect(Collectors.toList());
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


}

package template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileImporter<T> {
    private ParserStrategy<T> strategy;

    public FileImporter(ParserStrategy<T> strategy){
        this.strategy = strategy;
    }


    public List<T> loadCSV(String filename) {
        List<T> data = new ArrayList<>();
        String line;


        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            line = br.readLine(); //첫 줄 건너뛰기
            while ((line = br.readLine()) != null) {
                data.add(strategy.parse(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}

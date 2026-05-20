

package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<String[]> readCsv(String filePath) {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                data.add(line.split(","));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
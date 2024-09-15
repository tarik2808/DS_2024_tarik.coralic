package midterm.homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws FileNotFoundException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                if(fields.length == 6) {
                    Entry entry = new Entry(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                    entries.add(entry);
                }
            }

        } catch (IOException e) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name;Street Address;ZIP code;Country;Phone number\n");
            for(Entry entry: entries) {
                writer.write(entry.toString() + "\n");
            }
        }
    }
}
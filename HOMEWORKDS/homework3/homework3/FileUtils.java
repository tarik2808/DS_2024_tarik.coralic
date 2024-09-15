package midterm.homework3;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static RedBlackTree<Entry> readFile(String filePath) throws FileNotFoundException {
        RedBlackTree<Entry> rbt = new RedBlackTree<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    Entry entry = new Entry(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    rbt.put(parts[0] + ", " + parts[1], entry);
                }
            }
        }
        return rbt;
    }
}

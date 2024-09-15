package midterm.homework3;

import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the CSV file:");
        String filePath = scanner.nextLine();

        try {
            RedBlackTree<Entry> phonebook = FileUtils.readFile(filePath);
            int[] edgeCounts = phonebook.countRedAndBlackEdges();
            System.out.println("Total black edges: " + edgeCounts[0]);
            System.out.println("Total red edges: " + edgeCounts[1]);

            while (true) {
                System.out.println("Enter the name to search for (format: Surname, Name) or -1 to exit:");
                String input = scanner.nextLine();
                if (input.equals("-1")) break;

                ArrayList<Entry> results = phonebook.get(input);
                if (results != null) {
                    System.out.println("Found " + results.size() + " entries:");
                    for (Entry entry : results) {
                        System.out.println(entry);
                    }
                } else {
                    System.out.println("No entries found for " + input);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}

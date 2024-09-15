package midterm.homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Entry[] entries = FileUtils.readFile("path_to_unsorted_csv.csv");

            // Sort the entries
            MergeSort.sort(entries);

            // Save the sorted entries to a new file
            FileUtils.writeToFile(entries, "path_to_sorted_csv.csv");

            while (true) {
                System.out.println("Enter the name to search (Surname, Name) or -1 to exit:");
                String query = scanner.nextLine();

                if (query.equals("-1")) {
                    break;
                }

                int[] result = BinarySearch.search(entries, query);

                if (result.length == 0 || result[0] == -1) {
                    System.out.println("No entries found for the name: " + query);
                } else {
                    System.out.println("Found " + (result[1] - result[0] + 1) + " entries:");
                    for (int i = result[0]; i <= result[1]; i++) {
                        System.out.println(entries[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

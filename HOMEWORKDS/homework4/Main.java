package graphgossip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialNetwork socialNetwork = null;

        System.out.println("Enter the path to the CSV file:");
        String filePath = scanner.nextLine();
        try {
            socialNetwork = new SocialNetwork(new Scanner(new File(filePath)));
            System.out.println("Total users: " + socialNetwork.getTotalUsers());
            System.out.println("Total friendships: " + socialNetwork.getTotalFriendships());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        // Repeatedly ask for a user to recommend friends to
        while (true) {
            System.out.println("Enter the name to recommend friends to (format: Name Surname) or -1 to exit:");
            String input = scanner.nextLine();
            if (input.equals("-1")) break;

            List<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(input);
            if (recommendations.isEmpty()) {
                System.out.println("No recommendations found for " + input + " or user does not exist.");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                recommendations.stream().limit(10).forEach(System.out::println);
            }
        }
    }
}

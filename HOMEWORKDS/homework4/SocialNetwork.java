package homework4;

import java.util.*;

public class SocialNetwork {
    private Map<String, List<Friendship>> adjacencyList;

    public SocialNetwork() {
        this.adjacencyList = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            String[] parts = in.nextLine().split(";");
            if (parts.length == 3) {
                String friend1 = parts[0];
                String friend2 = parts[1];
                int strength = Integer.parseInt(parts[2]);
                addFriendship(new Friendship(friend1, friend2, strength));
            }
        }
    }

    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(Friendship f) {
        addUser(f.getFriend1());
        addUser(f.getFriend2());
        adjacencyList.get(f.getFriend1()).add(f);
        adjacencyList.get(f.getFriend2()).add(new Friendship(f.getFriend2(), f.getFriend1(), f.getFriendshipStrength()));
    }

    public List<FriendshipRecommendation> recommendFriends(String user) {
        Map<String, Integer> recommendationStrengths = new HashMap<>();

        if (!adjacencyList.containsKey(user)) {
            return new ArrayList<>();
        }

        for (Friendship friendship : adjacencyList.get(user)) {
            String friend = friendship.getFriend2();
            for (Friendship friendsFriendship : adjacencyList.get(friend)) {
                String potentialFriend = friendsFriendship.getFriend2();
                if (!potentialFriend.equals(user) && !adjacencyList.get(user).stream().anyMatch(f -> f.getFriend2().equals(potentialFriend))) {
                    int strength = Math.min(friendship.getFriendshipStrength(), friendsFriendship.getFriendshipStrength());
                    recommendationStrengths.put(potentialFriend, recommendationStrengths.getOrDefault(potentialFriend, 0) + strength);
                }
            }
        }

        List<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendationStrengths.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }
        Collections.sort(recommendations);
        return recommendations;
    }

    public int getTotalUsers() {
        return adjacencyList.size();
    }

    public int getTotalFriendships() {
        int total = 0;
        for (List<Friendship> friendships : adjacencyList.values()) {
            total += friendships.size();
        }
        return total / 2; // Since each friendship is counted twice
    }
}

package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private int recommendationStrength;

    // Constructor
    public FriendshipRecommendation(String user, int recommendationStrength) {
        this.user = user;
        this.recommendationStrength = recommendationStrength;
    }

    // Getters
    public String getUser() {
        return user;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }

    // Comparable method to sort by recommendation strength
    @Override
    public int compareTo(FriendshipRecommendation other) {
        return Integer.compare(other.recommendationStrength, this.recommendationStrength);
    }

    @Override
    public String toString() {
        return user + ": " + recommendationStrength;
    }
}

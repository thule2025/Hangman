public class Player {
    private String name;
    private int score;

    // Constructor
    public Player(String n) {
        name = n;
        score = 0;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Mutators
    public void setName(String newName) {
        name = newName;
    }

    public void setScore(int newScore) {
        score = newScore;
    }

    // Add points
    public void addToScore(int points) {
        score += points;
    }
}

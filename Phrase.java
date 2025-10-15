public class Phrase {
    private String actualPhrase;
    private String solvedPhrase;

    public Phrase(String phrase) {
        actualPhrase = phrase.toUpperCase();
        solvedPhrase = phrase.replaceAll("[A-Z]", "_");
    }

    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    public boolean isSolved() {
        return solvedPhrase.equals(actualPhrase);
    }

    public boolean checkLetter(char letter) {
        boolean found = false;
        char[] solvedArray = solvedPhrase.toCharArray();

        for (int i = 0; i < actualPhrase.length(); i++) {
            if (actualPhrase.charAt(i) == letter) {
                solvedArray[i] = letter;
                found = true;
            }
        }

        solvedPhrase = new String(solvedArray);
        return found;
    }

    // Mutator to reset or change the phrase
    public void setPhrase(String newPhrase) {
        actualPhrase = newPhrase.toUpperCase();
        solvedPhrase = newPhrase.replaceAll("[A-Z]", "_");
    }
}

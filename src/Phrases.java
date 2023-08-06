import java.util.Random;

public class Phrases {
    private static String gamePhrase;
    private static String playingPhrase;
    private final static String[] prizePool = {
            "$100", "$200", "$300", "Box Gift", "trip to the moon"
    };
    public static void setGamePhrase(String phrase) {
        gamePhrase = phrase;
        playingPhrase = phrase.replaceAll("[a-zA-Z]", "_");
    }
    public static String getPlayingPhrase() {
        return playingPhrase;
    }

    public static boolean findLetters(String letter) throws MultipleLettersException {
        if (letter.length() > 1) {
            throw new MultipleLettersException();
        }
        if (!gamePhrase.contains(letter)) {
            return false; //adam:  added this line to return false if the letter is not in the phrase
        }
        StringBuilder updatedPhrase = new StringBuilder(playingPhrase);

        for (int i = 0; i < gamePhrase.length(); i++) {
            if (Character.toLowerCase(gamePhrase.charAt(i)) == Character.toLowerCase(letter.charAt(0))) {
                updatedPhrase.setCharAt(i, gamePhrase.charAt(i));
            }
        }

        playingPhrase = updatedPhrase.toString();

        //adam: Check if the player has won
        if (!playingPhrase.contains("_")) {
            System.out.println("Congratulations! You've guessed the phrase!");
            awardPrize();
        }
        return true;
    }

    //adam:  Method to award a prize --> extra
    private static void awardPrize() {
        Random random = new Random();
        int prizeIndex = random.nextInt(prizePool.length);
        System.out.println("You have won: " + prizePool[prizeIndex]);
    }
}

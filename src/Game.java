import java.util.Random;

public class Game {

    private String guessNumber;

    public Game()
    {

        Random rand = new Random();

        int max = 9;
        int min = 0;

        int randDigit;
        char randDigitStr = 'a';
        boolean digitOk;
        StringBuilder sb = new StringBuilder("aaaa");

        for (int i = 0; i < 4; ++i) {
            digitOk = false;

            while (!digitOk) {
                randDigit = rand.nextInt((max - min) + 1) + min;
                randDigitStr = Integer.toString(randDigit).charAt(0);

                digitOk = true;
                for (int j = 0; j < i; ++j) {
                    if (sb.charAt(j) == randDigitStr)
                        digitOk = false;
                }
            }

            sb.setCharAt(i, randDigitStr);
        }

        guessNumber = sb.toString();

    }

    public int[] guess(String guess1) {
        int exact = 0;
        int close = 0;

        for (int i = 0 ; i < 4; ++i) {
            if (guess1.charAt(i) == this.guessNumber.charAt(i)) {
                ++exact;
                continue;
            }

            for (int j = 0; j < 4; ++j) {
                if (guess1.charAt(i) == this.guessNumber.charAt(j)) {
                    ++close;
                    break;
                }
            }
        }

        return new int[] {exact, close};
    }
}

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        Stack<int[]> st;
        int numOfGuesses;
        boolean on = true;
        boolean stillPlaying = true;
        boolean guessOk;
        Game g;

        Scanner s = new Scanner(System.in);

        while (stillPlaying) {

            System.out.println("start guessing");
            numOfGuesses = 0;
            st = new Stack<int[]>();
            g = new Game();

            while (on) {
                String guess = s.nextLine();

                if (guess.length() != 4) {
                    System.out.println("guess should be 4 digits");
                    continue;
                }

                guessOk = true;
                for (int i = 0; i < 4; ++i) {
                    for (int j = 0; j < i && guessOk; ++j) {
                        if (guess.charAt(i) == guess.charAt(j)) {
                            System.out.println("guess should have 4 unique digits");
                            guessOk = false;
                        }
                    }
                }
                if (!guessOk)
                    continue;


                ++numOfGuesses;
                int[] result = g.guess(guess);


                System.out.format("exacts %d, hits %d", result[0], result[1]);
                System.out.println();

                if (st.size() > 0) {
                    System.out.println("old guesses");
                    for (int i = 0; i < st.size(); ++i) {

                        int[] old = st.get(i);

                        System.out.format("%d - exacts %d, hits %d", old[0], old[1], old[2]);
                        System.out.println();
                    }
                }


                st.push(new int[]{Integer.parseInt(guess), result[0], result[1]});

                if (result[0] == 4) {
                    System.out.println("win");
                    System.out.format("num of guesses %d", numOfGuesses);
                    System.out.println();
                    break;
                }
            }

            System.out.println("if you want another game press 'y' and enter");
            String answer = s.nextLine();
            if (answer.length() == 1 && answer.charAt(0) == 'y')
                continue;
            else
                break;
        }
    }
}

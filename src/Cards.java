import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Cards {

	private static int bestPlay(int[] cards_player, int[] cards_dealer, ArrayList<Integer> solution) {
		/**
		 *
		 * Your code should return the answer, i.e., the points at which the player should stop, in the "solution" arraylist.
		 * The return value should be the total winnings for the best solution.
		 */
        int Score;
        int dealerPos = 0;
        int playerPos = 0;
        int bestValue = 0;

        for (int i=0; i<cards_player.length;i++){
            Score = cards_player[i];

            while (Score < cards_dealer[dealerPos]){

                if (playerPos < cards_player.length) {
                    System.out.println(Score);
                    Score += cards_player[playerPos];
                    System.out.println(Score);
                    playerPos++;
                }
            }
            if (Score > cards_dealer[dealerPos]){

                bestValue += 10;
            }else if (Score == cards_dealer[dealerPos]){

                bestValue += 5;
            }

        }

		return bestValue;
	}

	public static void main(String[] args) {
        Scanner sc;
		try {
            sc = new Scanner(new File("01.in"));
        } catch (java.io.FileNotFoundException e){
            sc = new Scanner(System.in);
        }



		int numOfTestCases = sc.nextInt();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 
			int numOfCards = sc.nextInt();
			int[] cards_player = new int[numOfCards];
			for (int i=0; i < numOfCards; i++) 
				cards_player[i] = sc.nextInt();
			int[] cards_dealer = new int[numOfCards];
			for (int i=0; i < numOfCards; i++) 
				cards_dealer[i] = sc.nextInt();

			ArrayList<Integer> results = new ArrayList<>();
			int value = bestPlay(cards_player, cards_dealer, results);        
			System.out.println("Best value " + value  + " is obtained by stopping at positions: " + results);
		}

		sc.close();
	}
}


import java.awt.*;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"1", "2", "2"};
		String [] suits = {"Pennebackers", "Danny", "Dan"};
		int [] pointValues = {2,1,6};
		Deck a = new Deck(ranks, suits, pointValues);

		for (int i = 0; i < a.size(); i ++){
			System.out.println(a.deal());
		}

		String [] Ranks = {"2", "3", "4", "5", "6", "7", "8", "9" ,"10", "Jack", "Queen", "King", "Ace"};
		String [] Suits = {"spades", "hearts", "diamonds", "clubs"};
		int [] PointValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		Deck b = new Deck(Ranks, Suits, PointValues);

		for (int i = 0; i < 5; i ++){
			System.out.println(b.deal());
		}
	}
}

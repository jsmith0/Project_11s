/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card q = new Card("King", "Clubs", 8);
		Card w = new Card("Ace", "Spades", 4);
		Card e = new Card("King", "Clubs", 8);

		System.out.println(q.matches(w));
		System.out.println(q.matches(e));
		System.out.println(q.toString());

	}
}

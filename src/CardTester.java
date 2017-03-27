/**
 * This is a class that tests the Card2A class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card2A operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card2A q = new Card2A("King", "Clubs", 8);
		Card2A w = new Card2A("Ace", "Spades", 4);
		Card2A e = new Card2A("King", "Clubs", 8);

		System.out.println(q.matches(w));
		System.out.println(q.matches(e));
		System.out.println(q.toString());

	}
}

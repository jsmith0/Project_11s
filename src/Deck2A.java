import java.util.List;
import java.util.ArrayList;

/**
 * The Deck2A class represents a shuffled deck of card2As.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck2A {

	/**
	 * card2As contains all the card2As in the deck.
	 */
	private List<Card2A> card2As;

	/**
	 * size is the number of not-yet-dealt card2As.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck2A</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck2A(String[] ranks, String[] suits, int[] values) {
		card2As = new ArrayList<Card2A>();
		for (int j = 0; j < ranks.length; j++) {
			for (String suitString : suits) {
				card2As.add(new Card2A(ranks[j], suitString, values[j]));
			}
		}
		size = card2As.size();
		shuffle();
	}


	/**
	 * Determines if this deck is empty (no undealt card2As).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Accesses the number of undealt card2As in this deck.
	 * @return the number of undealt card2As in this deck.
	 */
	public int size() {
		return size;
	}

	/**
	 * Randomly permute the given collection of card2As
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the card2As have been
	 *         previously dealt.
	 */
	public Card2A deal() {
		if (isEmpty()) {
			return null;
		}
		size--;
		Card2A c = card2As.get(size);
		return c;
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt card2As: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + card2As.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt card2As: \n";
		for (int k = card2As.size() - 1; k >= size; k--) {
			rtn = rtn + card2As.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - card2As.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}

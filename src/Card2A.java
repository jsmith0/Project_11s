/**
 * Card2A.java
 *
 * <code>Card2A</code> represents a playing card.
 */
public class Card2A {

	/**
	 * String value that holds the suit of the card
	 */
	public String suit;

	/**
	 * String value that holds the rank of the card
	 */
	public String rank;

	/**
	 * int value that holds the point value.
	 */
	public int pointValue;


   /**
	 * Creates a new <code>Card2A</code> instance.
	 *
	 * @param cardRank  a <code>String</code> value
	 *                  containing the rank of the card
	 * @param cardSuit  a <code>String</code> value
	 *                  containing the suit of the card
	 * @param cardPointValue an <code>int</code> value
	 *                  containing the point value of the card
	 */
	public Card2A(String cardRank, String cardSuit, int cardPointValue) {
		//initializes a new Card2A with the given rank, suit, and point value
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}


	/**
	 * Accesses this <code>Card2A's</code> suit.
	 * @return this <code>Card2A's</code> suit.
	 */
	public String suit() {
		return suit;
	}

	/**
	 * Accesses this <code>Card2A's</code> rank.
	 * @return this <code>Card2A's</code> rank.
	 */
	public String rank() {
		return rank;
	}

   /**
	 * Accesses this <code>Card2A's</code> point value.
	 * @return this <code>Card2A's</code> point value.
	 */
	public int pointValue() {
		return pointValue;
	}

	/** Compare this card with the argument.
	 * @param otherCard2A the other card to compare to this
	 * @return true if the rank, suit, and point value of this card
	 *              are equal to those of the argument;
	 *         false otherwise.
	 */
	public boolean matches(Card2A otherCard2A) {
		return otherCard2A.suit().equals(this.suit())
			&& otherCard2A.rank().equals(this.rank())
			&& otherCard2A.pointValue() == this.pointValue();
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a <code>Deck2A</code> in an easily readable format or performing
	 * other similar functions.
	 *
	 * @return a <code>String</code> containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}

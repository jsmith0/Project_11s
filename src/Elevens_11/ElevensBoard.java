package Elevens_11;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
			{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
			{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 *
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 * false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE MODIFIED IN ACTIVITY 11 *** */
		if (selectedCards.size() == 2) {
			return findPairSum11(selectedCards);
		} else if (selectedCards.size() == 3) {
			return findJQK(selectedCards);
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 *
	 * @return true if there is a legal play left on the board;
	 * false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> cIndexes = cardIndexes();
		return findPairSum11(cIndexes) || findJQK(cIndexes);
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 *
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return a list of the indexes of an 11-pair, if an 11-pair was found;
	 * an empty list, if an 11-pair was not found.
	 */
	private boolean findPairSum11(List<Integer> selectedCards) {
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Look for a JQK in the selected cards.
	 *
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return a list of the indexes of a JQK, if a JQK was found;
	 * an empty list, if a JQK was not found.
	 */
	private boolean findJQK(List<Integer> selectedCards) {
		int a = 0;
		int b = 0;
		int c = 0;
		for (Integer kObj : selectedCards) {
			int k = kObj.intValue();
			if (cardAt(k).rank().equals("jack")) {
				a++;
			} else if (cardAt(k).rank().equals("queen")) {
				b++;
			} else if (cardAt(k).rank().equals("king")) {
				c++;
			}
		}
		if (a >= 1 && b >= 1 && c >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Looks for a legal play on the board.  If one is found, it plays it.
	 *
	 * @return true if a legal play was found (and made); false othewise.
	 */
	public boolean playIfPossible() {
		return playPairSum11IfPossible() || playJQKIfPossible();
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11.
	 * If found, replace them with the next two cards in the deck.
	 * The simulation of this game uses this method.
	 *
	 * @return true if an 11-pair play was found (and made); false othewise.
	 */
	private boolean playPairSum11IfPossible() {
		if (findPairSum11(cardIndexes())) {
			for (int c1 = 0; c1 < cardIndexes().size(); c1++) {
				int k1 = cardIndexes().get(c1).intValue();
				for (int c2 = c1 + 1; c2 < cardIndexes().size(); c2++) {
					int k2 = cardIndexes().get(c2).intValue();
					if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 11) {
						return true;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Looks for a group of three face cards JQK.
	 * If found, replace them with the next three cards in the deck.
	 * The simulation of this game uses this method.
	 *
	 * @return true if a JQK play was found (and made); false othewise.
	 */
	private boolean playJQKIfPossible() {
		if (findJQK(cardIndexes())) {
			int q = 0;
			int w = 0;
			int r = 0;
			for (Integer w : cardIndexes()) {
				int e = w.intValue();
				if (cardAt(e).rank().equals("jack")) {
					int q = e;
				} else if (cardAt(e).rank().equals("queen")) {
					int w = e;
				} else if (cardAt(e).rank().equals("king")) {
					int r = e;
				}
				List<Integer> s = new ArrayList<>();
				s.add(q);
				s.add(w);
				s.add(r);
				replaceSelectedCards(s);
			}
			return true;
		}
		else {
			return false;
		}
	}
}

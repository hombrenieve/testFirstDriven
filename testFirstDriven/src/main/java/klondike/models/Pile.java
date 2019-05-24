package klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pile {

	private final int number;

	private int numberOfFaceUpCards;

	private Stack<Card> cards;

	public Pile(int number, List<Card> cards) {
		assert cards.size() > 0;
		this.number = number;
		this.numberOfFaceUpCards = 0;
		this.cards = new Stack<Card>();
		this.cards.addAll(cards);
		this.flipFirstCard();
	}

	public void push(Card card) {
		assert this.fitsIn(card);
		cards.push(card);
		this.numberOfFaceUpCards++;
	}

	public void push(List<Card> cards) {
		assert cards != null;
		for (Card card : cards) {
			this.push(card);
		}
	}

	private void flipFirstCard() {
		assert !this.cards.empty() && this.numberOfFaceUpCards == 0 && !this.cards.peek().isFacedUp();
		this.cards.peek().flip();
		this.numberOfFaceUpCards++;
	}

	public boolean fitsIn(Card card) {
		assert card != null;
		return (this.cards.empty() && card.getNumber() == Number.KING) || (!this.cards.empty()
				&& this.cards.peek().isNextTo(card) && this.cards.peek().getColor() != card.getColor());
	}

	public Card peek() {
		return this.cards.peek();
	}

	public List<Card> peek(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		return new ArrayList<Card>(this.cards.subList(this.cards.size() - numberOfCards, this.cards.size()));
	}

	public void remove() {
		this.remove(1);
	}

	public void remove(int numberOfCards) {
		assert numberOfCards <= this.numberOfFaceUpCards;
		for (int i = 0; i < numberOfCards; i++) {
			this.cards.pop();
			numberOfFaceUpCards--;
		}
		if (this.numberOfFaceUpCards == 0 && !this.cards.empty()) {
			flipFirstCard();
		}
	}

	public int numberOfFaceUpCards() {
		return this.numberOfFaceUpCards;
	}

	public boolean empty() {
		return this.cards.empty();
	}

	public Stack<Card> getCards() {
		return this.cards;
	}

	public int getNumber() {
		return this.number;
	}

}

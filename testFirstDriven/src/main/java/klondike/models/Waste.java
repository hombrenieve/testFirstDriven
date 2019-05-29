package klondike.models;

import java.util.Stack;

public class Waste {
	
	private Stack<Card> cards;
	
	public Waste() {
		cards = new Stack<Card>();
	}
	
	public boolean empty() {
        return this.cards.empty();
    }

    public Card peek() {
        assert !this.cards.empty();
        return this.cards.peek();
    }

    public Card pop() {
        assert !this.cards.empty();
        return this.cards.pop();
    }

    public void push(Card card) {
    	assert card.isFacedUp();
        this.cards.push(card);
    }
}

package klondike.models;

import java.util.Stack;

public class Foundation {

    private Suit suit;
    private Stack<Card> cards;

    public Foundation(Suit suit) {
        assert suit != null;
        this.suit = suit;
        this.cards = new Stack<Card>();
    }

    public boolean isComplete() {
        return this.cards.size() == Number.values().length;
    }

    public boolean fitsIn(Card card) {
        assert card != null;
        return card.getSuit() == this.suit &&
                (card.getNumber() == Number.AS ||
                        (!this.empty() && card.isNextTo(this.peek())));
    }

    public Suit getSuit() {
        return this.suit;
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
        this.cards.push(card);
    }
}

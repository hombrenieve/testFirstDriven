package klondike.models;

public class Waste {
	
	private CardStack cardStack;
	
	public Waste() {
		cardStack = new CardStack();
	}
	
	public boolean empty() {
        return this.cardStack.empty();
    }

    public Card peek() {
        return this.cardStack.peek();
    }

    public Card pop() {
        return this.cardStack.pop();
    }

    public void push(Card card) {
    	assert card.isFacedUp();
        this.cardStack.push(card);
    }
}

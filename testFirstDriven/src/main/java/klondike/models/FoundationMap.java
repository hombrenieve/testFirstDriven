package klondike.models;

import java.util.*;


public class FoundationMap {

    private Map<Suit, Foundation> foundations;

    public FoundationMap() {
        this.foundations = new HashMap<Suit, Foundation>();
        for (Suit suit : Suit.values()) {
            this.foundations.put(suit, new Foundation(suit));
        }
    }

    public boolean isFinished() {
        for (Suit suit : Suit.values()) {
            if (!this.foundations.get(suit).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public Foundation get(Suit suit) {
        return foundations.get(suit);
    }
}
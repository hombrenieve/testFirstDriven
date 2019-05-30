package klondike.models;

import java.util.*;


public class FoundationMap {

    private Map<Suit, Foundation> foundations;

    public FoundationMap() {
        this.foundations = new HashMap<Suit, Foundation>();
    }

    public boolean isFinished() {
        return false;
    }

    public Foundation get(Suit suit) {
        return foundations.get(suit);
    }
}
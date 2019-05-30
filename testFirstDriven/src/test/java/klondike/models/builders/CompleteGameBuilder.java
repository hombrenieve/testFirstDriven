package klondike.models.builders;

import klondike.models.Foundation;
import klondike.models.FoundationMap;
import klondike.models.Game;
import klondike.models.Number;
import klondike.models.Suit;

public class CompleteGameBuilder {

	public Game build() {
		Game game = new Game();
		FoundationMap foundations = game.getFoundations();
		for(int i=0; i< Suit.values().length; i++) {
			Foundation foundation = foundations.get(Suit.values()[i]);
			for(int j=0; j<Number.values().length; j++) {
				foundation.push(new CardBuilder().number(Number.values()[i]).build());
			}
		}
		return game;
	}
	
}

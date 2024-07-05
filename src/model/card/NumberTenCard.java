package model.card;
import model.pawn.Pawn;
import model.deck.*;

public class NumberTenCard  extends NumberCard{
	/**
	 * Constructor 
	 * @post  Creates NumberTenCard with value 10 and description
	 */
	public NumberTenCard() {
		setDescription("Move a pawn 10 squares forward or 1 backward");
		setValue(10);			
	}
	
	/**
	 * Overrides movePawn to do the special movement of Ten
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p , Deck b) {
		if(b.getOption() == "Move 10 forward") {
			Card card10 = new SimpleNumberCard(10,"Move 10 forward");
			if(card10.movePawn(p, b)) {
				return true;
			}
		}else if(b.getOption() == "Move 1 backward") {
			NumberCard cardBack1 = new NumberFourCard(); 
			cardBack1.setValue(-1);
			if(cardBack1.movePawn(p, b)) {
				return true;
			}
		}
		return false;
	}
	
}

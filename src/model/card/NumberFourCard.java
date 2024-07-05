package model.card;
import model.pawn.Pawn;
import model.square.HomeSquare;
import model.square.SafetyZoneSquare;
import model.square.StartSlideSquare;
import model.deck.*;

public class NumberFourCard extends NumberCard{
	/**
	 * Constructor 
	 * @post  Creates NumberFourCard with value 4 and description
	 */
	public NumberFourCard() {
		setDescription("Move a pawn 4 squares backwards");
		setValue(-4);			
	}
	
	/**
	 * Overrides movePawn to do the special movement of Four
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p , Deck b) {
		if(p.getActive() == false) {return false;}

		if(p.getPosX() == p.getStartX() && p.getPosY() == p.getStartY()) {
			return false;
		}
		int prevSquare = p.getSquare();
		int i = p.getSquare();
		//System.out.println("Original : " + i);
		
		if(i + getValue() <= 0) {  
			i = 72 - i ;
		}
		//System.out.println("After i - 72 : " + i);

		if((b.getGrid(i + getValue()) instanceof SafetyZoneSquare ||
				b.getGrid(i + getValue()) instanceof HomeSquare) &&
				!(b.getGrid(prevSquare) instanceof SafetyZoneSquare)) {
			i = i - 6;
		}
		
		if(i + getValue() < 0) {  
			i = 72 - i ;
		}
		
		//System.out.println("after safezone check : " + i);
		//System.out.println("Where to go after check : " + b.getGrid(i+getValue()));
		if(b.getGrid(i+getValue()).getEmpty() == false) {return false;}
		
	  /*int nextSquare = i + b.getCurrentCard().getValue();
		while(checkSquare <= nextSquare) {
			if(checkSquare >= 72) {checkSquare = 0;}
			if(b.getGrid(checkSquare) instanceof HomeSquare && 
					p.getColor() == b.getGrid(checkSquare).getColor()) {
				if(checkSquare != nextSquare) {return false;}
				else {p.setActive(false);}
			}
			checkSquare++;
		}*/
		
		p.move(
			b.getGrid(i+getValue()).getPosX(), 
			b.getGrid(i+getValue()).getPosY()
		);
		
		b.getGrid(prevSquare).setEmpty(true);
		b.getGrid(prevSquare).setPawn(null);
		if(!(b.getGrid(i+getValue()) instanceof HomeSquare)) {
			b.getGrid(i+getValue()).setEmpty(false);
			b.getGrid(i+getValue()).setPawn(p);
		}
		p.setSquare(i+getValue());
		
		if(b.getGrid(i+getValue())  instanceof  StartSlideSquare) {
			if(b.doSlide(p,b,i+getValue())) {
				return true;
			}
		}
	return true;
	}
	
}

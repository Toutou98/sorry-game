package model.card;
import model.pawn.Pawn;
import model.deck.*;
import model.square.*;

public class NumberOneCard extends NumberCard {
	
	/**
	 * Constructor 
	 * @post  Creates NumberOneCard with value 1 and description
	 */
	public NumberOneCard() {
		setDescription("Move a pawn from the Start or move a pawn 1 square forward");
		setValue(1);			
	}
	
	/**
	 * Overrides movePawn to do the special movement of One
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p , Deck b) {
			int i;
			if(p.getActive() == false) {return false;}
			//System.out.println(p.getPosX() + " "+ p.getPosY());
			//System.out.println(p.getStartX() + " " + p.getStartY());
			if(p.getPosX() == p.getStartX() && p.getPosY() == p.getStartY() ) {
				if(p.getColor() == "red") {
					if(b.getGrid(10).getEmpty()) {
						p.move(b.getGrid(10).getPosX(), b.getGrid(10).getPosY());					
						b.getGrid(10).setEmpty(false);
						b.getGrid(10).setPawn(p);
						p.setSquare(10);
						//System.out.println("TEST1");
						return true;
					}else {
						//System.out.println("TEST2");
						return false;
					}
				}else if(p.getColor() == "yellow") {
					if(b.getGrid(46).getEmpty()) {
						p.move(b.getGrid(46).getPosX(), b.getGrid(46).getPosY());
						b.getGrid(46).setEmpty(false);
						b.getGrid(46).setPawn(p);
						p.setSquare(46);
						return true;
					}else {
						return false;
					}
				}
			}
			int prevSquare = p.getSquare();
			i = p.getSquare();
			int checkSquare = p.getSquare();
			//System.out.println(i);
			
			if(i + 1 >= 72) {  i = i  - 72 ;}	
			if(b.getGrid(i+1).getColor() != p.getColor() && 
					b.getGrid(i+1) instanceof SafetyZoneSquare) {
				i = i + 6;
			}
			if(b.getGrid(i+1).getEmpty() == false) {return false;}
			
			int nextSquare = i + b.getCurrentCard().getValue();
			while(checkSquare <= nextSquare) {
				if(checkSquare >= 72) {checkSquare = 0;}
				if(b.getGrid(checkSquare) instanceof HomeSquare && 
						p.getColor() == b.getGrid(checkSquare).getColor()) {
					if(checkSquare != nextSquare) {return false;}
					else {p.setActive(false);}
				}
				checkSquare++;
			}
			
			p.move(
				b.getGrid(i+1).getPosX(), 
				b.getGrid(i+1).getPosY()
			);
			
			b.getGrid(prevSquare).setEmpty(true);
			b.getGrid(prevSquare).setPawn(null);
			if(!(b.getGrid(i+1) instanceof HomeSquare)) {
				b.getGrid(i+1).setEmpty(false);
				b.getGrid(i+1).setPawn(p);
			}
			p.setSquare(i+1);
			
			if(b.getGrid(i+1)  instanceof  StartSlideSquare) {
				if(b.doSlide(p,b,i+1)) {
					return true;
				}
			}
		return true;
	}
	
}

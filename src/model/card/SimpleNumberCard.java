package model.card;

import model.deck.Deck;
import model.pawn.Pawn;
import model.square.HomeSquare;
import model.square.SafetyZoneSquare;
import model.square.StartSlideSquare;

public class SimpleNumberCard  extends NumberCard{
	/**
	 * <b>Constructor</b> :Constructs a new instance of
	 * 		a simple number card using super constructor
	 * @param value Card value
	 * @param desc Card description
	 */
	public SimpleNumberCard(int value, String desc) {
		this.setValue(value);
		this.setDescription(desc);
	}
	
	/**
	 * Overrides movePawn to do the special movement of the card
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p , Deck b) {
		//System.out.println(getValue());
		if(p.getActive() == false) {return false;}

		if(p.getPosX() == p.getStartX() && p.getPosY() == p.getStartY()) {
			return false;
		}
		int prevSquare = p.getSquare();
		int checkSquare = p.getSquare();
		int i = p.getSquare();
		//System.out.println("Original : " + i);
		
		
		if(i + getValue() >= 72) {  
			i = i  - 72 ;
			 
		}
		//System.out.println("After i - 72 : " + i);
		//System.out.println("ColorSquare : " + b.getGrid(i+getValue()).getColor());
		if(b.getGrid(i+getValue()).getColor() != p.getColor()) {
			for(int checkEnemySafe = i ; checkEnemySafe <=i+getValue() ; checkEnemySafe++) {
				//System.out.println("EnemySafe : "+checkEnemySafe);
				if(checkEnemySafe < 0) {checkEnemySafe = 0;}
				if(b.getGrid(checkEnemySafe) instanceof SafetyZoneSquare
						||b.getGrid(checkEnemySafe) instanceof HomeSquare) {
					i = i + 6;
					break;
				}
			}
		}
		//System.out.println("after safezone check : " + i);
		//System.out.println("Where to go after check : " + b.getGrid(i+b.getCurrentCard().getValue()));
		if(b.getGrid(i+getValue()).getEmpty() == false) {return false;}
		
		int nextSquare = i + getValue();
		for(int index = 0 ; index < getValue(); index++) {
			if(checkSquare >= 72) {checkSquare = 0;}
			//System.out.println(checkSquare);
			//System.out.println(nextSquare);
			if(b.getGrid(checkSquare) instanceof HomeSquare && 
					p.getColor() == b.getGrid(checkSquare).getColor()) {
				//System.out.println(checkSquare);
				//System.out.println(nextSquare);
				if(checkSquare != nextSquare) {return false;}
				else {p.setActive(false);}
			}
			checkSquare++;
		}
		
		p.move(
			b.getGrid(i+getValue()).getPosX(), 
			b.getGrid(i+getValue()).getPosY()
		);
		
		b.getGrid(prevSquare).setEmpty(true);
		b.getGrid(prevSquare).setPawn(null);
		if(!(b.getGrid(i+getValue()) instanceof HomeSquare)) {
			b.getGrid(i+getValue()).setEmpty(false);
			b.getGrid(i+getValue()).setPawn(p);
		}else if(b.getGrid(i+getValue()) instanceof HomeSquare) {
			p.setActive(false);
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

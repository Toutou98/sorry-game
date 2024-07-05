package model.card;
import model.pawn.Pawn;
import model.deck.*;

public class NumberElevenCard  extends NumberCard{

	
	/**
	 * Constructor 
	 * @post  Creates NumberElevenCard with value 11 and description
	 */
	
	public NumberElevenCard() {
		setValue(11);
		setDescription("Move 11 squares forward or switch your pawn with the opponents");
	}
	
	/**
	 * Overrides movePawn to do the switching movement of Eleven
	 * @post pawn moves if possible else it doesn't
	 * @param b a Board
	 */
	public int movePawn( Deck b) {
		int tempX,tempY,tempSquare;
		if(b.getOption() == "Switch redPawn1 with yellowPawn1") {
			tempX = b.getRedPlayer().getPawn1().getPosX();
			tempY = b.getRedPlayer().getPawn1().getPosY();
			tempSquare = b.getRedPlayer().getPawn1().getSquare();
			b.getRedPlayer().getPawn1().move(b.getYellowPlayer().getPawn1().getPosX(), 
											 b.getYellowPlayer().getPawn1().getPosY());
			b.getRedPlayer().getPawn1().setSquare(b.getYellowPlayer().getPawn1().getSquare());
			
			b.getYellowPlayer().getPawn1().move(tempX,tempY);
			b.getYellowPlayer().getPawn1().setSquare(tempSquare);
			return 1;
		}else if(b.getOption() == "Switch redPawn1 with yellowPawn2") {
			tempX = b.getRedPlayer().getPawn1().getPosX();
			tempY = b.getRedPlayer().getPawn1().getPosY();
			tempSquare = b.getRedPlayer().getPawn1().getSquare();
			b.getRedPlayer().getPawn1().move(b.getYellowPlayer().getPawn2().getPosX(), 
											 b.getYellowPlayer().getPawn2().getPosY());
			b.getRedPlayer().getPawn1().setSquare(b.getYellowPlayer().getPawn2().getSquare());

			b.getYellowPlayer().getPawn2().move(tempX,tempY);
			b.getYellowPlayer().getPawn2().setSquare(tempSquare);
			return 1;
		}else if(b.getOption() == "Switch redPawn2 with yellowPawn1") {
			tempX = b.getRedPlayer().getPawn2().getPosX();
			tempY = b.getRedPlayer().getPawn2().getPosY();
			tempSquare = b.getRedPlayer().getPawn2().getSquare();
			b.getRedPlayer().getPawn2().move(b.getYellowPlayer().getPawn1().getPosX(), 
					 						 b.getYellowPlayer().getPawn1().getPosY());
			b.getRedPlayer().getPawn2().setSquare(b.getYellowPlayer().getPawn1().getSquare());

			b.getYellowPlayer().getPawn1().move(tempX,tempY);
			b.getYellowPlayer().getPawn1().setSquare(tempSquare);
			return 1;
		}else if(b.getOption() == "Switch redPawn2 with yellowPawn2") {
			tempX = b.getRedPlayer().getPawn2().getPosX();
			tempY = b.getRedPlayer().getPawn2().getPosY();
			tempSquare = b.getRedPlayer().getPawn2().getSquare();
			b.getRedPlayer().getPawn2().move(b.getYellowPlayer().getPawn2().getPosX(), 
											 b.getYellowPlayer().getPawn2().getPosY());
			b.getRedPlayer().getPawn2().setSquare(b.getYellowPlayer().getPawn2().getSquare());
			
			b.getYellowPlayer().getPawn2().move(tempX,tempY);
			b.getYellowPlayer().getPawn2().setSquare(tempSquare);
			return 1;
		}
		return 0;
	}
	
	/**
	 * Overrides movePawn to do the 11 squares forward movement of Eleven
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p, Deck b) {
		Card card11 = new SimpleNumberCard(11,"Move 11 squares forward");
		b.setCurrentCard(card11);
		return card11.movePawn(p, b);
	}
	
}

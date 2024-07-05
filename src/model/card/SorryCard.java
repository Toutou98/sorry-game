package model.card;
import model.deck.*;

public class SorryCard extends Card{

	/**
	 * <b>Constructor</b>Creates a SorryCard
	 * @post creates an instance of SorryCard
	 */
	public SorryCard() {
		setValue(13);
		setDescription("Move a pawn from Start to the possition of an opponents pawn."
					+ "Move the opponents pawn back to Start");
		setPlayed(false);
	}
	
	/**
	 * Overrides movePawn to do the special movement of Sorry
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param b a Board
	 */
	public int movePawn(Deck b) {
		int tempX,tempY,tempSquare;

		if(b.getWhoPlays().getColor() == "red") {
			if(b.getOption() == "Move redPawn1 to yellowPawn1") {

				tempX = b.getYellowPlayer().getPawn1().getPosX();
				tempY = b.getYellowPlayer().getPawn1().getPosY();
				tempSquare = b.getYellowPlayer().getPawn1().getSquare();
				b.getYellowPlayer().getPawn1().move(b.getYellowPlayer().getPawn1().getStartX(), 
											 		b.getYellowPlayer().getPawn1().getStartY());
				b.getYellowPlayer().getPawn1().setSquare(-1);
				
				b.getRedPlayer().getPawn1().setSquare(tempSquare);
				b.getRedPlayer().getPawn1().move(tempX,tempY);
			}else if(b.getOption() == "Move redPawn1 to yellowPawn2") {

				tempX = b.getYellowPlayer().getPawn2().getPosX();
				tempY = b.getYellowPlayer().getPawn2().getPosY();
				tempSquare = b.getYellowPlayer().getPawn2().getSquare();
				b.getYellowPlayer().getPawn2().move(b.getYellowPlayer().getPawn2().getStartX(), 
											 		b.getYellowPlayer().getPawn2().getStartY());
				b.getYellowPlayer().getPawn2().setSquare(-1);

				b.getRedPlayer().getPawn1().setSquare(tempSquare);
				b.getRedPlayer().getPawn1().move(tempX,tempY);
			}else if(b.getOption() == "Move redPawn2 to yellowPawn1") {

				tempX = b.getYellowPlayer().getPawn1().getPosX();
				tempY = b.getYellowPlayer().getPawn1().getPosY();
				tempSquare = b.getYellowPlayer().getPawn1().getSquare();
				b.getYellowPlayer().getPawn1().move(b.getYellowPlayer().getPawn1().getStartX(), 
											 		b.getYellowPlayer().getPawn1().getStartY());
				b.getYellowPlayer().getPawn1().setSquare(-1);

				b.getRedPlayer().getPawn2().setSquare(tempSquare);
				b.getRedPlayer().getPawn2().move(tempX,tempY);
			}else if(b.getOption() == "Move redPawn2 to yellowPawn2") {

				tempX = b.getYellowPlayer().getPawn2().getPosX();
				tempY = b.getYellowPlayer().getPawn2().getPosY();
				tempSquare = b.getYellowPlayer().getPawn2().getSquare();
				b.getYellowPlayer().getPawn2().move(b.getYellowPlayer().getPawn2().getStartX(), 
													b.getYellowPlayer().getPawn2().getStartY());
				b.getYellowPlayer().getPawn2().setSquare(-1);

				b.getRedPlayer().getPawn2().setSquare(tempSquare);
				b.getRedPlayer().getPawn2().move(tempX,tempY);
			}
		}
		if(b.getWhoPlays().getColor() == "yellow") {
			if(b.getOption() == "Move yellowPawn1 to redPawn1") {
				tempX = b.getRedPlayer().getPawn1().getPosX();
				tempY = b.getRedPlayer().getPawn1().getPosY();
				tempSquare = b.getRedPlayer().getPawn1().getSquare();
				b.getRedPlayer().getPawn1().move(b.getRedPlayer().getPawn1().getStartX(), 
											 	 b.getRedPlayer().getPawn1().getStartY());
				b.getRedPlayer().getPawn1().setSquare(-1);
				
				b.getYellowPlayer().getPawn1().setSquare(tempSquare);
				b.getYellowPlayer().getPawn1().move(tempX,tempY);
			}else if(b.getOption() == "Move yellowPawn1 to redPawn2") {

				tempX = b.getRedPlayer().getPawn2().getPosX();
				tempY = b.getRedPlayer().getPawn2().getPosY();
				tempSquare = b.getRedPlayer().getPawn2().getSquare();
				b.getRedPlayer().getPawn2().move(b.getRedPlayer().getPawn2().getStartX(), 
												 b.getRedPlayer().getPawn2().getStartY());
				b.getRedPlayer().getPawn2().setSquare(-1);
				
				b.getYellowPlayer().getPawn1().setSquare(tempSquare);
				b.getYellowPlayer().getPawn1().move(tempX,tempY);
			}else if(b.getOption() == "Move yellowPawn2 to redPawn1") {

				tempX = b.getRedPlayer().getPawn1().getPosX();
				tempY = b.getRedPlayer().getPawn1().getPosY();
				tempSquare = b.getRedPlayer().getPawn1().getSquare();
				b.getRedPlayer().getPawn1().move(b.getRedPlayer().getPawn1().getStartX(), 
												 b.getRedPlayer().getPawn1().getStartY());
				b.getRedPlayer().getPawn1().setSquare(-1);

				b.getYellowPlayer().getPawn2().setSquare(tempSquare);
				b.getYellowPlayer().getPawn2().move(tempX,tempY);
			}else if(b.getOption() == "Move yellowPawn2 to redPawn2") {

				tempX = b.getRedPlayer().getPawn2().getPosX();
				tempY = b.getRedPlayer().getPawn2().getPosY();
				tempSquare = b.getRedPlayer().getPawn2().getSquare();
				b.getRedPlayer().getPawn2().move(b.getRedPlayer().getPawn2().getStartX(), 
												 b.getRedPlayer().getPawn2().getStartY());
				b.getRedPlayer().getPawn2().setSquare(-1);

				b.getYellowPlayer().getPawn2().setSquare(tempSquare);
				b.getYellowPlayer().getPawn2().move(tempX,tempY);
			}
		}else if(b.getOption() == "cancel") {
			return 0;
		}
		return 0;

	}

	
	private int value;

	/**
	 * <b>Transformer:</b>
	 * Sets the value of the card
	 * @post The value of the card is set
	 * @param value of Card
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * <b>Accessor:</b>
	 * Gets the value of the card
	 * @post The card value is returned
	 * @return An integer with the card value
	 */
	public int getValue() {
		return value;
	}
}


/*		System.out.println(b.getOption());
System.out.println("Red Pawn 1: " + b.getRedPlayer().getPawn1().getSquare());
System.out.println("Red Pawn 2: " + b.getRedPlayer().getPawn2().getSquare());
System.out.println("Yellow Pawn 1: " + b.getYellowPlayer().getPawn1().getSquare());
System.out.println("Yellow Pawn 2: " + b.getYellowPlayer().getPawn2().getSquare());*/

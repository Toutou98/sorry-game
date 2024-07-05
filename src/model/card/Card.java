package model.card;

import model.pawn.Pawn;
import model.deck.*;

public abstract class Card {
	
	private String description;
	private boolean isPlayed;
	private int value;
	

		
	/**
	 * <b>Transformer(mutative): </b> Sets the state of the card if it is played or not
	 * @post isPlayed has the value true or false depending on the actions
	 * @param isPlayed variable that holds the state
	 */
	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}
	
	
	/**
	 * <b>Accessor (Observer): </b> Gets the state of the card(If it has been played or still in the game)
	 * @post The isPlayed variable returns its value
	 * @return A boolean with the state of the card
	 */
	public boolean getPlayed() {
		return isPlayed;
	}
	
	/**
	 * <b>Transformer:</b>
	 * Sets the description of the card.
	 * @post The description of the card is set
	 * @param  description of card
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * <b>Accessor:</b>
	 * Gets the description of the card.
	 * @post The description is returned
	 * @return A String with the description of the card
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * Moves a pawn on the board with the card value
	 * @post pawn moves if possible else it doesn't
	 * @return true if the pawn moved else returns false
	 * @param p a Pawn
	 * @param b a Board
	 */
	public boolean movePawn(Pawn p , Deck b) {
		return true;
	}
	
	/**
	 * 
	 * Used as a special movePawn for Card7, Card11, SorryCard
	 * @post pawns move if possible
	 * @param b a Board
	 * @return 0
	 */
	public int movePawn(Deck b) {
		return 0;
	}
	
	/**
	 * <b>Accessor(selector) :</b> Returns the value of the card
	 * @post the value of the card is returned
	 * @return value of the card
	 */
	public int getValue() {
		return value;
	}
	
}

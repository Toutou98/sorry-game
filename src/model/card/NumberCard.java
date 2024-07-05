package model.card;



public class NumberCard extends Card{
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

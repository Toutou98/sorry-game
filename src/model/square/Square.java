package model.square;
import model.pawn.*;

public abstract class Square {
	private boolean empty;
	private String color;
	private final int posX,posY;
	private Pawn pawn;
	
	/**
	 * <b>Constructor: </b>Creates a Square and sets the initial values
	 * @post A square is created with it's initial values
	 * @param posX X coord
	 * @param posY Y coord
	 * @param color of the Square
	 */
	public Square(int posX,int posY,String color) {
		this.posX = posY ;
		this.posY = posX ;
		this.color = color;
		this.empty = true;
	}
	
	/**
	 * <b>Transformer(mutative):</b>Sets the square color
	 * @post Square has color 
	 * @param color of the square
	 */
	public void setColor (String color) {
		this.color = color;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets the square color
	 * @post Returns the square color
	 * @return color String with square color
	 */
	public String getColor() {
		return color;
	}
	
	
	/**
	 * <b>Accessor(selector):</b> Gets the X coord of the square
	 * @post Returns the X coord
	 * @return posX
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets the Y coord of the square
	 * @post Returns the Y coord
	 * @return posY
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * <b>Transformer(mutative):</b>Set a square to be empty or not
	 * @post Square has boolean value empty set 
	 * @param empty State of the square
	 */
	public void setEmpty (boolean empty) {
		this.empty = empty;
	}
	
	/**
	 * <b>Accessor(observer):</b> Gets the value if a square is empty or not
	 * @post Returns the value of empty
	 * @return if the square is empty
	 */
	public boolean getEmpty() {
		return empty;
	}
	
	/**
	 * <b>Transformer(mutative) :</b>Set the pawn on the square
	 * @post The pawn on the square is set
	 * @param p Pawn on the square
	 */
	
	public void setPawn(Pawn p) {
		this.pawn = p;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets the pawn that is on the square
	 * @post The pawn on the square is returned
	 * @return pawn On the square
	 */
	public Pawn getPawn() {
		return pawn;
	}
	
}

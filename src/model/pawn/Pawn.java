package model.pawn;


public class Pawn {
	private int posX , posY  ,startX , startY;
	private String color;
	private boolean active;
	private int square;
	
	/**
	 *<b> Constructor</b>
	 * Creates a Pawn with the given coordinates
	 * @param x coords
	 * @param y	coords
	 * @param color color of pawn
	 */
	public Pawn (int x, int y , String color) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.color = color;
		this.active = true;
		this.square = -1;
	}
	/**
	 * @post Moves Pawn to the square with x,y coords
	 * @param x coords
	 * @param y coords
	 */
	public void move(int x , int y) {
		setPosX(x);
		setPosY(y);
	}
	
	/**
	 * <b>Transformer(mutative):</b>Sets X position of pawn
	 * @post Set a Pawns X cords
	 * @param x coords
	 */
	public void setPosX(int x) {
		this.posX = x;
	}
	
	/**
	 * <b>Transformer(mutative):</b>Sets Y position of pawn
	 * @post Set a Pawns Y cords
	 * @param y coords
	 */
	public void setPosY(int y) {
		this.posY = y;
	}
	
	/**
	 * <b>Transformer(mutative):</b>Sets color of pawn
	 * @post Set a Pawns Color
	 * @param c color
	 */
	public void setColor(String c) {
		this.color = c;
	}
	
	/**
	 * <b>Transformer(mutative):</b>Sets activity of pawn
	 * @post Sets the state of the pawn
	 * @param active State of pawn
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets X position
	 * @post gets current X-axis position
	 * @return posX 
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets Y position
	 * @post gets current Y-axis position
	 * @return posY
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets color
	 * @post Gets color
	 * @return color
	 */
	public String getColor() {
		return color ;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets start X position
	 * @post Gets starting X position
	 * @return startX
	 */
	public int getStartX() {
		return startX;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets start Y position
	 * @post Gets starting Y position
	 * @return startY
	 */
	public int getStartY() {
		return startY;
	}
	
	/**
	 * <b>Accessor(observer):</b> Gets activity of the pawn
	 * @post The state of the pawn is returned
	 * @return active
	 */
	
	public boolean getActive() {
		return active;
	}
	/**
	 * <b>Transformer(mutative):</b>Sets the square the pawn sits on
	 * @post the square that the pawn sits is set
	 * @param s
	 */
	public void setSquare(int s) {
		this.square = s;
	}
	/**
	 * <b>Accessor(observer):</b> Gets the square that the pawn sits on
	 * @post the square that the pawn sits in returned
	 * @return square
	 */
	public int getSquare() {
		return this.square;
	}
	
	
}

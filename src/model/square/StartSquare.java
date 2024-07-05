package model.square;

public class StartSquare  extends Square{
	private String canEnter;
	/**
	 * <b>Contructor: </b>Creates a StartSquare
	 * @post The StartSquare is created
	 * @param posX	Coord
	 * @param posY	Coord
	 * @param color the square color
	 */
	public StartSquare(int posX,int posY,String color) {
		super(posX,posY,color);
		this.canEnter = color;
	}
	
	
	/**
	 * <b>Accessor(selector):</b> Gets who can enter the square
	 * @post Returns who can enter the square
	 * @return String with who can enter the square 
	 */
	public String getEnter() {
		return canEnter;
	}
}

package model.square;

public class HomeSquare extends Square {
	private String canEnter;
	/**
	 * <b>Contructor: </b>Creates a HomeSquare
	 * @post The HomeSquare is created
	 * @param posX Coord
	 * @param posY Coord
	 * @param color the square color
	 */
	public HomeSquare(int posX,int posY,String color) {
		super(posX,posY,color);
		this.canEnter = color;
	}
	
	
	/**
	 * <b>Accessor:</b> Gets who can enter the square
	 * @post Returns who can enter the square
	 * @return String with who can enter the square 
	 */
	public String getEnter() {
		return canEnter;
	}
}

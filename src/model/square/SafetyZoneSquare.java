package model.square;

public class SafetyZoneSquare extends Square {
	private String canEnter;
	/**
	 * <b>Contructor: </b>Creates a SafetyZoneSquare
	 * @post The SafetyZoneSquare is created
	 * @param posX coords of square
	 * @param posY coords of square
	 * @param color the square color
	 */
	public SafetyZoneSquare(int posX,int posY,String color) {
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

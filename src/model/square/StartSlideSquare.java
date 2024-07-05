package model.square;

public class StartSlideSquare extends SlideSquare {
	private int length;
	/**
	 * <b>Constructor: </b>Creates a StartSlideSquare
	 * @post The StartSlideSquare is created
	 * @param posX coords of square
	 * @param posY coords of square
	 * @param color the square color
	 * @param length slide length
	 */
	public StartSlideSquare (int posX,int posY,String color,int length) {
		super(posX,posY,color);
		this.length = length;
	}
	
	/**
	 * <b>Accessor: </b>Gets how many steps to slide to the end
	 * @post The slide length is returned
	 * @return How many squares to reach the EndSlideSquare
	 */
	public int getLength() {
		return length;
	}
}

package model.player;
import model.pawn.*;

public class Player {
	private String color;
	private Pawn pawn1,pawn2;
	/**
	 * Constructor
	 * @post Creates the red Player and the Yellow player
	 * @param x coords
	 * @param y coords
	 * @param color color
	 */
	public Player(int x ,int y,String color) {
		
		this.color = color;
		pawn1 = new Pawn(x , y , color);
		pawn2 = new Pawn(x+48 , y , color);
		//add pawn 1 and pawn 2 with coords and color
		
		
	}
	/**
	 * <b>Accessor(selector):</b> Gets pawn 1
	 * Gets Pawn number 1
	 * @post The pawn1 is returned
	 * @return Object pawn1
	 */
	public Pawn getPawn1() {
		return pawn1;
	}
	
	/**
	 * <b>Accessor(selector):</b> Gets pawn 2
	 * Gets Pawn number 2
	 * @post The pawn2 is returned
	 * @return Object pawn2
	 */
	public Pawn getPawn2() {
		return pawn2;
	}
	
	/**
	 * <b>Accessor(selector) :</b>Gets the color of the Player
	 * @post the color is returned
	 * @return color 
	 */
	public String getColor() {
		return color;
	}
}

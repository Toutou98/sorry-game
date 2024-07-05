package model.deck;

import java.util.*;
import model.card.*;
import model.pawn.*;
import model.player.*;
import model.square.*;

public class Deck {
	
	private Square[] grid = new Square[72]; 
	private Player redPlayer,yellowPlayer;
	private Stack<Card> stackOfCards = new Stack<>();
	private Card currentCard;
	private String choice;
	private Player whoPlays;
	private int slide = 0;

	
	
	/**
	 * <b>Constructor</b>Initialises the Cards,Players,Pawns and the Board Squares.
	 * @post Cards,Players,Pawns,Boards Squares have been initialised
	 */
	public Deck() {
		
		grid[0]   = new SimpleSquare(0,0*48);			//corner
		grid[1]   = new StartSlideSquare(0,1*48,"red",4);
		grid[2]   = new InternalSlideSquare (0,2*48,"red");
		
		grid[3]  = new SafetyZoneSquare(1*48,2*48,"red"); //RED SAFETY ZONE
		grid[4]  = new SafetyZoneSquare(2*48,2*48,"red");
		grid[5]  = new SafetyZoneSquare(3*48,2*48,"red");
		grid[6]  = new SafetyZoneSquare(4*48,2*48,"red");
		grid[7]  = new SafetyZoneSquare(5*48,2*48,"red");
		grid[8]  = new HomeSquare(288,72,"red");
		
		grid[9]   = new InternalSlideSquare (0,3*48,"red");
		grid[10]  = new EndSlideSquare (0,4*48,"red");
		grid[11]  = new SimpleSquare(0,5*48);
		grid[12]  = new SimpleSquare(0,6*48);
		grid[13]  = new SimpleSquare(0,7*48);
		grid[14]  = new SimpleSquare(0,8*48);
		grid[15]  = new StartSlideSquare(0,9*48,"red",5);
		grid[16]  = new InternalSlideSquare (0,10*48,"red");
		grid[17]  = new InternalSlideSquare (0,11*48,"red");
		grid[18]  = new InternalSlideSquare (0,12*48,"red");
		grid[19]  = new EndSlideSquare (0,13*48,"red");
		grid[20]  = new SimpleSquare(0,14*48);
		grid[21]  = new SimpleSquare(0,15*48);   		//corner
		
		grid[22]  = new StartSlideSquare(1*48,15*48,"blue",4);
		grid[23]  = new InternalSlideSquare(2*48,15*48,"blue");
		grid[24]  = new InternalSlideSquare(3*48,15*48,"blue");
		grid[25]  = new EndSlideSquare(4*48,15*48,"blue");
		grid[26]  = new SimpleSquare(5*48,15*48);
		grid[27]  = new SimpleSquare(6*48,15*48);
		grid[28]  = new SimpleSquare(7*48,15*48);
		grid[29]  = new SimpleSquare(8*48,15*48);
		grid[30]  = new StartSlideSquare(9*48,15*48,"blue",5);
		grid[31]  = new InternalSlideSquare(10*48,15*48,"blue");
		grid[32]  = new InternalSlideSquare(11*48,15*48,"blue");
		grid[33]  = new InternalSlideSquare(12*48,15*48,"blue");
		grid[34]  = new EndSlideSquare(13*48,15*48,"blue");
		grid[35]  = new SimpleSquare(14*48,15*48);
		grid[36]  = new SimpleSquare(15*48,15*48);   		//corner
		
		grid[37]  = new StartSlideSquare(15*48,14*48,"yellow",4);
		grid[38]  = new InternalSlideSquare(15*48,13*48,"yellow");
		
		grid[39]  = new SafetyZoneSquare(14*48,13*48,"yellow");//YELLOW SAFETY ZONE
		grid[40]  = new SafetyZoneSquare(13*48,13*48,"yellow");
		grid[41]  = new SafetyZoneSquare(12*48,13*48,"yellow");
		grid[42]  = new SafetyZoneSquare(11*48,13*48,"yellow");
		grid[43]  = new SafetyZoneSquare(10*48,13*48,"yellow");
		grid[44]  = new HomeSquare(380,600,"yellow");
		
		grid[45]  = new InternalSlideSquare(15*48,12*48,"yellow");
		grid[46]  = new EndSlideSquare(15*48,11*48,"yellow");
		grid[47]  = new SimpleSquare(15*48,10*48);
		grid[48]  = new SimpleSquare(15*48,9*48);
		grid[49]  = new SimpleSquare(15*48,8*48);
		grid[50]  = new SimpleSquare(15*48,7*48);
		grid[51]  = new StartSlideSquare(15*48,6*48,"yellow",5);
		grid[52]  = new InternalSlideSquare(15*48,5*48,"yellow");
		grid[53]  = new InternalSlideSquare(15*48,4*48,"yellow");
		grid[54]  = new InternalSlideSquare(15*48,3*48,"yellow");
		grid[55]  = new EndSlideSquare(15*48,2*48,"yellow");
		grid[56]  = new SimpleSquare(15*48,1*48);
		grid[57]  = new SimpleSquare(15*48,0*48);   //corner
	
		grid[58]  = new StartSlideSquare(14*48,0*48,"green",5);
		grid[59]  = new InternalSlideSquare(13*48,0*48,"green");
		grid[60]  = new InternalSlideSquare(12*48,0*48,"green");
		grid[61]  = new EndSlideSquare(11*48,0*48,"green");
		grid[62]  = new SimpleSquare(10*48,0*48);
		grid[63]  = new SimpleSquare(9*48,0*48);
		grid[64]  = new SimpleSquare(8*48,0*48);
		grid[65]  = new SimpleSquare(7*48,0*48);
		grid[66]  = new StartSlideSquare(6*48,0*48,"green",5);
		grid[67]  = new InternalSlideSquare(5*48,0*48,"green");
		grid[68]  = new InternalSlideSquare(4*48,0*48,"green");
		grid[69]  = new InternalSlideSquare(3*48,0*48,"green");
		grid[70]  = new EndSlideSquare(2*48,0*48,"green");
		grid[71]  = new SimpleSquare(1*48,0*48);

		
		redPlayer	 = new Player(172,50,"red");
		yellowPlayer = new Player(502,670,"yellow");
		
		
		fillStack();
		Shuffle();

	}
	

	
	/**
	 * <b>Accessor(observer)</b>Checks if the stack of cards is empty
	 * @post true or false is returned 
	 * @return true if stack is empty else return false
	 */
	public boolean CheckIfStackEmpty() {
		if(stackOfCards.empty()) return true;
		return false;
	}
	/**
	 * <b>Transformer(mutative):</b> Fills the stack with cards
	 * @post the stack is filled
	 * @return stackOfCards
	 */
	public Stack<Card> fillStack(){
		 for(int i = 0 ; i < 4 ; i++) {
	        	stackOfCards.push(currentCard = new NumberOneCard());
	        	stackOfCards.push(currentCard = new NumberTwoCard());
	        	stackOfCards.push(currentCard = new SimpleNumberCard(3,"Move 3 squares forward"));
	        	stackOfCards.push(currentCard = new NumberFourCard());
	        	stackOfCards.push(currentCard = new SimpleNumberCard(5,"Move 5 squares forward"));
	        	stackOfCards.push(currentCard = new NumberSevenCard());
	        	stackOfCards.push(currentCard = new SimpleNumberCard(8,"Move 8 squares forward"));
	        	stackOfCards.push(currentCard = new NumberTenCard());
	        	stackOfCards.push(currentCard = new NumberElevenCard());
	        	stackOfCards.push(currentCard = new SimpleNumberCard(12,"Move 12 squares forward"));
	        	stackOfCards.push(currentCard = new SorryCard());
	      }
     	
		return stackOfCards;
	}
	
	/**
	 * <b>Transformer</b>Shuffles the stackOfCards
	 * @post the Stack is shuffled
	 * @return stackOfCards
	 */
	public Stack<Card> Shuffle() {
		Collections.shuffle(stackOfCards);
		return stackOfCards;
	}
	

	/**
	 * <b>Accessor(selector)</b> Returns the red player
	 * @post red player is returned
	 * @return redPlayer
	 */
	public Player getRedPlayer() {
		return redPlayer;
	}
	/**
	 * <b>Accessor(selector)</b> Returns the yellow player
	 * @post yellow player is returned
	 * @return yellowPlayer
	 */
	public Player getYellowPlayer() {
		return yellowPlayer;
	}
	
	/**
	 * <b>Accessor(selector)</b> Returns the stack of cards
	 * @post the stack of cards is returned
	 * @return stackOfCards
	 */
	public Stack<Card> getStack(){
		return stackOfCards;
	}
	/**
	 * <b> Accessor(selector) :</b> Gets how many cards left in the stack
	 * @post the size of the stuck is returned
	 * @return stackOfCards size
	 */
	
	public int getStackSize() {
		return stackOfCards.size();
	}
	
	/**
	 * <b>Accessor(selector) :</b> peeks the top card
	 * @post the top card is returned
	 * @return the top card
	 */
	public Card peekTopCard() {
		return stackOfCards.peek();
	}
	
	/**
	 * <b>Accessor(selector) :</b> gets the current card
	 * @post the current card is returned
	 * @return currentCard
	 */
	
	public Card getCurrentCard() {
		return currentCard;
	}
	
	/**
	 * <b>Transformer(mutative) :</b>Sets the current card
	 * @post the currentCard is set
	 * @param c
	 */
	
	public void setCurrentCard(Card c) {
		this.currentCard = c;
	}
	/**
	 * <b>Accessor(selector) :</b> gets the grid[i]
	 * @post grid[i] is returned
	 * @param i
	 * @return grid[i]
	 */
	public Square getGrid(int i) {
		return grid[i];
	}

	
	/**
	 * Check is the pawn lands on a StartSlideSquare
	 * if it lands on StartSlideSquare then moves to EndSlideSquare
	 * else it stays on the square. Also if the StartSlideSquare is of
	 * same color then it stays on the square.
	 * @post If the pawn moved to the end of the slide or 
	 * 	it stayed in the same square if there was not a StartSlideSquare 
	 * @param p Pawn
	 * @param b Deck
	 * @param i The square the pawn landed
	 * @return true if it slided else returns false
	 */
	public boolean doSlide(Pawn p ,Deck b,int i) {
		int second,third;
		if(b.getGrid( i )  instanceof  StartSlideSquare) {
			if(b.getGrid(i).getColor() != p.getColor()){
				if(b.getGrid(i).getColor() == "red" || b.getGrid(i).getColor() == "yellow" ) {
					second = i + 8;
					third = i + 9;
				}else {
					second = i+2;
					third = i+3;
				}
				if(b.getGrid(third)  instanceof  EndSlideSquare ) {
					if( (b.getGrid(i+1).getEmpty()) &&
						(b.getGrid(second).getEmpty()) &&
						(b.getGrid(third).getEmpty()))
					{
						//System.out.println(b.getGrid(third).getClass());
						p.move(b.getGrid(third).getPosX(), b.getGrid(third).getPosY());
						p.setSquare(third);
						b.getGrid(i).setEmpty(true);
						b.getGrid(i).setPawn(null);
						b.getGrid(third).setEmpty(false);
						b.getGrid(third).setPawn(p);
						setdidSlide(1);

						return true;
					}else {
						if(!b.getGrid(i+1).getEmpty()){
							//System.out.println(b.getGrid(i+1).getPawn());
							b.getGrid(i+1).getPawn().
							move(
								b.getGrid(i+1).getPawn().getStartX(), 
								b.getGrid(i+1).getPawn().getStartY()
							);
							b.getGrid(i+1).getPawn().setSquare(-1);
							b.getGrid(i+1).setEmpty(true);
							b.getGrid(i+1).setPawn(null);
							
						}
						if(!b.getGrid(second).getEmpty()){
							//System.out.println(b.getGrid(second).getPawn());
							b.getGrid(second).getPawn().
							move(
								b.getGrid(second).getPawn().getStartX(), 
								b.getGrid(second).getPawn().getStartY()
							);
							b.getGrid(second).getPawn().setSquare(-1);
							b.getGrid(second).setEmpty(true);
							b.getGrid(second).setPawn(null);
							
						}
						if(!b.getGrid(third).getEmpty()){
							//System.out.println(b.getGrid(third).getPawn());
							b.getGrid(third).getPawn().
							move(
								b.getGrid(third).getPawn().getStartX(), 
								b.getGrid(third).getPawn().getStartY()
							);
							b.getGrid(third).getPawn().setSquare(-1);
							b.getGrid(third).setEmpty(true);
							b.getGrid(third).setPawn(null);
						}
						p.move(
								b.getGrid(third).getPosX(), 
								b.getGrid(third).getPosY()
							);
						b.getGrid(i).setEmpty(true);
						b.getGrid(i).setPawn(null);
						b.getGrid(third).setEmpty(false);
						b.getGrid(third).setPawn(p);
						p.setSquare(third);
						setdidSlide(1);
						return true;
					}
				}else if(b.getGrid(i+4) instanceof EndSlideSquare) {
					if(		(b.getGrid(i+1).getEmpty())&&
							(b.getGrid(i+2).getEmpty())&&
							(b.getGrid(i+3).getEmpty())&&
							(b.getGrid(i+4).getEmpty()))
					{
						p.move(
							b.getGrid(i+4).getPosX(), 
							b.getGrid(i+4).getPosY()
						);
						p.setSquare(i+4);
						b.getGrid(i).setEmpty(true);
						b.getGrid(i).setPawn(null);
						b.getGrid(i+4).setEmpty(false);
						b.getGrid(i+4).setPawn(p);
						setdidSlide(1);
						return true;
					}else {
						//System.out.println(b.getGrid(i+1).getPawn());
						if(!b.getGrid(i+1).getEmpty()){
							
							b.getGrid(i+1).getPawn().
							move(
								b.getGrid(i+1).getPawn().getStartX(), 
								b.getGrid(i+1).getPawn().getStartY());
							b.getGrid(i+1).getPawn().setSquare(-1);
							b.getGrid(i+1).setEmpty(true);
							b.getGrid(i+1).setPawn(null);
						}
						if(!b.getGrid(i+2).getEmpty()){
							//System.out.println(b.getGrid(i+2).getPawn());
							b.getGrid(i+2).getPawn().
							move(
								b.getGrid(i+2).getPawn().getStartX(), 
								b.getGrid(i+2).getPawn().getStartY());
							b.getGrid(i+2).getPawn().setSquare(-1);
							b.getGrid(i+2).setEmpty(true);
							b.getGrid(i+2).setPawn(null);
							
						}
						if(!b.getGrid(i+3).getEmpty()){
							//System.out.println(b.getGrid(i+3).getPawn());
							b.getGrid(i+3).getPawn().
							move(
								b.getGrid(i+3).getPawn().getStartX(), 
								b.getGrid(i+3).getPawn().getStartY());
							b.getGrid(i+3).getPawn().setSquare(-1);
							b.getGrid(i+3).setEmpty(true);
							b.getGrid(i+3).setPawn(null);
						}
						if(!b.getGrid(i+4).getEmpty()){
							//System.out.println(b.getGrid(i+4).getPawn());
							b.getGrid(i+4).getPawn().
							move(b.getGrid(i+4).getPawn().getStartX(), 
								 b.getGrid(i+4).getPawn().getStartY());
							b.getGrid(i+4).getPawn().setSquare(-1);
							b.getGrid(i+4).setEmpty(true);
							b.getGrid(i+4).setPawn(null);
						}
						
						p.move(b.getGrid(i+4).getPosX(), b.getGrid(i+4).getPosY());
						b.getGrid(i).setEmpty(true);
						b.getGrid(i).setPawn(null);
						b.getGrid(i+4).setEmpty(false);
						b.getGrid(i+4).setPawn(p);
						p.setSquare(i+4);
						setdidSlide(1);
						return true;
					} 
				}
			}
		}else {
			return false;
		}
		return false;
	}
	
	/**
	 * <b>Transformer(mutative) : </b>Sets the option of the player
	 * @post the option of the player is set
	 * @param choice Of the player
	 */
	public void setOption(String choice) {
		this.choice = choice;
		
	}
	 /**
	  * <b>Accesor(selective) :</b> gets the option of the player
	  * @post the option of the player is set
	  * @return choice Of the player
	  */
	public String getOption() {
		return choice;
	}
	
	/**
	 * <b>Transformer(mutative): </b>Sets who is playing right now
	 * @post The player that is playing is set
	 * @param currentPlayer Whose turn it is
	 */
	public void setWhoPlays(Player currentPlayer) {
		this.whoPlays = currentPlayer;
	}
	
	/**
	 * <b>Accessor(selector): </b>Gets who is playing right now
	 * @post the player who is playing is returned
	 * @return The player that is playing now
	 */
	public Player getWhoPlays() {
		return whoPlays;
	}
	
	/**
	 * <b>Transformer(mutative) :</b>Sets the value slide
	 * @post the value slide is set
	 * @param slide 
	 */
	public void setdidSlide(int slide) {
		this.slide = slide;
	}
	
	/**
	 * <b>Accessor(selector):</b> Method to get if a pawn did a slide or not(0 if no pawns slided,
	 * 1 if one pawn slided and 2 if 2 pawns slided)
	 * @post value of slide is returned
	 * @return slide
	 */
	public int getdidSlide() {
		return slide;
	}
}	

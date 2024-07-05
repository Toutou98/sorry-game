package controller;

import model.card.*;
import model.pawn.*;
import model.player.*;
import model.square.*;
import model.deck.*;
import view.OptionDialog;

/**
 * Controller controls all the operations executed
 * @author miket
 *
 */
public class Controller {
	
	private Pawn[]      redPawns,yellowPawns;
	private Card 		currentCard;
	private Pawn 		pickedPawn;
	private Player 		whoPlays;
	private String 		winner , playerChoice;
	private Player 		winnerPlayer;
	private Deck 		deck = new Deck() ;
	
	/**
	 * <b>Contructor: </b>Contructs a new controller and the game is ready to start
	 * @post Contructs a new controller with the 2 Players their 2 Pawns for each one.
	 * 		 Creates the board of the game(Squares)
	 * 		 Creates the stackOfCards.Sets initial values to variables
	 * 		 (currentCard,pickedPawn,whoPlays).
	 */
	public Controller() {
		
		redPawns = new Pawn[2];
		yellowPawns = new Pawn[2];

		double x = Math.random();
        if( x >= 0.5) {whoPlays = deck.getYellowPlayer();}
        else {whoPlays = deck.getRedPlayer();}
		deck.setWhoPlays(whoPlays);

	}
	/**
	 * <b>Transformer(mutative): </b>This method pops a card from the stack
	 * @post All the necessary actions during a turn have been made
	 */
	public void drawCard() {
		if(deck.CheckIfStackEmpty()) {
			deck.fillStack();
	        deck.Shuffle();
		}
		currentCard = deck.getStack().pop();
		deck.setCurrentCard(currentCard);
	}
	/**
	 * <b>Transformer(applicative): </b>Checks if the game has a winner
	 * @post if the game has a winner returns true else false
	 * @return true if the winner exists else false
	 */
	public boolean checkWinner() {
		if(!deck.getRedPlayer().getPawn1().getActive()) {
			deck.getRedPlayer().getPawn1().move(73, 288);
		}
		if(!deck.getRedPlayer().getPawn2().getActive()) {
			deck.getRedPlayer().getPawn2().move(121, 288);
		}
		if(!deck.getYellowPlayer().getPawn1().getActive()) {
			deck.getYellowPlayer().getPawn1().move(601, 420);
		}
		if(!deck.getYellowPlayer().getPawn2().getActive()) {
			deck.getYellowPlayer().getPawn2().move(649, 420);
		}
		if(!deck.getRedPlayer().getPawn1().getActive() &&
				!deck.getRedPlayer().getPawn2().getActive()) {
			winner = "red";
			winnerPlayer = deck.getRedPlayer();
			return true;
		}else if(!deck.getYellowPlayer().getPawn1().getActive() &&
				!deck.getYellowPlayer().getPawn2().getActive()) {
			winner = "yellow";
			winnerPlayer = deck.getYellowPlayer();
			return true;
		}
		
		return false;
		//Check if a Player has both Pawn inside home and sets the winner
		//If winner is found then call endGame()
	}
	/**
	 * <b>Accessor (selector):</b>Gets the winner of the game
	 * @post The winner of the game is returned
	 * @return winner Of the game
	 */
	public String getWinner() {
		return winner;
	}
	/**
	 * <b>Accessor(selector) :</b>Gets the winner of the game in Player class form
	 * @post The winner is returned
	 * @return the winner of the g
	 */
	public Player getWinnerPlayer() {
		return winnerPlayer;
	}
	/**
	 * <b>Transformer(mutative): </b>Sets who is playing right now
	 * @post The player that is playing is set
	 * @param currentPlayer Whose turn it is
	 */
	public void setWhoPlays(Player currentPlayer) {
		this.whoPlays = currentPlayer;
		deck.setWhoPlays(currentPlayer);
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
	 * <b>Accessor(selector): </b>Gets the Deck instance
	 * @post The deck is returned
	 * @return deck
	 */
	
	public Deck getDeck() {
		return this.deck;
	}
	/**
	 * <b> Transformer(mutative) :</b> Sets the pawn that was picked
	 * @post the pawn is picked
	 * @param pawn A pawn
	 */
	 public void setPickedPawn(int pawn) {
		 if(pawn == 0 ) pickedPawn = deck.getRedPlayer().getPawn1(); 
		 if(pawn == 1 ) pickedPawn = deck.getRedPlayer().getPawn2();
		 if(pawn == 2 ) pickedPawn = deck.getYellowPlayer().getPawn1(); 
		 if(pawn == 3 ) pickedPawn = deck.getYellowPlayer().getPawn2();
	 }
	 /**
	  * <b>Accessor(selector) :</b> Gets the picked pawn
	  * @post the picked pawn is returned
	  * @return pickedPawn
	  */
	 public Pawn getPickedPawn() {
		 return this.pickedPawn;
	 }
	/**
	 *<b>Accessor(selector): </b>Gets the current card
	 * @post the current card is returned
	 * @return currentCard
	 */
	 
	 public Card getCurrentCard() {
		 return currentCard;
	 }
	 /**
	  * <b>Accessor(selector) :</b>Gets a pawn depending on a the parameter
	  * @post The pawn(param) is returned(null if the pawn doesn't exist)
	  * @param pawn 
	  * @return Pawn based on param
	  */
	 public Pawn getPawns(int pawn) {
		redPawns[0] = deck.getRedPlayer().getPawn1(); 
		redPawns[1] = deck.getRedPlayer().getPawn2();
		yellowPawns[0] = deck.getYellowPlayer().getPawn1(); 
		yellowPawns[1] = deck.getYellowPlayer().getPawn2();
		if(pawn == 0 ) return redPawns[0]; 
		if(pawn == 1 ) return redPawns[1]; 
		if(pawn == 2 ) return yellowPawns[0]; 
		if(pawn == 3 ) return yellowPawns[1];
		 return null;
	 }
	 /**
	  * Gets and stores the option of the player
	  * @post the option of the player is received
	  */
	 public void doChoice() {
		 
		 if(currentCard.getValue() == 7) {
				OptionDialog option = new OptionDialog(7);
				while(option.choice() == null) {
					option = new OptionDialog(7);
				}
	            playerChoice = option.choice();
	            deck.setOption(playerChoice);
	        
		}
		 
		if(currentCard.getValue() == 10) {
			 OptionDialog option = new OptionDialog(10);
				while(option.choice() == null) {
					option = new OptionDialog(10);
				}
	            playerChoice = option.choice();
	            deck.setOption(playerChoice);
		}
		
		if(currentCard.getValue() == 11) {
			boolean[] pawnsFor11 = {true, true , true , true};
			if((deck.getRedPlayer().getPawn1().getSquare() == -1)  ||
				deck.getGrid(deck.getRedPlayer().getPawn1().getSquare()) instanceof HomeSquare ||
				deck.getGrid(deck.getRedPlayer().getPawn1().getSquare()) instanceof SafetyZoneSquare) 
			{
				pawnsFor11[0] = false;
			}
			if((deck.getRedPlayer().getPawn2().getSquare() == -1)  ||
				deck.getGrid(deck.getRedPlayer().getPawn2().getSquare()) instanceof HomeSquare ||
				deck.getGrid(deck.getRedPlayer().getPawn2().getSquare()) instanceof SafetyZoneSquare) 
			{
				pawnsFor11[1] = false;
			}
			if((deck.getYellowPlayer().getPawn1().getSquare() == -1) ||
				deck.getGrid(deck.getYellowPlayer().getPawn1().getSquare()) instanceof HomeSquare ||
				deck.getGrid(deck.getYellowPlayer().getPawn1().getSquare()) instanceof SafetyZoneSquare) 
			{
				pawnsFor11[2] = false;
			}
			if((deck.getYellowPlayer().getPawn2().getSquare() == -1)  ||
				deck.getGrid(deck.getYellowPlayer().getPawn2().getSquare()) instanceof HomeSquare ||
				deck.getGrid(deck.getYellowPlayer().getPawn2().getSquare()) instanceof SafetyZoneSquare) 
			{
				pawnsFor11[3] = false;
			}
			OptionDialog option = new OptionDialog(11, pawnsFor11[0], pawnsFor11[1], 
					pawnsFor11[2], pawnsFor11[3]);
			while(option.choice() == null) {
				option = new OptionDialog(11, pawnsFor11[0], pawnsFor11[1], 
						pawnsFor11[2], pawnsFor11[3]);
			}
            playerChoice = option.choice();
            deck.setOption(playerChoice);
		}
		
		if(currentCard.getValue() == 13) {
			
			boolean[] pawnsForSorry = {false, false , false , false}; ;
			if(deck.getWhoPlays().getColor() == "red") {
				pawnsForSorry[0] = false;
				pawnsForSorry[1] = false;
				pawnsForSorry[2] = true;
				pawnsForSorry[3] = true;
				if(deck.getWhoPlays().getPawn1().getSquare() == -1) {
					pawnsForSorry[0] = true;
				}
				if(deck.getWhoPlays().getPawn2().getSquare() == -1) {
					pawnsForSorry[1] = true;
				}
				if((deck.getYellowPlayer().getPawn1().getSquare() == -1) ||
					deck.getGrid(deck.getYellowPlayer().getPawn1().getSquare()) instanceof HomeSquare ||
					deck.getGrid(deck.getYellowPlayer().getPawn1().getSquare()) instanceof SafetyZoneSquare) 
				{
					pawnsForSorry[2] = false;
				}
				if((deck.getYellowPlayer().getPawn2().getSquare() == -1)  ||
					deck.getGrid(deck.getYellowPlayer().getPawn2().getSquare()) instanceof HomeSquare ||
					deck.getGrid(deck.getYellowPlayer().getPawn2().getSquare()) instanceof SafetyZoneSquare) 
				{
					pawnsForSorry[3] = false;
				}
			}
			if(deck.getWhoPlays().getColor() == "yellow") {
				pawnsForSorry[0] = true;
				pawnsForSorry[1] = true;
				pawnsForSorry[2] = false;
				pawnsForSorry[3] = false;

				if(deck.getWhoPlays().getPawn1().getSquare() == -1) {
					pawnsForSorry[2] = true;
				}
				if(deck.getWhoPlays().getPawn2().getSquare() == -1) {
					pawnsForSorry[3] = true;
				}
				if((deck.getRedPlayer().getPawn1().getSquare() == -1) ||
					deck.getGrid(deck.getRedPlayer().getPawn1().getSquare()) instanceof HomeSquare ||
					deck.getGrid(deck.getRedPlayer().getPawn1().getSquare()) instanceof SafetyZoneSquare) 
				{
					pawnsForSorry[0] = false;
				}
				if((deck.getRedPlayer().getPawn2().getSquare() == -1)  ||
					deck.getGrid(deck.getRedPlayer().getPawn2().getSquare()) instanceof HomeSquare ||
					deck.getGrid(deck.getRedPlayer().getPawn2().getSquare()) instanceof SafetyZoneSquare) 
				{
					pawnsForSorry[1] = false;
				}
			}
			OptionDialog option = new OptionDialog(13, pawnsForSorry[0], pawnsForSorry[1], 
					pawnsForSorry[2], pawnsForSorry[3],deck.getWhoPlays().getColor());
			if((pawnsForSorry[0] == true && pawnsForSorry[2] == true) ||
			   (pawnsForSorry[0] == true && pawnsForSorry[3] == true) ||
			   (pawnsForSorry[1] == true && pawnsForSorry[2] == true) ||
			   (pawnsForSorry[1] == true && pawnsForSorry[3] == true)){
				while(option.choice() == null) {
					option = new OptionDialog(13, pawnsForSorry[0], pawnsForSorry[1], 
						pawnsForSorry[2], pawnsForSorry[3],deck.getWhoPlays().getColor());
				}
			}
			playerChoice = option.choice();
	        deck.setOption(playerChoice);
			

		}
		
	}
}

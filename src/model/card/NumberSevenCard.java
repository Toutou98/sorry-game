package model.card;
import model.deck.*;


public class NumberSevenCard extends NumberCard{
	
	
	/**
	 * Constructor 
	 * @post  Creates NumberSevenCard with value 7 and description
	 */
	public NumberSevenCard() {
		setValue(7);
		setDescription("Move a pawn 7 squares or split 7 squares to 2 pawns");
	}
	
	/**
	 * Overrides movePawn to do the special movement of Seven
	 * @post pawn moves if possible else it doesn't
	 * @return 1 if one pawn moved else 2
	 * @param b a Board
	 */
	public int movePawn (Deck b) {
		boolean pawn1 = false,pawn2 = false;
		if(b.getOption() == "7+0") {
			Card card7 = new SimpleNumberCard(7,"Move 7 squares");
			pawn1 = card7.movePawn(b.getWhoPlays().getPawn1() , b);
		}else if(b.getOption() == "6+1") {
			Card card6 = new SimpleNumberCard(6,"Move 6 squares");
			pawn1 = card6.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card1 = new SimpleNumberCard(1,"Move 1 square1");
			pawn2 = card1.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "5+2") {
			Card card5 = new SimpleNumberCard(5,"Move 5 squares");
			pawn1 = card5.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card2 = new SimpleNumberCard(2,"Move 2 square1");
			pawn2 = card2.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "4+3") {
			Card card4 = new SimpleNumberCard(4,"Move 4 squares");
			pawn1 = card4.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card3 = new SimpleNumberCard(3,"Move 3 square1");
			pawn2 = card3.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "3+4") {
			Card card3 = new SimpleNumberCard(3,"Move 3 square1");
			pawn1 = card3.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card4 = new SimpleNumberCard(4,"Move 4 squares");
			pawn2 = card4.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "2+5") {
			Card card2 = new SimpleNumberCard(2,"Move 2 square1");
			pawn1 = card2.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card5 = new SimpleNumberCard(5,"Move 5 squares");
			pawn2 = card5.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "1+6") {
			Card card1 = new SimpleNumberCard(1,"Move 1 square1");
			pawn1 = card1.movePawn(b.getWhoPlays().getPawn1() , b);
			Card card6 = new SimpleNumberCard(6,"Move 6 squares");
			pawn2 = card6.movePawn(b.getWhoPlays().getPawn2() , b);
		}else if(b.getOption() == "0+7") {
			Card card7 = new SimpleNumberCard(7,"Move 7 squares");
			pawn1 = card7.movePawn(b.getWhoPlays().getPawn2() , b);
		}
		if(pawn1 && pawn2) {
			return 2;
		}else if(pawn1 || pawn2 ) {
			return 1;
		}
		return 0;
	}
	
}

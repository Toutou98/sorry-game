package view;
import java.net.URL;
import javax.swing.*;

/**
 * Class to let the player choose his action depending on which card he drew
 * @author miket
 *
 */
public class OptionDialog {
	private String s ;
	private URL imageURL;
	private ClassLoader cldr = this.getClass().getClassLoader();  
	/**
	 * <b>constructor</b>: Creates a new Option Dialog Window for cards 7 AND 10
	 * @post Creates a new Option Dialog Window
	 * starting a new Option Dialog
	 */
	public OptionDialog(int value){
		JFrame parent = new JFrame();
		if(value == 7) {
	         imageURL= cldr.getResource("images/cards/card7.png");
			Object[] possibilities = {"7+0", "6+1", "5+2","4+3","3+4","2+5","1+6","0+7"};
			s = (String)JOptionPane.showInputDialog(
                    parent,"Choose the move of the Pawn 1 and Pawn 2:\n" , "Card 7 Option",
                    JOptionPane.PLAIN_MESSAGE , new ImageIcon(imageURL) , possibilities , "2");
		}
		if(value == 10) {
			imageURL= cldr.getResource("images/cards/card10.png");
			Object[] possibilities = {"Move 10 forward" , "Move 1 backward"};
			s = (String)JOptionPane.showInputDialog(
                    parent,"Choose what move you want to make:\n" , "Card 10 Option",
                    JOptionPane.PLAIN_MESSAGE , new ImageIcon(imageURL) , possibilities , "2");
		}
		
		
	}
	/**
	 * <b>constructor</b>: Creates a new Option Dialog Window for card 11
	 * @post Creates a new Option Dialog Window
	 * starting a new Option Dialog
	 */
	public OptionDialog(int value ,boolean redPawn1,boolean redPawn2,
			boolean yellowPawn1 , boolean yellowPawn2 ) {
		//System.out.println("red1" + redPawn1+ "\nred2" + redPawn2+ "\nyellow1" + yellowPawn1+ "\nyellow2" + yellowPawn2);
		JFrame parent = new JFrame();
		if(value == 11) {
			imageURL= cldr.getResource("images/cards/card11.png");
			Object[] possibilities = {"Move 11 squares forward",null , null , null , null};
			if(redPawn1 == true) {
				if(yellowPawn1 == true) 
					possibilities[1] = "Switch redPawn1 with yellowPawn1";
				if(yellowPawn2 == true)
					possibilities[2] = "Switch redPawn1 with yellowPawn2";
			}
			if(redPawn2 == true) {
				if(yellowPawn1 == true) 
					possibilities[3] = "Switch redPawn2 with yellowPawn1";
				if(yellowPawn2 == true) 
					possibilities[4] = "Switch redPawn2 with yellowPawn2";
			}
			s = (String)JOptionPane.showInputDialog(
                    parent,"Choose what move you want to make:\n" , "Card 11 Option",
                    JOptionPane.PLAIN_MESSAGE , new ImageIcon(imageURL) , possibilities , "2");
		}
		
		
	}
	
	/**
	 * <b>constructor</b>: Creates a new Option Dialog Window for card Sorry
	 * @post Creates a new Option Dialog Window
	 * starting a new Option Dialog
	 */
	public OptionDialog(int value ,boolean redPawn1,boolean redPawn2,
			boolean yellowPawn1 , boolean yellowPawn2 ,String color) {
		//System.out.println("red1" + redPawn1+ "\nred2" + redPawn2+ "\nyellow1" + yellowPawn1+ "\nyellow2" + yellowPawn2);
		JFrame parent = new JFrame();
		if(value == 13) {
			imageURL= cldr.getResource("images/cards/cardSorry.png");
			Object[] possibilities = {null , null , null , null};
			if(color == "red") {
				if(redPawn1 == true) {
					if(yellowPawn1 == true) 
						possibilities[0] = "Move redPawn1 to yellowPawn1";
					if(yellowPawn2 == true)
						possibilities[1] = "Move redPawn1 to yellowPawn2";
				}
				if(redPawn2 == true) {
					if(yellowPawn1 == true) 
						possibilities[2] = "Move redPawn2 to yellowPawn1";
					if(yellowPawn2 == true) 
						possibilities[3] = "Move redPawn2 to yellowPawn2";
				}
			}else if(color == "yellow") {
				if(yellowPawn1 == true) {
					if(redPawn1 == true) 
						possibilities[0] = "Move yellowPawn1 to redPawn1";
					if(redPawn2 == true)
						possibilities[1] = "Move yellowPawn1 to redPawn2";
				}
				if(yellowPawn2 == true) {
					if(redPawn1 == true) 
						possibilities[2] = "Move yellowPawn2 to redPawn1";
					if(redPawn2 == true) 
						possibilities[3] = "Move yellowPawn2 to redPawn2";
				}
			}
			
				if(possibilities[0] == null && possibilities[1] == null &&
					possibilities[2] == null && possibilities[3] == null) {
					
					 JOptionPane.showMessageDialog(
		                parent,"Cannot make a legal move with card Sorry." );
					 s="cancel";
					 
				}else {
					s = (String)JOptionPane.showInputDialog(
                    parent,"Choose what move you want to make:\n" , "Card Sorry Option",
                    JOptionPane.PLAIN_MESSAGE , new ImageIcon(imageURL) , possibilities , "2");
				}
		}
		
	}
	/**
	 * <b>accessor(selector)</b>:Returns the choice of a player 
	 * 
	 * @post Returns the choice of a player
	 *
	 * @return the choice of the player
	 */
	public String choice(){
	        return s;
	}
}


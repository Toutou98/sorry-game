package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;

public class GUI extends JFrame {
	
	private Controller 			game;
	private myDesktopPane 			panel;
	private URL 				imageURL, soundURL;
    	private JButton 			FoldButton;
    	private JButton 			drawcard;
    	private JLabel				text1,text2;
    	private ClassLoader 			cldr;  
   	private JDesktopPane 			blueBack;
	private JTextArea			textArea,winnerLabel;
   	private JButton[] 			pawns;
   	private JLabel				sorryImage,musicIcon;
    	private JLabel[]			squares;
    	private JLabel				yellowHome , redHome , yellowStart , redStart;
    	private int 				counterX = 0 , counterY = 0;
    	private String				turn,cardsLeft,description;
    	private JLabel 				currentCard;
   	private JLabel				message10;
   	private int				card10 = 0;
    	private JFrame				parent;
    	private JSlider				volumeSlider;
    	private Clip 				clipMusic;

	 /**
		 * <b>constructor</b>: Creates a new Window and initializes some buttons and panels
		 * <b>postconditions</b>: Creates a new Window and initializes some buttons and panels
		 * starting a new game.
		 */
	public GUI() {
		
		FoldButton 	= new JButton("Fold Button");
		drawcard    = new JButton();
		text1 		= new JLabel("Receive Card");
		text2 		= new JLabel("Current Card");
		textArea	= new JTextArea();
		sorryImage 	= new JLabel();
		squares		= new JLabel[70];
		pawns		= new JButton[4];
		cardsLeft 	= "Cards Left: ";
		description = "";
		game		= new Controller();
		currentCard = new JLabel();
		winnerLabel = new JTextArea("Winner");
		message10	= new JLabel();
		musicIcon	= new JLabel();
		
		
        cldr = getClass().getClassLoader();
        this.setResizable(false);
		this.setSize(new Dimension(1024,768));
        this.setTitle("Sorry! Game"); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        blueBack = new JDesktopPane();
        initComponents();

	}
	
	/**
	 * <b>transformer(mutative)</b>: initializes some buttons and labels <br />
	 * <p><b>Postcondition:</b> initializes some buttons and labels </p>
	 *
     */
    private void initComponents() {
    	
    	//placing the background picture
    	URL imageURL = cldr.getResource("images/background.png"); //image
        Image image = new ImageIcon(imageURL).getImage();
        panel = new myDesktopPane(image);
        
    	

        winnerLabel.setBounds(190, 320, 350, 102);
        winnerLabel.setVisible(false);
        winnerLabel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        winnerLabel.setFont(winnerLabel.getFont().deriveFont(Font.BOLD,14f));
        winnerLabel.setLineWrap(true);
        winnerLabel.setEditable(false);
        
        
        message10.setBounds(190, 320, 350, 102);

        //placing the Fold Button
        FoldButton.setBounds(810, 400 , 180 , 50);
        FoldButton.addActionListener(new FoldListener());
        FoldButton.setBackground(Color.red);
        FoldButton.setEnabled(false);
        
        //placing the draw card button
        drawcard.setBounds(780,200, 100, 153);
        imageURL= cldr.getResource("images/cards/backCard.png");
        drawcard.setIcon(new ImageIcon(imageURL));
        drawcard.setDisabledIcon(new ImageIcon(imageURL));
        drawcard.addActionListener(new CardListener());
        
        //Placing the current card
        currentCard.setBounds(900,200, 100, 153);
        currentCard.setVisible(false);
        
        //placing the Receive card and Current card texts
        text1.setBounds(795,375,80,20);
        text2.setBounds(920,375,80,20);
        
        //placing the sorryImage logo
        sorryImage.setBounds(190, 320, 350, 102);
        imageURL= cldr.getResource("images/sorryImage.png");
        sorryImage.setIcon(new ImageIcon(imageURL));
        sorryImage.setVisible(true);
        
        //creating all squares(special squares get images below)
        for(int i = 0 ; i < 70; i++) {
        	squares[i] = new JLabel();
        	squares[i].setBackground(Color.white);
        	squares[i].setVisible(true);
        	squares[i].setOpaque(true);
        	squares[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        	//System.out.println(counterX + " " + counterY);
            if( i >= 0 && i < 15) {squares[i].setBounds(counterX,counterY,48,48) ; counterX = counterX + 48;}
        	if( i >= 15 && i < 30) {squares[i].setBounds(counterX,counterY,48,48) ; counterY = counterY + 48;}
        	if( i >= 30 && i < 45) {squares[i].setBounds(counterX,counterY,48,48) ; counterX = counterX - 48;}
        	if( i >= 45 && i <= 59) {squares[i].setBounds(counterX,counterY,48,48) ; counterY = counterY - 48;}
        	if( i > 59 && i < 65) {
        		counterX = 96; 
        		counterY = counterY + 48;
        		squares[i].setBackground(Color.red);
        		squares[i].setBounds(counterX,counterY,48,48);
        	}else if( i >= 65 && i < 70 ){
        		if(i == 65) {counterY = 720;}
        		counterX = 624;
        		counterY = counterY - 48;
        		squares[i].setBackground(Color.yellow);
        		squares[i].setBounds(counterX,counterY,48,48);
        	}
        		
        }
        
        //Setting images to special squares
        
        imageURL= cldr.getResource("images/slides/redSlideStart.png");
        squares[1].setIcon(new ImageIcon(imageURL));
        squares[9].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/redSlideMedium.png");
        squares[2].setIcon(new ImageIcon(imageURL));
        squares[3].setIcon(new ImageIcon(imageURL));
        squares[10].setIcon(new ImageIcon(imageURL));
        squares[11].setIcon(new ImageIcon(imageURL));
        squares[12].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/redSlideEnd.png");
        squares[4].setIcon(new ImageIcon(imageURL));
        squares[13].setIcon(new ImageIcon(imageURL));
        
        imageURL= cldr.getResource("images/slides/blueSlideStart.png");
        squares[16].setIcon(new ImageIcon(imageURL));
        squares[24].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/blueSlideMedium.png");
        squares[17].setIcon(new ImageIcon(imageURL));
        squares[18].setIcon(new ImageIcon(imageURL));
        squares[25].setIcon(new ImageIcon(imageURL));
        squares[26].setIcon(new ImageIcon(imageURL));
        squares[27].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/blueSlideEnd.png");
        squares[19].setIcon(new ImageIcon(imageURL));
        squares[28].setIcon(new ImageIcon(imageURL));
        
        imageURL= cldr.getResource("images/slides/yellowSlideStart.png");
        squares[31].setIcon(new ImageIcon(imageURL));
        squares[39].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/yellowSlideMedium.png");
        squares[32].setIcon(new ImageIcon(imageURL));
        squares[33].setIcon(new ImageIcon(imageURL));
        squares[40].setIcon(new ImageIcon(imageURL));
        squares[41].setIcon(new ImageIcon(imageURL));
        squares[42].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/yellowSlideEnd.png");
        squares[34].setIcon(new ImageIcon(imageURL));
        squares[43].setIcon(new ImageIcon(imageURL));

        imageURL= cldr.getResource("images/slides/greenSlideStart.png");
        squares[46].setIcon(new ImageIcon(imageURL));
        squares[54].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/greenSlideMedium.png");
        squares[47].setIcon(new ImageIcon(imageURL));
        squares[48].setIcon(new ImageIcon(imageURL));
        squares[55].setIcon(new ImageIcon(imageURL));
        squares[56].setIcon(new ImageIcon(imageURL));
        squares[57].setIcon(new ImageIcon(imageURL));
        imageURL= cldr.getResource("images/slides/greenSlideEnd.png");
        squares[49].setIcon(new ImageIcon(imageURL));
        squares[58].setIcon(new ImageIcon(imageURL));

        //Placing Home and Start areas
        redHome = new JLabel("Home");
        redStart = new JLabel("Start");
        yellowHome = new JLabel("Home");
        yellowStart = new JLabel("Start");

        redHome.setBackground(Color.white);
        redStart.setBackground(Color.white);
        yellowHome.setBackground(Color.white);
        yellowStart.setBackground(Color.white);
        
        redHome.setOpaque(true);
        redHome.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
        redHome.setBounds(72, 288, 100, 100);
        redHome.setHorizontalAlignment(JLabel.CENTER);
        redHome.setVerticalAlignment(JLabel.BOTTOM);
        redHome.setFont(redHome.getFont().deriveFont(Font.BOLD,14f));

        redStart.setOpaque(true);
        redStart.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
        redStart.setBounds(170, 48, 100, 100);
        redStart.setHorizontalAlignment(JLabel.CENTER);
        redStart.setVerticalAlignment(JLabel.BOTTOM);
        redStart.setFont(redStart.getFont().deriveFont(Font.BOLD,14f));

        yellowHome.setOpaque(true);
        yellowHome.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow));
        yellowHome.setBounds(600, 380, 100, 100);
        yellowHome.setHorizontalAlignment(JLabel.CENTER);
        yellowHome.setVerticalAlignment(JLabel.TOP);
        yellowHome.setFont(yellowHome.getFont().deriveFont(Font.BOLD,14f));

        yellowStart.setOpaque(true);
        yellowStart.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow));
        yellowStart.setBounds(500, 620, 100, 100);
        yellowStart.setHorizontalAlignment(JLabel.CENTER);
        yellowStart.setVerticalAlignment(JLabel.TOP);
        yellowStart.setFont(yellowStart.getFont().deriveFont(Font.BOLD,14f));

		//Placing the background of the board inside the squares
        blueBack.setBounds(0, 0, 768, 768);
        blueBack.setBackground(Color.cyan);
        blueBack.add(sorryImage);

        //placing the text area(info box)
        turn = "Turn : " + game.getWhoPlays().getColor() +" player";
        cardsLeft = "Cards Left: " + game.getDeck().getStackSize();
        
        textArea.setBounds(780,475,225,175);
        textArea.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        textArea.setFont(textArea.getFont().deriveFont(Font.BOLD,14f));
        textArea.setText("INFO BOX \n\n" + turn + "\n" + cardsLeft + "\n\n" + description);
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        //Placing Pawns
        pawns[0] = new JButton();
        imageURL= cldr.getResource("images/pawns/redPawn1.png");
        pawns[0].setBounds(172, 50, 47, 47);
        pawns[0].setIcon(new ImageIcon(imageURL));
        pawns[0].setDisabledIcon(new ImageIcon(imageURL));
        pawns[0].addActionListener(new PawnListener());

        pawns[1] = new JButton();
        imageURL= cldr.getResource("images/pawns/redPawn2.png");
        pawns[1].setBounds(220,50, 47, 47);
        pawns[1].setIcon(new ImageIcon(imageURL));
        pawns[1].setDisabledIcon(new ImageIcon(imageURL));
        pawns[1].addActionListener(new PawnListener());

        pawns[2] = new JButton();
        imageURL= cldr.getResource("images/pawns/yellowPawn1.png");
        pawns[2].setBounds(502,670, 47, 47);
        pawns[2].setIcon(new ImageIcon(imageURL));
        pawns[2].setDisabledIcon(new ImageIcon(imageURL));
        pawns[2].addActionListener(new PawnListener());

        pawns[3] = new JButton();
        imageURL= cldr.getResource("images/pawns/yellowPawn2.png");
        pawns[3].setBounds(550,670, 47, 47);
        pawns[3].setIcon(new ImageIcon(imageURL));
        pawns[3].setDisabledIcon(new ImageIcon(imageURL));
        pawns[3].addActionListener(new PawnListener());
        
        pawns[0].setEnabled(false);
		pawns[1].setEnabled(false);
		pawns[2].setEnabled(false);
		pawns[3].setEnabled(false);
        
		volumeSlider = new JSlider(JSlider.HORIZONTAL,0,50,25);
		volumeSlider.setBounds(835,10,150,50);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(true);
		volumeSlider.setMajorTickSpacing(10);
		volumeSlider.setVisible(true);
		volumeSlider.addChangeListener(new VolumeListener());
		
		musicIcon.setBounds(775, 10, 50, 50);
	    imageURL= cldr.getResource("images/music.png");
	    musicIcon.setIcon(new ImageIcon(imageURL));
	    musicIcon.setVisible(true);
		
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent
                (panel, GroupLayout.PREFERRED_SIZE, 1024, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent
                (panel, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE));
        
        pack();
        
        
        //Adding all components to panel and paint
        for(int i = 0 ; i < 70; i++) {
        	panel.add(squares[i]);
        	if(i < 4) {panel.add(pawns[i]);}
        }
        
        panel.add(musicIcon);
        panel.add(volumeSlider);
        panel.add(currentCard);
        panel.add(redHome);
        panel.add(redStart);
        panel.add(yellowHome);
        panel.add(yellowStart);
        panel.add(message10);
        panel.add(winnerLabel);
        panel.add(sorryImage);
        panel.add(blueBack);
        panel.add(drawcard);
        panel.add(FoldButton);
        panel.add(text1);
        panel.add(text2);
        panel.add(textArea);
        
        Graphics g1 = panel.getGraphics();
        panel.paintComponent(g1);
        panel.repaint();
        
        try {
    		soundURL = cldr.getResource("sounds/CREAM.wav");
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
    		clipMusic = AudioSystem.getClip();
    		clipMusic.open(audioInputStream);
    		setVol(volumeSlider.getValue(),clipMusic);
    		clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
    	}catch(Exception ex) {
    		System.out.println("Sound was not found");
    		ex.printStackTrace();
    	}
        
    }
    

    //a class that sets the background of the panel
    public class myDesktopPane extends JDesktopPane{
    	
    	private Image image = null;
    	
    	public myDesktopPane(Image img) {
    		image=img;
    	}
    	
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.drawImage(image,0,0,this);

    	}
    }
    
  //Class to do action when the card button is clicked
    private class CardListener implements ActionListener{
    	/**
    	 * <b>transformer(mutative)</b>: doing some action after Card button has been clicked<br />
         * @post doing some action after Card button has been clicked</p>
    	 */
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    		if(game.checkWinner()) {
				winnerLabel.setText("The winner of the game is the " + game.getWinner() +" player");
				winnerLabel.setVisible(true);
		        textArea.setText("GAME OVER\n\n" + game.getWinner());
				FoldButton.setEnabled(false);
	    		drawcard.setEnabled(false);
	    		pawns[0].setEnabled(false);
				pawns[1].setEnabled(false);
				pawns[2].setEnabled(false);
				pawns[3].setEnabled(false);
				return;
			}
    		playSound("draw.wav",volumeSlider.getValue());
    		game.drawCard();
    		FoldButton.setEnabled(false);
    		drawcard.setEnabled(false);
	        description = game.getDeck().getCurrentCard().getDescription();
    		turn = "Turn : " + game.getWhoPlays().getColor() +" player";
            cardsLeft = "Cards Left: " + game.getDeck().getStackSize();
	        textArea.setText("INFO BOX\n\n"+turn + "\n" + cardsLeft + "\n\n" + description);
	        panel.repaint();
    		if(game.getWhoPlays().getColor() == "red") {
    			pawns[0].setEnabled(true);
    			pawns[1].setEnabled(true);
    		}else {
    			pawns[2].setEnabled(true);
    			pawns[3].setEnabled(true);
    		}
	        currentCard.setVisible(true);
	        
	        if(!game.getPawns(0).getActive()) {
	        	pawns[0].setEnabled(false);
		        pawns[0].setBounds(73,288, 47, 47);
	        }
			if(!game.getPawns(1).getActive()) {
				pawns[1].setEnabled(false);
		        pawns[1].setBounds(121,288, 47, 47);
			}
			if(!game.getPawns(2).getActive()) {
				pawns[2].setEnabled(false);
		        pawns[2].setBounds(601,420, 47, 47);
			}
			if(!game.getPawns(3).getActive()) {
				pawns[3].setEnabled(false);
		        pawns[3].setBounds(649,420, 47, 47);
			}
    		if(game.getDeck().getCurrentCard().getValue() == 1) {
    			imageURL= cldr.getResource("images/cards/card1.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();

    		}else if(game.getDeck().getCurrentCard().getValue() == 2){
    			imageURL= cldr.getResource("images/cards/card2.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();

    		}else if(game.getDeck().getCurrentCard().getValue() == 3){
    			imageURL= cldr.getResource("images/cards/card3.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	    
    		}else if(game.getDeck().getCurrentCard().getValue() == -4){
    			imageURL= cldr.getResource("images/cards/card4.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	     
    		}else if(game.getDeck().getCurrentCard().getValue() == 5){
    			imageURL= cldr.getResource("images/cards/card5.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	      
    		}else if(game.getDeck().getCurrentCard().getValue() == 7){
    			int moves = 0;
    			imageURL= cldr.getResource("images/cards/card7.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	        game.doChoice();
    	        moves = game.getCurrentCard().movePawn(game.getDeck());
    	        pawns[0].setBounds(game.getPawns(0).getPosX(),game.getPawns(0).getPosY(),48,48);
    			pawns[1].setBounds(game.getPawns(1).getPosX(),game.getPawns(1).getPosY(),48,48);
    			pawns[2].setBounds(game.getPawns(2).getPosX(),game.getPawns(2).getPosY(),48,48);
    			pawns[3].setBounds(game.getPawns(3).getPosX(),game.getPawns(3).getPosY(),48,48);
    			if(game.checkWinner()) {
    		        textArea.setText("GAME OVER\n\n" + game.getWinner());
    				FoldButton.setEnabled(false);
    	    		drawcard.setEnabled(false);
    	    		pawns[0].setEnabled(false);
    				pawns[1].setEnabled(false);
    				pawns[2].setEnabled(false);
    				pawns[3].setEnabled(false);
    			}
    			if(moves == 2) {
		    		playSound("pawn.wav",volumeSlider.getValue());
		    		playSound("pawn.wav",volumeSlider.getValue());
    			}else if(moves == 1) {
		    		playSound("pawn.wav",volumeSlider.getValue());
    			}
    			if(game.getDeck().getdidSlide() == 1) {
    				playSound("slide.wav",volumeSlider.getValue());
    				game.getDeck().setdidSlide(0);
    			}
    			FoldButton.setEnabled(true);
    			FoldButton.doClick();
    			drawcard.setEnabled(true);
    			drawcard.doClick();
    	        panel.repaint();
    			
    		}else if(game.getDeck().getCurrentCard().getValue() == 8){
    			imageURL= cldr.getResource("images/cards/card8.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	        
    		}else if(game.getDeck().getCurrentCard().getValue() == 10){
    			imageURL= cldr.getResource("images/cards/card10.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	        game.doChoice();
    	        
    		}else if(game.getDeck().getCurrentCard().getValue() == 11){
    			imageURL= cldr.getResource("images/cards/card11.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));    	        
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();    	        
    	        game.doChoice();
    	        if(game.getDeck().getOption() != "Move 11 squares forward") {
    	        	game.getCurrentCard().movePawn(game.getDeck());
    	        	pawns[0].setBounds(game.getPawns(0).getPosX(),game.getPawns(0).getPosY(),48,48);
        			pawns[1].setBounds(game.getPawns(1).getPosX(),game.getPawns(1).getPosY(),48,48);
        			pawns[2].setBounds(game.getPawns(2).getPosX(),game.getPawns(2).getPosY(),48,48);
        			pawns[3].setBounds(game.getPawns(3).getPosX(),game.getPawns(3).getPosY(),48,48);
		    		playSound("pawn.wav",volumeSlider.getValue());
		    		playSound("pawn.wav",volumeSlider.getValue());
        			FoldButton.setEnabled(true);
        			FoldButton.doClick();
        			drawcard.setEnabled(true);
        			drawcard.doClick();
    	        }
    	        if(game.getDeck().getdidSlide() == 1) {
    				playSound("slide.wav",volumeSlider.getValue());
    				game.getDeck().setdidSlide(0);
    	        }
    	        panel.repaint();

    		}else if(game.getDeck().getCurrentCard().getValue() == 12){
    			imageURL= cldr.getResource("images/cards/card12.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	        
    		}else if(game.getDeck().getCurrentCard().getValue() == 13){
    			imageURL= cldr.getResource("images/cards/cardSorry.png");
    	        currentCard.setIcon(new ImageIcon(imageURL));
    	        description = game.getDeck().getCurrentCard().getDescription();
    	        panel.repaint();
    	        game.doChoice();
    	        if(game.getDeck().getOption() != "cancel") {
    	        	game.getCurrentCard().movePawn(game.getDeck());
    	        	pawns[0].setBounds(game.getPawns(0).getPosX(),game.getPawns(0).getPosY(),48,48);
    	        	pawns[1].setBounds(game.getPawns(1).getPosX(),game.getPawns(1).getPosY(),48,48);
    	        	pawns[2].setBounds(game.getPawns(2).getPosX(),game.getPawns(2).getPosY(),48,48);
    	        	pawns[3].setBounds(game.getPawns(3).getPosX(),game.getPawns(3).getPosY(),48,48);
		    		playSound("pawn.wav",volumeSlider.getValue());
		    		playSound("pawn.wav",volumeSlider.getValue());
		    		FoldButton.setEnabled(true);
    				FoldButton.doClick();
    				drawcard.doClick();
    	        }else if(game.getDeck().getOption() == "cancel") {
    	        	FoldButton.setEnabled(true);
    	        	FoldButton.doClick();
    	        	drawcard.doClick();
    	        }
    	        if(game.getDeck().getdidSlide() == 1) {
    				playSound("slide.wav",volumeSlider.getValue());
    				game.getDeck().setdidSlide(0);
    			}
    	        panel.repaint();

    		}
    		
	        panel.repaint();
	       
	        

    	}
	
    }
    //Class to do action when fold button is clicked
    private class FoldListener implements ActionListener{
    	/**
    	 * <b>transformer(mutative)</b>: doing some action after Fold button has been clicked<br />
         * @post doing some action after Fold button has been clicked</p>
    	 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(game.getWhoPlays() == game.getDeck().getYellowPlayer()) {
				game.setWhoPlays(game.getDeck().getRedPlayer());		
			}else {game.setWhoPlays(game.getDeck().getYellowPlayer());}
			pawns[0].setEnabled(false);
			pawns[1].setEnabled(false);
			pawns[2].setEnabled(false);
			pawns[3].setEnabled(false);
			FoldButton.setEnabled(false);
			drawcard.setEnabled(true);
			card10 = 0;
			turn = "Turn : " + game.getWhoPlays().getColor() +" player";
            cardsLeft = "Cards Left: " + game.getDeck().getStackSize();
	        textArea.setText("INFO BOX\n\n"+turn + "\n" + cardsLeft + "\n\n" + description);
			panel.repaint();
		}
    	
    }
    //Class to do action when a pawn is clicked
    private class PawnListener implements ActionListener{
    	/**
    	 * <b>transformer(mutative)</b>: doing some action after Pawn button has been clicked<br />
         * @post doing some action after Pawn button has been clicked</p>
    	 */
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.repaint();
			drawcard.setEnabled(false);
			
			if(game.getWhoPlays().getColor() == "red") {
				pawns[2].setEnabled(false);
				pawns[3].setEnabled(false);
				if(e.getSource() == pawns[0]) {
					game.getDeck().getCurrentCard();
					game.setPickedPawn(0);
					if(game.getCurrentCard().movePawn(game.getPickedPawn(),game.getDeck())) {
						pawns[0].setBounds(game.getPickedPawn().getPosX(),game.getPickedPawn().getPosY(),48,48);
						FoldButton.setEnabled(true);	
			    		playSound("pawn.wav",volumeSlider.getValue());
						panel.repaint();
					}else {
						pawns[0].setEnabled(false);
					}
					//System.out.println(pawns[0].getBounds());
				}
				if(e.getSource() == pawns[1]){
					game.getDeck().getCurrentCard();
					game.setPickedPawn(1);
					if(game.getCurrentCard().movePawn(game.getPickedPawn(),game.getDeck())) {
						pawns[1].setBounds(game.getPickedPawn().getPosX(),game.getPickedPawn().getPosY(),48,48);
						FoldButton.setEnabled(true);
			    		playSound("pawn.wav",volumeSlider.getValue());
						panel.repaint();
					}else {
						pawns[1].setEnabled(false);
					}
					//System.out.println(pawns[1].getBounds());

				}
				if(!pawns[0].isEnabled() && !pawns[1].isEnabled()) {
					FoldButton.setEnabled(true);
				}
			}else if(game.getWhoPlays().getColor() == "yellow") {
				pawns[0].setEnabled(false);
				pawns[1].setEnabled(false);
				if(e.getSource() == pawns[2] ){
					game.getDeck().getCurrentCard();
					game.setPickedPawn(2);
					if(game.getCurrentCard().movePawn(game.getPickedPawn(),game.getDeck())) {
						pawns[2].setBounds(game.getPickedPawn().getPosX(),game.getPickedPawn().getPosY(),48,48);
						FoldButton.setEnabled(true);
			    		playSound("pawn.wav",volumeSlider.getValue());
						panel.repaint();
					}else {
						pawns[2].setEnabled(false);
					}
					//System.out.println(pawns[2].getBounds());
				}
				if(e.getSource() == pawns[3]) {
					game.getDeck().getCurrentCard();
					game.setPickedPawn(3);
					if(game.getCurrentCard().movePawn(game.getPickedPawn(),game.getDeck())) {
						pawns[3].setBounds(game.getPickedPawn().getPosX(),game.getPickedPawn().getPosY(),48,48);
						FoldButton.setEnabled(true);
			    		playSound("pawn.wav",volumeSlider.getValue());
						panel.repaint();
					}else {
						pawns[3].setEnabled(false);
					}
					//System.out.println(pawns[3].getBounds());
				}
				if(!pawns[2].isEnabled() && !pawns[3].isEnabled()) {
					FoldButton.setEnabled(true);
				}
			}
			pawns[0].setBounds(game.getPawns(0).getPosX(),game.getPawns(0).getPosY(),48,48);
			pawns[1].setBounds(game.getPawns(1).getPosX(),game.getPawns(1).getPosY(),48,48);
			pawns[2].setBounds(game.getPawns(2).getPosX(),game.getPawns(2).getPosY(),48,48);
			pawns[3].setBounds(game.getPawns(3).getPosX(),game.getPawns(3).getPosY(),48,48);
			//System.out.println(game.getDeck().getdidSlide());
			if(game.getDeck().getdidSlide() == 1) {
				playSound("slide.wav",volumeSlider.getValue());
				game.getDeck().setdidSlide(0);
			}
			if(game.checkWinner()) {
				winnerLabel.setText("The winner of the game is the " + game.getWinner() +" player");
				winnerLabel.setVisible(true);
		        textArea.setText("GAME OVER\n\n" + game.getWinner());
				FoldButton.setEnabled(false);
	    		drawcard.setEnabled(false);
	    		pawns[0].setEnabled(false);
				pawns[1].setEnabled(false);
				pawns[2].setEnabled(false);
				pawns[3].setEnabled(false);
				return;
			}
			if(card10 == 1 && FoldButton.isEnabled()) {
				FoldButton.doClick();
				drawcard.doClick();
			}
			if(game.getDeck().getCurrentCard().getValue() == 2) {
				if(game.getWhoPlays() == game.getDeck().getYellowPlayer()) {
					game.setWhoPlays(game.getDeck().getRedPlayer());		
				}else {game.setWhoPlays(game.getDeck().getYellowPlayer());}
				drawcard.setEnabled(true);
				FoldButton.doClick();
				drawcard.doClick();
			}
			if(game.getDeck().getCurrentCard().getValue() == 10) {
				if(game.getDeck().getWhoPlays().getColor() == "red") {
					if((!pawns[0].isEnabled() && !pawns[1].isEnabled())) {
						if(game.getDeck().getOption() == "Move 10 forward" && card10 == 0) {
							card10 = 1;
							FoldButton.setEnabled(false);
							JOptionPane.showMessageDialog(
					                parent,"You couldn't move 10 squares forward.\nMove 1 square backward." );
							game.getDeck().setOption("Move 1 backward");
						}else if(game.getDeck().getOption() == "Move 1 backward" && card10 == 0) {
							card10 = 1;
							FoldButton.setEnabled(false);
							JOptionPane.showMessageDialog(
					                parent,"You couldn't move 1 square backward.\nMove 10 squares forward." );
							game.getDeck().setOption("Move 10 forward");
						}
						if(game.getDeck().getRedPlayer().getPawn1().getActive()) {
							System.out.println("test1");
							pawns[0].setEnabled(true);
						}
						if(game.getDeck().getRedPlayer().getPawn2().getActive()) {
							pawns[1].setEnabled(true);
							System.out.println("test2");
						}
					}
					
				}else if(game.getDeck().getWhoPlays().getColor() == "yellow") {
					if((!pawns[2].isEnabled() && !pawns[3].isEnabled())) {
						if(game.getDeck().getCurrentCard().getValue() == 10 && card10 == 0) {
							if(game.getDeck().getOption() == "Move 10 forward" && card10 == 0) {
								card10 = 1;
								FoldButton.setEnabled(false);
								JOptionPane.showMessageDialog(
						                parent,"You couldn't move 10 squares forward.\nMove 1 square backward." );
								game.getDeck().setOption("Move 1 backward");
							}else if(game.getDeck().getOption() == "Move 1 backward" && card10 == 0) {
								card10 = 1;
								FoldButton.setEnabled(false);
								JOptionPane.showMessageDialog(
						                parent,"You couldn't move 1 square backward.\nMove 10 squares forward." );
								game.getDeck().setOption("Move 10 forward");
							}
							if(game.getDeck().getYellowPlayer().getPawn1().getActive()) {
								pawns[2].setEnabled(true);
								System.out.println("test3");
							}
							if(game.getDeck().getYellowPlayer().getPawn2().getActive()) {
								System.out.println("test4");
								pawns[3].setEnabled(true);
							}
						}
					}
				}
			}
			if(FoldButton.isEnabled() && game.getDeck().getWhoPlays().getColor() == "red" &&
					(pawns[0].isEnabled() == true || pawns[1].isEnabled() == true)) {
				FoldButton.doClick();
				drawcard.doClick();
			}
			if(FoldButton.isEnabled() && game.getDeck().getWhoPlays().getColor() == "yellow" &&
					(pawns[2].isEnabled() == true || pawns[3].isEnabled() == true)) {
				FoldButton.doClick();
				drawcard.doClick();
			}
			
			
			if(FoldButton.isEnabled() && game.getCurrentCard().getValue() != 10) {
				FoldButton.doClick();
				drawcard.doClick();
			}else {
				turn = "Turn : " + game.getWhoPlays().getColor() +" player";
	            cardsLeft = "Cards Left: " + game.getDeck().getStackSize();
		        textArea.setText("INFO BOX\n\n"+turn + "\n" + cardsLeft + "\n\n" + description);
				panel.repaint();
			}
			
			
			pawns[0].setBounds(game.getPawns(0).getPosX(),game.getPawns(0).getPosY(),48,48);
			pawns[1].setBounds(game.getPawns(1).getPosX(),game.getPawns(1).getPosY(),48,48);
			pawns[2].setBounds(game.getPawns(2).getPosX(),game.getPawns(2).getPosY(),48,48);
			pawns[3].setBounds(game.getPawns(3).getPosX(),game.getPawns(3).getPosY(),48,48);
			panel.repaint();
			
    	}
		
    }
    
    //class to change the volume of the game
    private class VolumeListener implements ChangeListener{
    	/**
    	 * <b>transformer(mutative)</b>: Changing the volume <br />
         * @post volume has changed</p>
    	 */
		@Override
		public void stateChanged(ChangeEvent e) {
			setVol(volumeSlider.getValue(),clipMusic);
		}
    	
    }

    /**
     * Method to play sounds of the game
     * @post the sound has been played
     * @param sound
     * @param volume
     */
    public void playSound(String sound,double volume) {
    	try {
    		soundURL = cldr.getResource("sounds/"+sound);
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
    		Clip clip = AudioSystem.getClip();
    		clip.open(audioInputStream);
    		setVol(volume+50.0,clip);
    		clip.start();
    	}catch(Exception ex) {
    		System.out.println("Sound was not found");
    		ex.printStackTrace();
    	}
    }
 
    /**
     * <b>Transfomer(mutative) </b>:Change the volume of the game
     * @the volume has changed
     * @param volume
     * @param clip
     */
    private static void setVol(double volume,Clip clip) {
    	volume = volume/100.0 ;
		FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		float dB = (float) (Math.log(volume) / Math.log(10) * 20);
		gain.setValue(dB);
	}
    
}


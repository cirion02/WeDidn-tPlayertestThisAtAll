import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.List;
import java.awt.Font;

/* Part of Eclipse */
public class DidntPlaytest extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DidntPlaytest frame = new DidntPlaytest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	/* Make the thing that all the cards are */
	public interface playable {
		public void playCard(int player);
		public void battleEffect(int player);
		public String getName();
		public String getText();
	}
	
	/* Make all the cards ass classes*/
	public class cardNone implements playable {
		public void playCard(int Player) {
			
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return "nothing";
		}
		public String getText() {
			return "nothing";
		}
	}
	
	public class cardPc implements playable {
		static final String name = "PC";
		static final String text = "Everybody wins";
		public void playCard(int Player) {
			playerWins(1);
			playerWins(2);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardILose implements playable {
		static final String name = "I Lose";
		static final String text = "You Lose";
		public void playCard(int Player) {
			playerLoses(Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBattleRock implements playable {
		static final String name = "Battle! (Rock)";
		static final String text = "Each player trows rock, paper or scissors.\nAnyone who trew rock loses.";
		public void playCard(int Player) {
			RockPaperScissors("Rock", Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBattlePaper implements playable {
		static final String name = "Battle! (Paper)";
		static final String text = "Each player trows rock, paper or scissors.\nAnyone who trew paper loses.";
		public void playCard(int Player) {
			RockPaperScissors("Paper", Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBattleScissors implements playable {
		static final String name = "Battle! (Scissors)";
		static final String text = "Each player trows rock, paper or scissors.\nAnyone who trew scissors loses.";
		public void playCard(int Player) {
			RockPaperScissors("Scissors", Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardNumbersEven implements playable {
		static final String name = "Numbers (Even)";
		static final String text = "Each player trows between 1 and 5 fingers.\nAnyone who trew an even number of fingers loses.";
		public void playCard(int Player) {
			Numbers("Even", Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardNumbersOdd implements playable {
		static final String name = "Numbers (Odd)";
		static final String text = "Each player trows between 1 and 5 fingers.\nAnyone who trew an odd number of fingers loses.";
		public void playCard(int Player) {
			Numbers("Odd", Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardPoints implements playable {
		static final String name = "Points";
		static final String text = "You get +8 points, anyone with 15 or more points wins.";
		public void playCard(int Player) {
			Points(Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardNoDrawing implements playable {
		static final String name = "No Drawing!";
		static final String text = "PLayers can't draw cards, if they have no card to play they lose.";
		public void playCard(int Player) {
			totalBattlefield.add(kaartNoDrawing);
			Drawing = false;
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardSuperPoints implements playable {
		static final String name = "Super Points";
		static final String text = "You get +90 points, but now you need 100 or more points wins.";
		public void playCard(int Player) {
			winPoints = 100;
			superPoints(Player);
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardTheEnd implements playable {
		static final String name = "The End";
		static final String text = "At the end of your next turn, everyone loses.";
		public void playCard(int Player) {
			switch (Player) {
			case 1 :	player1Battlefield.add(kaartTheEnd);
						break;
			case 2 :	player2Battlefield.add(kaartTheEnd);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			theEndTimer -= 1;
			if (theEndTimer == 0) {
				playerLoses(1);
				playerLoses(2);
			}
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBomb implements playable {
		static final String name = "Bomb";
		static final String text = "Take an extra turn. If there are 4 or more bombs face up everyone loses.";
		public void playCard(int Player) {
			extraTurn = true;
			totalBattlefield.add(kaartBomb);
			int bombCount = 0;
			for (int i=0; i<totalBattlefield.size(); i++) {
				if (totalBattlefield.get(i).getName() == "Bomb") {
					bombCount++;
				}
			}
			if (bombCount > 3) {
				playerLoses(1);
				playerLoses(2);
			}
				
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBombParty implements playable {
		static final String name = "Bomb Party";
		static final String text = "Each player puts all bomb from their hand into play, if there are 4 or more bombs face up now, you win!";
		public void playCard(int Player) {
			for (int i=0; i<player1Hand.size(); i++) {
				if (player1Hand.get(i).getName() == "Bomb") {
					totalBattlefield.add(kaartBomb);
					player1Hand.remove(i);
					i--;
				}
			}
			for (int i=0; i<player2Hand.size(); i++) {
				if (player2Hand.get(i).getName() == "Bomb") {
					totalBattlefield.add(kaartBomb);
					player2Hand.remove(i);
					i--;
				}
			}
			int bombCount = 0;
			for (int i=0; i<totalBattlefield.size(); i++) {
				if (totalBattlefield.get(i).getName() == "Bomb") {
					bombCount++;
				}
			}
			if (bombCount > 3) {
				playerLoses(Player);
			}
		}
		public void battleEffect(int Player) {
			
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardDragon implements playable {
		static final String name = "Dragon";
		static final String text = "Place in front of your opponent. if this card is infront of you at the end of turn you lose.";
		public void playCard(int Player) {
			switch (Player) {
			case 2 :	player1Battlefield.add(kaartDragon);
						break;
			case 1 :	player2Battlefield.add(kaartDragon);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			playerLoses(Player);
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardArrowed implements playable {
		static final String name = "Arrowed";
		static final String text = "Place in front of your opponent. if this card is infront of you at the end of turn you lose.";
		public void playCard(int Player) {
			switch (Player) {
			case 2 :	player1Battlefield.add(kaartArrowed);
						break;
			case 1 :	player2Battlefield.add(kaartArrowed);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			playerLoses(Player);
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardLasers implements playable {
		static final String name = "Lasers";
		static final String text = "Place in front of your opponent. if this card is infront of you at the end of turn you lose.";
		public void playCard(int Player) {
			switch (Player) {
			case 2 :	player1Battlefield.add(kaartLasers);
						break;
			case 1 :	player2Battlefield.add(kaartLasers);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			playerLoses(Player);
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardBlackHole implements playable {
		static final String name = "Black Hole";
		static final String text = "Place in front of your opponent. if this card is infront of you at the end of turn you lose.";
		public void playCard(int Player) {
			switch (Player) {
			case 2 :	player1Battlefield.add(kaartBlackHole);
						break;
			case 1 :	player2Battlefield.add(kaartBlackHole);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			playerLoses(Player);
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardZoom implements playable {
		static final String name = "Zoom!";
		static final String text = "If there is a lasers or arrowed card in front you, give it to your opponent. Otherwise draw 2 card";
		public void playCard(int Player) {	
			Dodgers(Player, kaartLasers, kaartArrowed);
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardShield implements playable {
		static final String name = "Shield";
		static final String text = "If there is a dragon or arrowed card in front you, give it to your opponent. Otherwise draw 2 card";
		public void playCard(int Player) {	
			Dodgers(Player, kaartDragon, kaartArrowed);
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardScience implements playable {
		static final String name = "Science";
		static final String text = "If there is a dragon or black hole card in front you, give it to your opponent. Otherwise draw 2 card";
		public void playCard(int Player) {	
			Dodgers(Player, kaartDragon, kaartBlackHole);
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	
	public class cardSpaceship implements playable {
		static final String name = "Spaceship";
		static final String text = "If there is a lasers or black hole card in front you, give it to your opponent. Otherwise draw 2 card";
		public void playCard(int Player) {	
			Dodgers(Player, kaartLasers, kaartBlackHole);
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
	}
	

	
	/* Make an Object for each class */
	cardPc kaartPc = new cardPc();
	cardILose kaartILose = new cardILose();
	cardNone kaartNone = new cardNone();
	cardBattleRock kaartBattleRock = new cardBattleRock();
	cardBattlePaper kaartBattlePaper = new cardBattlePaper();
	cardBattleScissors kaartBattleScissors = new cardBattleScissors();
	cardNumbersOdd kaartNumbersOdd = new cardNumbersOdd();
	cardNumbersEven kaartNumbersEven = new cardNumbersEven();
	cardPoints kaartPoints = new cardPoints();
	cardTheEnd kaartTheEnd = new cardTheEnd();
	cardSuperPoints kaartSuperPoints = new cardSuperPoints();
	cardNoDrawing kaartNoDrawing = new cardNoDrawing();
	cardBomb kaartBomb = new cardBomb();
	cardBombParty kaartBombParty = new cardBombParty();
	cardDragon kaartDragon = new cardDragon();
	cardArrowed kaartArrowed = new cardArrowed();
	cardLasers kaartLasers = new cardLasers();
	cardBlackHole kaartBlackHole = new cardBlackHole();
	cardShield kaartShield = new cardShield();
	cardSpaceship kaartSpaceship = new cardSpaceship();
	cardZoom kaartZoom = new cardZoom();
	cardScience kaartScience = new cardScience();
	
	/* Variablelen aanmaken */
	ArrayList<playable> player1Hand=new ArrayList<playable>();
	ArrayList<playable> player2Hand=new ArrayList<playable>();
	ArrayList<playable> library=new ArrayList<playable>(); 
	ArrayList<String> Prompts = new ArrayList<String>();
	ArrayList<playable> cards = new ArrayList<playable>();
	ArrayList<playable> totalBattlefield = new ArrayList<playable>();
	ArrayList<playable> player1Battlefield = new ArrayList<playable>();
	ArrayList<playable> player2Battlefield = new ArrayList<playable>();
	String returnFunction = "";
	int player1points = 0;
	int player2points = 0;
	int theEndTimer = 2;
	int winPoints = 15;
	boolean Drawing = true;
	String lastAiCard;
	JButton b0 = new JButton("");
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	List history = new List();
	JLabel questionHeader = new JLabel("");
	JButton testExtraTurnMyNigga = new JButton("xtra turn");
	JLabel lblNewLabel = new JLabel("History + Chat");
	JTextField chatText = new JTextField();
	
	boolean extraTurn= false;
	Choice prompt = new Choice();
	JButton confirm = new JButton("Confirm");
	private final JButton btnTestprompt = new JButton("TESTPROMPT");
	
	/* Basis Functies */
	
	/* Adds cards from the library to the hand */
	public void Draw(int player, int amount) {
		if (Drawing == true) {
			int random;
			for (int i=0; i<amount; i++) {
				random = (int) (Math.random()*library.size());
				switch (player) {
					case 1: player1Hand.add(0, library.get(random));
							updateButtons();
					case 2: player2Hand.add(0, library.get(random));
				}
			}
		}
		else {
			if (player == 1 && player1Hand.size() == 0) {
				playerLoses(1);
			}

			if (player == 2 && player2Hand.size() == 0) {
				playerLoses(2);
			}
		}
	}
	
	
	/* Fill the player's starting hand with empty card to check against*/
	public void fillHand() {
		for (int i=0; i<20; i++) {
			player1Hand.add(kaartNone);
			player2Hand.add(kaartNone);
		}
	}
	
	public void textToFont(String font) {
		b0.setFont(new Font(font, Font.PLAIN, 11));
		b1.setFont(new Font(font, Font.PLAIN, 11));
		b2.setFont(new Font(font, Font.PLAIN, 11));
		b3.setFont(new Font(font, Font.PLAIN, 11));
		b4.setFont(new Font(font, Font.PLAIN, 11));
		history.setFont(new Font(font, Font.PLAIN, 11));
		questionHeader.setFont(new Font(font, Font.PLAIN, 17));
		testExtraTurnMyNigga.setFont(new Font(font, Font.PLAIN, 11));
		lblNewLabel.setFont(new Font(font, Font.PLAIN, 17));
		chatText.setFont(new Font(font, Font.PLAIN, 11));
		prompt.setFont(new Font(font, Font.PLAIN, 11));
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTestprompt.setFont(new Font(font, Font.PLAIN, 11));
	}
	
	
	/* Fills a dropdown with options and makes it visible*/
	public void callPrompt() {
		prompt.removeAll();
		prompt.setVisible(true);
		for (int i=0; i<Prompts.size(); i++) {
			String choice = Prompts.get(i);
			prompt.add(choice);
		}
		confirm.setVisible(true);
	}
	
	/* If the AI has to  make a choice, use this function */
	public void AiChoise(String Loses) {
		int choiceNumber = (int) (Math.random() * Prompts.size());
		String choice = Prompts.get(choiceNumber);
		history.add("Your opponent chose " + choice + ".  ");
		if (choice == Loses || (Loses == "Even" && (choice == "2" || choice == "4")) || (Loses == "Odd" && (choice == "1" || choice == "3" || choice == "5"))) {
			playerLoses(2);
		}
	}
	
	
	/* The function all the Battle! cards call to do their effect */
	public void RockPaperScissors(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("Rock");
		Prompts.add("Paper");
		Prompts.add("Scissors");
		returnFunction = Loses;
		questionHeader.setText("Rock, Paper or Scissors.");
		if (Player == 2) {
			callPrompt();
		}
		if (Player == 1) {
			AiChoise(Loses);
		}
		
	}
	
	public void Points(int Player) {
		switch (Player) {
		case 1 :	player1points += 8;
					player1Battlefield.add(kaartPoints);
					if (player1points >= winPoints) {
						playerWins(1);
					}
					break;
		case 2 :	player2points += 8;
					player2Battlefield.add(kaartPoints);
					if (player2points >= winPoints) {
						playerWins(2);
					};
					break;
		}
	}
	
	public void Dodgers(int Player, playable card1, playable card2) {
		ArrayList<playable> casterBattlefield = new ArrayList<playable>();
		ArrayList<playable> resiverBattlefield = new ArrayList<playable>();
		switch (Player) {
		case 1 :
			casterBattlefield = player1Battlefield;
			resiverBattlefield = player2Battlefield;
			break;
		case 2 :
			casterBattlefield = player2Battlefield;
			resiverBattlefield = player1Battlefield;
			break;
		}
		
		for (int i=0; i<casterBattlefield.size(); i++) {
			if (casterBattlefield.get(i).getName() == card1.getName()) {
				resiverBattlefield.add(card1);
				casterBattlefield.remove(i);
				break;
			}
		}
		for (int i=0; i<casterBattlefield.size(); i++) {
			if (casterBattlefield.get(i).getName() == card2.getName()) {
				resiverBattlefield.add(card2);
				casterBattlefield.remove(i);
				break;
			}
		}
		Draw(Player, 2);
			
	}
	
	public void superPoints(int Player) {
		switch (Player) {
		case 1 :	player1points += 90;
					player1Battlefield.add(kaartSuperPoints);
					if (player1points >= winPoints) {
						playerWins(1);
					}
					break;
		case 2 :	player2points += 90;
					player2Battlefield.add(kaartSuperPoints);
					if (player2points >= winPoints) {
						playerWins(2);
					}
					break;
		}
	}
	
	/* the function the confirm button calls for Battle! cards */
	public void RockPaperScissorsDone(String Loses, String Picked) {
		if (Loses == Picked) {
			playerLoses(1);
		}
		questionHeader.setText("");
		confirm.setVisible(false);
		prompt.setVisible(false);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		history.add("Your opponent played: " + lastAiCard + ". ");
		Draw(1,1);
	}
	
	public void Numbers(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("1");
		Prompts.add("2");
		Prompts.add("3");
		Prompts.add("4");
		Prompts.add("5");
		questionHeader.setText("Choose a number between 1 and 5.");
		returnFunction = Loses;
		if (Player == 2) {
			callPrompt();
		}
		if (Player == 1) {
			AiChoise(Loses);
		}
	}
	
	public void updateButtons() {
		b0.setText(player1Hand.get(0).getName());
		b1.setText(player1Hand.get(1).getName());
		b2.setText(player1Hand.get(2).getName());
		b3.setText(player1Hand.get(3).getName());
		b4.setText(player1Hand.get(4).getName());
		switch (player1Hand.get(0).getName()) {
		case "nothing": b0.setVisible(false);
						break;
		default: 		b0.setVisible(true);	
						break;
		} 
		switch (player1Hand.get(1).getName()) {
		case "nothing": b1.setVisible(false);
						break;
		default: 		b1.setVisible(true);	
						break;
		} 
		switch (player1Hand.get(2).getName()) {
		case "nothing": b2.setVisible(false);
						break;
		default: 		b2.setVisible(true);	
						break;
		} 
		switch (player1Hand.get(3).getName()) {
		case "nothing": b3.setVisible(false);
						break;
		default: 		b3.setVisible(true);	
						break;
		} 
		switch (player1Hand.get(4).getName()) {
		case "nothing": b4.setVisible(false);
						break;
		default: 		b4.setVisible(true);	
						break;
		} 
	}
	
	
	public void NumbersDone(String Loses, String Picked) {
		if ((Loses == "Even" && (Picked == "2" || Picked == "4")) || (Loses == "Odd" && (Picked == "1" || Picked == "3" || Picked == "5"))) {
			playerLoses(1);
		}
		questionHeader.setText("");
		confirm.setVisible(false);
		prompt.setVisible(false);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		history.add("Your opponent played: " + lastAiCard + ". ");
		Draw(1,1);
	}
	
	/* adds all the cards to the library */
	public void fillLibrary(int amount) {
		for (int i=0; i<amount; i++) {
			for (int t=0; t<cards.size(); t++) {
				library.add(cards.get(t));
			}
		}
	}
	
	/* Makes a player loses the game */
	public void playerLoses(int player) {
		history.add("player " + player + " has lost the game.  ");
	}
	
	/* Makes a player wins the game */
	public void playerWins(int player) {
		history.add("player " + player + " has won the game.  ");
	}
	
	/* calls all functions that have to happen at the start of the game */
	public void startOfGame(){
		fillLibrary(10);
		fillHand();
	}
	
	/* If you give this a cardname it will activate that cards effect */
	public void runCard(String Name, int Player) {
		for (int i=0; i<cards.size(); i++) {
			playable testObject = cards.get(i);
			String name = testObject.getName();
			if (Name == name) {
				testObject.playCard(Player);
			}
		}
		if (Player == 1) {
			history.add("You played: " + Name + ". ");
			for (int i=0; i<player1Battlefield.size(); i++) {
				playable testObject = player1Battlefield.get(i);
				testObject.battleEffect(1);
			}
			if (extraTurn) {
				extraTurn = false;
				Draw(1,1);
			}
			else {
				b0.setEnabled(false);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				AIPlaysCard();
			}
		}
	
	}
	
	/* If you give this a card-name it will activate that cards effect */
	public void AIPlaysCard() {
		Draw(2, 1);
		int random = (int) Math.random() * player2Hand.size();
		lastAiCard = player2Hand.get(random).getName();
		runCard(player2Hand.get(random).getName(), 2);
		player2Hand.remove(random);
		for (int i=0; i<player2Battlefield.size(); i++) {
			playable testObject = player2Battlefield.get(i);
			testObject.battleEffect(2);
		}
		if (prompt.isVisible() == false) { 
		history.add("Your opponent played: " + lastAiCard + ". ");
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		Draw(1,1);
		if (extraTurn) {
			AIPlaysCard();
		}
		}
	}
	/* turnsysteem */
	
	/*Front End (Mostly) */
	public DidntPlaytest() {
		confirm.setBounds(382, 301, 113, 37);
		confirm.setVisible(false);
		cards.add(kaartPc);
		cards.add(kaartILose);
		cards.add(kaartBattleRock);
		cards.add(kaartBattlePaper);
		cards.add(kaartBattleScissors);
		cards.add(kaartNumbersEven);
		cards.add(kaartNumbersOdd);
		cards.add(kaartPoints);
		cards.add(kaartSuperPoints);
		cards.add(kaartTheEnd);
		cards.add(kaartNoDrawing);
		cards.add(kaartBomb);
		cards.add(kaartBombParty);
		cards.add(kaartBlackHole);
		cards.add(kaartArrowed);
		cards.add(kaartDragon);
		cards.add(kaartLasers);
		startOfGame();
		Draw(1, 2);
		Draw(2, 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		b0.setBounds(30, 550, 125, 139);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(0).getName(), 1);
				player1Hand.remove(0);
				updateButtons();
			}
		});
		String cardInHand0 = player1Hand.get(0).getName();
		b0.setText(player1Hand.get(0).getName());
		
		switch (cardInHand0) {
		case "nothing": b0.setVisible(false);
						break;
		default: 		b0.setVisible(true);	
						break;
		}
		b1.setBounds(199, 550, 125, 139);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(1).getName(), 1);
				player1Hand.remove(1);
				updateButtons();
			}
		});
		String cardInHand1 = player1Hand.get(1).getName();
		b1.setText(player1Hand.get(1).getName());
		
		switch (cardInHand1) {
		case "nothing": b1.setVisible(false);
						break;
		default: 		b1.setVisible(true);	
						break;
		}
		b2.setBounds(370, 550, 125, 139);
		

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(2).getName(), 1);
				player1Hand.remove(2);
				updateButtons();
			}
		});
		String cardInHand2 = player1Hand.get(2).getName();
		b2.setText(player1Hand.get(2).getName());
		
		switch (cardInHand2) {
		case "nothing": b2.setVisible(false);
						break;
		default: 		b2.setVisible(true);	
						break;
		}
		b3.setBounds(544, 550, 125, 139);
		

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(3).getName(), 1);
				player1Hand.remove(3);
				updateButtons();
			}
		});
		String cardInHand3 = player1Hand.get(3).getName();
		b3.setText(player1Hand.get(3).getName());
		
		switch (cardInHand3) {
		case "nothing": b3.setVisible(false);
						break;
		default: 		b3.setVisible(true);	
						break;
		}
		b4.setBounds(713, 550, 125, 139);
		

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(4).getName(), 1);
				player1Hand.remove(4);
				updateButtons();
			}
		});
		String cardInHand4 = player1Hand.get(4).getName();
		b4.setText(player1Hand.get(4).getName());
		
		switch (cardInHand4) {
		case "nothing": b4.setVisible(false);
						break;
		default: 		b4.setVisible(true);	
						break;
		}
		prompt.setBounds(382, 276, 113, 20);
		prompt.setVisible(false);
		


		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String finalChoice = prompt.getSelectedItem();
				if (returnFunction == "Rock" || returnFunction == "Paper" || returnFunction == "Scissors") {
					RockPaperScissorsDone(returnFunction, finalChoice);
				}
				if (returnFunction == "Even" || returnFunction == "Odd") {
					NumbersDone(returnFunction, finalChoice);
				}
			}
		});
		btnTestprompt.setBounds(30, 22, 89, 23);
		btnTestprompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callPrompt();
			}
		});
		contentPane.setLayout(null);
		
		testExtraTurnMyNigga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				extraTurn = true;
			}
		});
		testExtraTurnMyNigga.setBounds(146, 22, 89, 23);
		contentPane.add(testExtraTurnMyNigga);
		contentPane.add(b0);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(prompt);
		contentPane.add(confirm);
		contentPane.add(btnTestprompt);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(631, 78, 221, 46);
		contentPane.add(lblNewLabel);
		
		history.setBounds(631, 130, 221, 232);
		contentPane.add(history);
		
		questionHeader.setHorizontalAlignment(SwingConstants.CENTER);
		questionHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		questionHeader.setBounds(305, 249, 275, 23);
		contentPane.add(questionHeader);
		
		chatText.setBounds(631, 368, 165, 20);
		contentPane.add(chatText);
		chatText.setColumns(10);
		
		JButton chatConfirm = new JButton("->");
		chatConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				history.add("P1: " + chatText.getText());
				chatText.setText("");
			}
		});
		chatConfirm.setBounds(806, 367, 46, 23);
		contentPane.add(chatConfirm);
		
		// main game loop //
		textToFont("Tahoma");
	}
}

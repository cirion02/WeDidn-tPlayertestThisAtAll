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
import java.awt.Color;

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
			totalBattlefield.add(0, kaartNoDrawing);
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
			case 1 :	player1Battlefield.add(0, kaartTheEnd);
						break;
			case 2 :	player2Battlefield.add(0, kaartTheEnd);
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
			totalBattlefield.add(0, kaartBomb);
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
					totalBattlefield.add(0, kaartBomb);
					player1Hand.remove(i);
					i--;
				}
			}
			for (int i=0; i<player2Hand.size(); i++) {
				if (player2Hand.get(i).getName() == "Bomb") {
					totalBattlefield.add(0, kaartBomb);
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
			case 2 :	player1Battlefield.add(0, kaartDragon);
						break;
			case 1 :	player2Battlefield.add(0, kaartDragon);
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
			case 2 :	player1Battlefield.add(0, kaartArrowed);
						break;
			case 1 :	player2Battlefield.add(0, kaartArrowed);
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
			case 2 :	player1Battlefield.add(0, kaartLasers);
						break;
			case 1 :	player2Battlefield.add(0, kaartLasers);
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
			case 2 :	player1Battlefield.add(0, kaartBlackHole);
						break;
			case 1 :	player2Battlefield.add(0, kaartBlackHole);
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
	
	public class cardComicSans implements playable {
		static final String name = "Comic Sans";
		static final String text = "Before each player plays a card on their turn, they must say \"Comic Sans is Awesome\" or they lose.";
		public void playCard(int Player) {	
			totalBattlefield.add(0, kaartComicSans);
			comicSans();
			textToFont("Comic Sans MS");
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
	
	public class cardZombies implements playable {
		static final String name = "Zombies!";
		static final String text = "Before each player plays a card on their turn, they must say \"AHH! Zombies!\" is Awesome or they lose.";
		public void playCard(int Player) {	
			totalBattlefield.add(0, kaartZombies);
			zombies();
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
	
	public class cardNinjas implements playable {
		static final String name = "Ninjas";
		static final String text = "Steal a card from your opponents hand and play it.";
		public void playCard(int Player) {	
			ninjas(Player);
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
	cardZombies kaartZombies = new cardZombies();
	cardComicSans kaartComicSans = new cardComicSans();
	cardNinjas kaartNinjas = new cardNinjas();
	
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
	boolean comicSans = false;
	boolean comicSansTemp = false;
	boolean zombies = false;
	boolean zombiesTemp = false;
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
	JButton btnTestprompt = new JButton("TESTPROMPT");
	

	JLabel fieldplayer2 = new JLabel("");
	JLabel fieldplayer1 = new JLabel("");
	JLabel fieldplayer6 = new JLabel("");
	JLabel fieldplayer7 = new JLabel("");
	JLabel fieldplayer8 = new JLabel("");
	JLabel fieldplayer3 = new JLabel("");
	JLabel fieldplayer4 = new JLabel("");
	JLabel fieldplayer5 = new JLabel("");
	JLabel fieldplayer10 = new JLabel("");
	JLabel fieldplayer9 = new JLabel("");
	JLabel fieldAI2 = new JLabel("");
	JLabel fieldAI1 = new JLabel("");
	JLabel fieldAI6 = new JLabel("");
	JLabel fieldAI7 = new JLabel("");
	JLabel fieldAI8 = new JLabel("");
	JLabel fieldAI3 = new JLabel("");
	JLabel fieldAI4 = new JLabel("");
	JLabel fieldAI5 = new JLabel("");
	JLabel fieldAI10 = new JLabel("");
	JLabel fieldAI9 = new JLabel("");
	JLabel fieldneutral1 = new JLabel("");
	JLabel fieldneutral2 = new JLabel("");
	JLabel fieldneutral3 = new JLabel("");
	JLabel fieldneutral4 = new JLabel("");
	JLabel fieldneutral5 = new JLabel("");
	
	/* Basis Functies */
	
	
	public void comicSans() {
		comicSans = true;
		comicSansTemp = true;
	}
	
	public void zombies() {
		zombies = true;
		zombiesTemp = true;
	}
	
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
			player1Battlefield.add(kaartNone);
			player2Battlefield.add(kaartNone);
			totalBattlefield.add(kaartNone);
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
		if (Player == 2) {
			callPrompt();
			questionHeader.setText("Rock, Paper or Scissors.");
		}
		if (Player == 1) {
			AiChoise(Loses);
		}
		
	}
	
	public void ninjas(int Player) {
		int number;
		String name;
		int testVar = 0;
		switch (Player) {
		case 1:
			for (int i=0; i < player2Hand.size(); i++) {
				if (player2Hand.get(i).getName() == "nothing") {
					break;
				}
				testVar++;
			}
			extraTurn = true;
			number = (int) (Math.random() * testVar);
			name = player2Hand.get(number).getName();
			player2Hand.remove(number);
			runCard(name, 1, false);
			break;
		case 2:
			for (int i=0; i < player1Hand.size(); i++) {
				if (player1Hand.get(i).getName() == "nothing") {
					break;
				}
				testVar++;
			}
			number = (int) (Math.random() * testVar);
			name = player1Hand.get(number).getName();
			player1Hand.remove(number);
			runCard(name, 2, false);
			break;
		}
	}
	
	public void Points(int Player) {
		switch (Player) {
		case 1 :	player1points += 8;
					player1Battlefield.add(0, kaartPoints);
					if (player1points >= winPoints) {
						playerWins(1);
					}
					break;
		case 2 :	player2points += 8;
					player2Battlefield.add(0, kaartPoints);
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
				resiverBattlefield.add(0, card1);
				casterBattlefield.remove(i);
				break;
			}
		}
		for (int i=0; i<casterBattlefield.size(); i++) {
			if (casterBattlefield.get(i).getName() == card2.getName()) {
				resiverBattlefield.add(0, card2);
				casterBattlefield.remove(i);
				break;
			}
		}
		Draw(Player, 2);
			
	}
	
	public void superPoints(int Player) {
		switch (Player) {
		case 1 :	player1points += 90;
					player1Battlefield.add(0, kaartSuperPoints);
					if (player1points >= winPoints) {
						playerWins(1);
					}
					break;
		case 2 :	player2points += 90;
					player2Battlefield.add(0, kaartSuperPoints);
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
		history.add("Your opponent played: " + lastAiCard + ". ");
		for (int i=0; i<player2Battlefield.size(); i++) {
			playable testObject = player2Battlefield.get(i);
			testObject.battleEffect(2);
		}
		if (extraTurn) {
			AIPlaysCard();
		}
		else {
			b0.setEnabled(true);
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			Draw(1,1);
			if (comicSans == true) {
				comicSansTemp = true;
			}
			if (zombies == true) {
				zombiesTemp = true;
			}
		}

	}
	
	public void Numbers(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("1");
		Prompts.add("2");
		Prompts.add("3");
		Prompts.add("4");
		Prompts.add("5");
		returnFunction = Loses;
		if (Player == 2) {
			callPrompt();
			questionHeader.setText("Choose a number between 1 and 5.");
		}
		if (Player == 1) {
			AiChoise(Loses);
		}
	}
	
	public void updateButtons() {
		b0.setText("<html> <b>" + player1Hand.get(0).getName() + "</b> <br />" + player1Hand.get(0).getText() + "  </html>");
		b1.setText("<html> <b>" + player1Hand.get(1).getName() + "</b> <br />" + player1Hand.get(1).getText() + "  </html>");
		b2.setText("<html> <b>" + player1Hand.get(2).getName() + "</b> <br />" + player1Hand.get(2).getText() + "  </html>");
		b3.setText("<html> <b>" + player1Hand.get(3).getName() + "</b> <br />" + player1Hand.get(3).getText() + "  </html>");
		b4.setText("<html> <b>" + player1Hand.get(4).getName() + "</b> <br />" + player1Hand.get(4).getText() + "  </html>");
		
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
		
		fieldplayer1.setText(player1Battlefield.get(0).getName());
		fieldplayer2.setText(player1Battlefield.get(1).getName());
		fieldplayer3.setText(player1Battlefield.get(2).getName());
		fieldplayer4.setText(player1Battlefield.get(3).getName());
		fieldplayer5.setText(player1Battlefield.get(4).getName());
		fieldplayer6.setText(player1Battlefield.get(5).getName());
		fieldplayer7.setText(player1Battlefield.get(6).getName());
		fieldplayer8.setText(player1Battlefield.get(7).getName());
		fieldplayer9.setText(player1Battlefield.get(8).getName());
		fieldplayer10.setText(player1Battlefield.get(9).getName());
		
		fieldneutral1.setText(totalBattlefield.get(0).getName());
		fieldneutral2.setText(totalBattlefield.get(1).getName());
		fieldneutral3.setText(totalBattlefield.get(2).getName());
		fieldneutral4.setText(totalBattlefield.get(3).getName());
		fieldneutral5.setText(totalBattlefield.get(4).getName());
		
		fieldAI1.setText(player2Battlefield.get(0).getName());
		fieldAI2.setText(player2Battlefield.get(1).getName());
		fieldAI3.setText(player2Battlefield.get(2).getName());
		fieldAI4.setText(player2Battlefield.get(3).getName());
		fieldAI5.setText(player2Battlefield.get(4).getName());
		fieldAI6.setText(player2Battlefield.get(5).getName());
		fieldAI7.setText(player2Battlefield.get(6).getName());
		fieldAI8.setText(player2Battlefield.get(7).getName());
		fieldAI9.setText(player2Battlefield.get(8).getName());
		fieldAI10.setText(player2Battlefield.get(9).getName());
		
		switch (player1Battlefield.get(0).getName()) {
		case "nothing": fieldplayer1.setVisible(false);
						break;
		default: 		fieldplayer1.setVisible(true);	
						break;
		} 
		switch (player1Battlefield.get(1).getName()) {
		case "nothing": fieldplayer2.setVisible(false);
						break;
		default: 		fieldplayer2.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(2).getName()) {
		case "nothing": fieldplayer3.setVisible(false);
						break;
		default: 		fieldplayer3.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(3).getName()) {
		case "nothing": fieldplayer4.setVisible(false);
						break;
		default: 		fieldplayer4.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(4).getName()) {
		case "nothing": fieldplayer5.setVisible(false);
						break;
		default: 		fieldplayer5.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(5).getName()) {
		case "nothing": fieldplayer6.setVisible(false);
						break;
		default: 		fieldplayer6.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(6).getName()) {
		case "nothing": fieldplayer7.setVisible(false);
						break;
		default: 		fieldplayer7.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(7).getName()) {
		case "nothing": fieldplayer8.setVisible(false);
						break;
		default: 		fieldplayer8.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(8).getName()) {
		case "nothing": fieldplayer9.setVisible(false);
						break;
		default: 		fieldplayer9.setVisible(true);	
						break;
		}
		switch (player1Battlefield.get(9).getName()) {
		case "nothing": fieldplayer10.setVisible(false);
						break;
		default: 		fieldplayer10.setVisible(true);	
						break;
		}
		
		switch (player2Battlefield.get(0).getName()) {
		case "nothing": fieldAI1.setVisible(false);
						break;
		default: 		fieldAI1.setVisible(true);	
						break;
		} 
		switch (player2Battlefield.get(1).getName()) {
		case "nothing": fieldAI2.setVisible(false);
						break;
		default: 		fieldAI2.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(2).getName()) {
		case "nothing": fieldAI3.setVisible(false);
						break;
		default: 		fieldAI3.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(3).getName()) {
		case "nothing": fieldAI4.setVisible(false);
						break;
		default: 		fieldAI4.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(4).getName()) {
		case "nothing": fieldAI5.setVisible(false);
						break;
		default: 		fieldAI5.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(5).getName()) {
		case "nothing": fieldAI6.setVisible(false);
						break;
		default: 		fieldAI6.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(6).getName()) {
		case "nothing": fieldAI7.setVisible(false);
						break;
		default: 		fieldAI7.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(7).getName()) {
		case "nothing": fieldAI8.setVisible(false);
						break;
		default: 		fieldAI8.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(8).getName()) {
		case "nothing": fieldAI9.setVisible(false);
						break;
		default: 		fieldAI9.setVisible(true);	
						break;
		}
		switch (player2Battlefield.get(9).getName()) {
		case "nothing": fieldAI10.setVisible(false);
						break;
		default: 		fieldAI10.setVisible(true);	
						break;
		}
		
		switch (totalBattlefield.get(0).getName()) {
		case "nothing": fieldneutral1.setVisible(false);
						break;
		default: 		fieldneutral1.setVisible(true);	
						break;
		} 
		switch (totalBattlefield.get(1).getName()) {
		case "nothing": fieldneutral2.setVisible(false);
						break;
		default: 		fieldneutral2.setVisible(true);	
						break;
		}
		switch (totalBattlefield.get(2).getName()) {
		case "nothing": fieldneutral3.setVisible(false);
						break;
		default: 		fieldneutral3.setVisible(true);	
						break;
		}
		switch (totalBattlefield.get(3).getName()) {
		case "nothing": fieldneutral4.setVisible(false);
						break;
		default: 		fieldneutral4.setVisible(true);	
						break;
		}
		switch (totalBattlefield.get(4).getName()) {
		case "nothing": fieldneutral5.setVisible(false);
						break;
		default: 		fieldneutral5.setVisible(true);	
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
		history.add("Your opponent played: " + lastAiCard + ". ");
		for (int i=0; i<player2Battlefield.size(); i++) {
			playable testObject = player2Battlefield.get(i);
			testObject.battleEffect(2);
		}
		if (extraTurn) {
			AIPlaysCard();
		}
		else {
			b0.setEnabled(true);
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			Draw(1,1);
			if (comicSans == true) {
				comicSansTemp = true;
			}
			if (zombies == true) {
				zombiesTemp = true;
			}
		}

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
	public void runCard(String Name, int Player, boolean special) {
		if (Player == 1) {
			if (comicSansTemp == true) {
				playerLoses(1);
			}
			if (zombiesTemp == true) {
				playerLoses(1);
			}
		}
		if (special == true) {
			switch (Player) {
			case 1:
				for (int i=0; i<player1Hand.size(); i++) {
					playable testObject = player1Hand.get(i);
					String name = testObject.getName();
					if (Name == name) {
						player1Hand.remove(i);
						break;
					}
				}
				break;
			case 2:
				for (int i=0; i<player2Hand.size(); i++) {
					playable testObject = player2Hand.get(i);
					String name = testObject.getName();
					if (Name == name) {
						player2Hand.remove(i);
						break;
					}
				}
				break;
			}
		}
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
				if (special == false) {
					Draw(1,1);
				}
				updateButtons();
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
		if (comicSans == true) {
			history.add("Comic Sans is awesome");
		}
		if (zombies == true) {
			history.add("AHH! Zombies!");
		}
		int random = (int) Math.random() * player2Hand.size();
		lastAiCard = player2Hand.get(random).getName();
		runCard(player2Hand.get(random).getName(), 2, true);
		if (prompt.isVisible() == false) { 
			history.add("Your opponent played: " + lastAiCard + ". ");
			for (int i=0; i<player2Battlefield.size(); i++) {
				playable testObject = player2Battlefield.get(i);
				testObject.battleEffect(2);
			}
			if (extraTurn) {
				extraTurn = false;
				AIPlaysCard();
			}
			else {
				b0.setEnabled(true);
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				Draw(1,1);
				if (comicSans == true) {
					comicSansTemp = true;
				}
				if (zombies == true) {
					zombiesTemp = true;
				}
			}
		}
	}
	/* turnsysteem */
	
	/*Front End (Mostly) */
	public DidntPlaytest() {
		confirm.setBounds(1173, 671, 113, 37);
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
		cards.add(kaartComicSans);
		cards.add(kaartZombies);
		cards.add(kaartZoom);
		cards.add(kaartScience);
		cards.add(kaartSpaceship);
		cards.add(kaartShield);
		cards.add(kaartNinjas);
		startOfGame();
		Draw(1, 3);
		Draw(2, 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 1004);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		b0.setBounds(30, 800, 125, 139);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(0).getName(), 1, true);
				updateButtons();
			}
		});
		String cardInHand0 = player1Hand.get(0).getName();
		b0.setText("<html> <b>" + player1Hand.get(0).getName() + "</b> <br />" + player1Hand.get(0).getText() + "  </html>");
		
		
		switch (cardInHand0) {
		case "nothing": b0.setVisible(false);
						break;
		default: 		b0.setVisible(true);	
						break;
		}
		b1.setBounds(165, 800, 125, 139);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(1).getName(), 1, true);
				updateButtons();
			}
		});
		String cardInHand1 = player1Hand.get(1).getName();
		b1.setText("<html> <b>" + player1Hand.get(1).getName() + "</b> <br />" + player1Hand.get(1).getText() + "  </html>");
		
		switch (cardInHand1) {
		case "nothing": b1.setVisible(false);
						break;
		default: 		b1.setVisible(true);	
						break;
		}
		b2.setBounds(300, 800, 125, 139);
		

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(2).getName(), 1, true);
				updateButtons();
			}
		});
		String cardInHand2 = player1Hand.get(2).getName();
		b2.setText("<html> <b>" + player1Hand.get(2).getName() + "</b> <br />" + player1Hand.get(2).getText() + "  </html>");
		
		switch (cardInHand2) {
		case "nothing": b2.setVisible(false);
						break;
		default: 		b2.setVisible(true);	
						break;
		}
		b3.setBounds(435, 800, 125, 139);
		

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(3).getName(), 1, true);
				updateButtons();
			}
		});
		String cardInHand3 = player1Hand.get(3).getName();
		b3.setText("<html> <b>" + player1Hand.get(3).getName() + "</b> <br />" + player1Hand.get(3).getText() + "  </html>");
		
		switch (cardInHand3) {
		case "nothing": b3.setVisible(false);
						break;
		default: 		b3.setVisible(true);	
						break;
		}
		b4.setBounds(570, 800, 125, 139);
		

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(4).getName(), 1, true);
				updateButtons();
			}
		});
		String cardInHand4 = player1Hand.get(4).getName();
		b4.setText("<html> <b>" + player1Hand.get(4).getName() + "</b> <br />" + player1Hand.get(4).getText() + "  </html>");
		
		switch (cardInHand4) {
		case "nothing": b4.setVisible(false);
						break;
		default: 		b4.setVisible(true);	
						break;
		}
		prompt.setBounds(1163, 645, 137, 20);
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
		btnTestprompt.setBounds(1163, 231, 89, 23);
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
		testExtraTurnMyNigga.setBounds(1163, 264, 89, 23);
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
		lblNewLabel.setBounds(1163, 298, 221, 46);
		contentPane.add(lblNewLabel);
		
		history.setBounds(1163, 350, 221, 232);
		contentPane.add(history);
		
		questionHeader.setHorizontalAlignment(SwingConstants.CENTER);
		questionHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		questionHeader.setBounds(305, 208, 275, 37);
		contentPane.add(questionHeader);
		
		chatText.setBounds(1163, 588, 165, 20);
		contentPane.add(chatText);
		chatText.setColumns(10);
		
		JButton chatConfirm = new JButton("->");
		chatConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				history.add("P1: " + chatText.getText());
				if (chatText.getText().toLowerCase().equals("comic sans is awesome")) {
					comicSansTemp = false;
				}
				if (chatText.getText().toLowerCase().equals("ahh zombies") || chatText.getText().toLowerCase().equals("ahh! zombies!") || chatText.getText().toLowerCase().equals("ahh zombies!") || chatText.getText().toLowerCase().equals("ahh! zombies")) {
					zombiesTemp = false;
				}
				if (chatText.getText().toLowerCase().equals("/redraw")) {
					for (int i = 0; i < player1Hand.size(); i++) {
						player1Hand.set(i, kaartNone);
					}
					Draw(1, 2);
				}
				if (chatText.getText().toLowerCase().matches("/redraw .*")) {
					for (int i = 0; i < player1Hand.size(); i++) {
						player1Hand.set(i, kaartNone);
					}
					Draw(1, Integer.parseInt(chatText.getText().substring(8)));
				}
				if (chatText.getText().toLowerCase().matches("/draw .*")) {
					Draw(1, Integer.parseInt(chatText.getText().substring(6)));
				}
				if (chatText.getText().toLowerCase().matches("/givecard .*")) {
					for (int i = 0; i < cards.size(); i++) {
						if (chatText.getText().toLowerCase().substring(10).equals(cards.get(i).getName().toLowerCase())) {
							player1Hand.add(0, cards.get(i));
							updateButtons();
						}
					}
				}
				chatText.setText("");
			}
		});
		chatConfirm.setBounds(1338, 587, 46, 23);
		contentPane.add(chatConfirm);
			
		fieldplayer2.setBounds(285, 645, 181, 50);
		contentPane.add(fieldplayer2);
		
		fieldplayer1.setBounds(96, 645, 181, 50);
		contentPane.add(fieldplayer1);
		
		fieldplayer6.setBounds(96, 721, 181, 50);
		contentPane.add(fieldplayer6);
		
		fieldplayer7.setBounds(285, 721, 181, 50);
		contentPane.add(fieldplayer7);
		
		fieldplayer8.setBounds(476, 721, 181, 50);
		contentPane.add(fieldplayer8);
		
		fieldplayer3.setBounds(476, 645, 181, 50);
		contentPane.add(fieldplayer3);
		
		fieldplayer4.setBounds(667, 645, 181, 50);
		
		contentPane.add(fieldplayer4);
		fieldplayer5.setBounds(856, 645, 181, 50);
		
		contentPane.add(fieldplayer5);
		fieldplayer10.setBounds(856, 721, 181, 50);
		
		contentPane.add(fieldplayer10);
		fieldplayer9.setBounds(667, 721, 181, 50);
		
		contentPane.add(fieldplayer9);
		fieldAI2.setBounds(285, 208, 181, 50);
		
		contentPane.add(fieldAI2);
		fieldAI1.setBounds(96, 208, 181, 50);
		
		contentPane.add(fieldAI1);
		fieldAI6.setBounds(96, 284, 181, 50);
		
		contentPane.add(fieldAI6);
		fieldAI7.setBounds(285, 284, 181, 50);
		
		contentPane.add(fieldAI7);
		fieldAI8.setBounds(476, 284, 181, 50);
		
		contentPane.add(fieldAI8);
		fieldAI3.setBounds(476, 208, 181, 50);
		
		contentPane.add(fieldAI3);
		fieldAI4.setBounds(667, 208, 181, 50);
		
		contentPane.add(fieldAI4);
		fieldAI5.setBounds(856, 208, 181, 50);
		
		contentPane.add(fieldAI5);
		fieldAI10.setBounds(856, 284, 181, 50);
		
		contentPane.add(fieldAI10);
		fieldAI9.setBounds(667, 284, 181, 50);
		
		contentPane.add(fieldAI9);
		fieldneutral1.setBounds(96, 469, 181, 50);
		
		contentPane.add(fieldneutral1);
		fieldneutral2.setBounds(285, 469, 181, 50);
		
		contentPane.add(fieldneutral2);
		fieldneutral3.setBounds(476, 469, 181, 50);
		
		contentPane.add(fieldneutral3);
		fieldneutral4.setBounds(667, 469, 181, 50);
		
		contentPane.add(fieldneutral4);
		fieldneutral5.setBounds(856, 469, 181, 50);
		
		contentPane.add(fieldneutral5);
		
		
		
		// main game loop //
		textToFont("Tahoma");
	}
}

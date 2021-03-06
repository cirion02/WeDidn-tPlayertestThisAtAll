import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/* Part of Eclipse */
public class DidntPlaytest extends JFrame {
	
	/* main loop niet gebruikt */
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
	/* This is why the cards have empty functions */
	/* This is used so that java knows that if we have a list of card that they can then all run these functions */
	public interface playable {
		public void playCard(int player);
		public void battleEffect(int player);
		public String getName();
		public String getText();
		public int getScore();
	}
	
	/* Makes all the cards classes*/
	
	/* card that does nothing to make the players hand long enough to not crash */
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
		public int getScore() {
			return -1;
		}
	}
	
	/* all classes below here are our reprensation of cards */
	/* for all of them you can look at the String text to get a idea what they are seposed to do. */
	/* The comments in this card aply to all cards */
	public class cardPc implements playable {
		static final String name = "PC";
		static final String text = "Everybody wins";
		public void playCard(int Player) {
			playerWins(3);
			/* what the card does when it is played */

		}
		public void battleEffect(int Player) {
			/* what the card does when it's in play */
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
		public int getScore() {
			return 20;
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
		public int getScore() {
			return 1;
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
		public int getScore() {
			return 33;
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
		public int getScore() {
			return 33;
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
		public int getScore() {
			return 33;
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
		public int getScore() {
			return 50;
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
		public int getScore() {
			return 50;
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
		public int getScore() {
			if (winPoints - player2points <= 8) {
				return 100;
			}

			else if (winPoints - player2points <= 13) {
				return 75;
			}

			else if (winPoints - player2points <= 16) {
				return 50;
			}

			else {
				return 30;
			}

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
		public int getScore() {
			return 30;
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
		public int getScore() {
			if (winPoints - player2points <= 5) {
				return 100;
			}

			else if (winPoints - player2points <= 10) {
				return 75;
			}

			else if (winPoints - player2points <= 13) {
				return 50;
			}

			else {
				return 30;
			}

		}
	}
	
	public class cardTheEnd implements playable {
		static final String name = "The End";
		static final String text = "At the end of your next turn, everyone loses.";
		public void playCard(int Player) {
			/* adds the card to the apropirate battlefield */
			switch (Player) {
			case 1 :	player1Battlefield.add(0, kaartTheEnd);
						break;
			case 2 :	player2Battlefield.add(0, kaartTheEnd);
						break;
			}
				
		}
		public void battleEffect(int Player) {
			/* tiks down from 1 to 0 on 0 everyone dies */
			theEndTimer -= 1;
			if (theEndTimer == 0) {
				playerLoses(3);
			}
		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
		public int getScore() {
			return 20;
		}
	}
	
	public class cardBomb implements playable {
		static final String name = "Bomb";
		static final String text = "Take an extra turn. If there are 4 or more bombs face up everyone loses.";
		public void playCard(int Player) {
			extraTurn = true;
			totalBattlefield.add(0, kaartBomb);
			int bombCount = 0;
			/* Counts the number on bombs in play, if it's more than 3 everyone loses */
			for (int i=0; i<totalBattlefield.size(); i++) {
				if (totalBattlefield.get(i).getName() == "Bomb") {
					bombCount++;
				}
			}
			if (bombCount > 3) {
				playerLoses(3);
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
		public int getScore() {
			return 50;
		}
	}
	
	
	public class cardBombParty implements playable {
		static final String name = "Bomb Party";
		static final String text = "Each player puts all bomb from their hand into play, if there are 4 or more bombs face up now, you win!";
		public void playCard(int Player) {
			/* Puts all bombs from each players hand into play */
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
			/* Counts the number on bombs in play, if it's more than 3 the player who played this card loses */
			int bombCount = 0;
			for (int i=0; i<totalBattlefield.size(); i++) {
				if (totalBattlefield.get(i).getName() == "Bomb") {
					bombCount++;
				}
			}
			if (bombCount > 3) {
				playerWins(Player);
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
		public int getScore() {
			int bombCounter = 0;
			for (int i = 0; i < player2Battlefield.size(); i++) {
				if (player2Battlefield.get(i).getName() == "Bomb") {
					bombCounter++;
				}
			}
			for (int i = 0; i < player2Hand.size(); i++) {
				if (player2Hand.get(i).getName() == "Bomb") {
					bombCounter++;
				}
			}
			return bombCounter * 20 + 20;
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
		public int getScore() {
			return 80;
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
		public int getScore() {
			return 80;
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
		public int getScore() {
			return 80;
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
		public int getScore() {
			return 80;
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
		public int getScore() {
			if (player2Battlefield.contains(kaartLasers) || player2Battlefield.contains(kaartArrowed)) {
				return 95;
			}
			else {
				return 30;
			}
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
		public int getScore() {
			if (player2Battlefield.contains(kaartDragon) || player2Battlefield.contains(kaartArrowed)) {
				return 95;
			}
			else {
				return 30;
			}
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
		public int getScore() {
			if (player2Battlefield.contains(kaartDragon) || player2Battlefield.contains(kaartBlackHole)) {
				return 95;
			}
			else {
				return 30;
			}
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
		public int getScore() {
			if (player2Battlefield.contains(kaartLasers) || player2Battlefield.contains(kaartBlackHole)) {
				return 95;
			}
			else {
				return 30;
			}
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
		public int getScore() {
			return 61;
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
		public int getScore() {
			return 60;
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
		public int getScore() {
			return 50;
		}
	}
	
	public class cardYouWinMonth implements playable {
		static final String name = "You Win! (Month)";
		static final String text = "If your birthday is in this month you win, otherwise you get 5 points.";
		public void playCard(int Player) {	
			switch (Player) {
			case 1:
				if (monthPlayer == getMonth()) {
					playerWins(1);
				}
				else {
					winPoints(1);
				}
				break;
			case 2:
				if (monthAi == getMonth()) {
					playerWins(2);
				}
				else {
					winPoints(2);
				}
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
		public int getScore() {
			if (monthAi == getMonth()) {
				return 100;
			}
			
			else if (winPoints - player2points <= 5) {
				return 100;
			}

			else if (winPoints - player2points <= 10) {
				return 75;
			}

			else if (winPoints - player2points <= 13) {
				return 50;
			}

			else {
				return 30;
			}
		}
	}
	
	public class cardYouWinHeight implements playable {
		static final String name = "You Win! (Height)";
		static final String text = "If you are the shortest player in the game you win, otherwise you get 5 points.";
		public void playCard(int Player) {	
			switch (Player) {
			case 1:
				if (heightPlayer < heightAi) {
					playerWins(1);
				}
				else {
					winPoints(1);
				}
				break;
			case 2:
				if (heightPlayer > heightAi) {
					playerWins(2);
				}
				else {
					winPoints(2);
				}
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
		public int getScore() {
			if (heightPlayer > heightAi) {
				return 100;
			}
			
			else if (winPoints - player2points <= 5) {
				return 100;
			}

			else if (winPoints - player2points <= 10) {
				return 75;
			}

			else if (winPoints - player2points <= 13) {
				return 50;
			}

			else {
				return 30;
			}
		}
	}
	
	public class cardYouWinBlue implements playable {
		static final String name = "You Win! (Blue)";
		static final String text = "If both players are wearing blue you win, otherwise you get 5 points.";
		public void playCard(int Player) {	
			if (bluePlayer == true && blueAi == true) {
				playerWins(Player);
			}
			else {
				winPoints(Player);
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
		public int getScore() {
			if (bluePlayer == true && blueAi == true) {
				return 100;
			}
			
			else if (winPoints - player2points <= 5) {
				return 100;
			}

			else if (winPoints - player2points <= 10) {
				return 75;
			}

			else if (winPoints - player2points <= 13) {
				return 50;
			}

			else {
				return 30;
			}
		}
	}
	
	public class cardYouWinGirl implements playable { 
		static final String name = "You Win! (Girl)";
		static final String text = "If you are the only girl in the game you win, otherwise you get 5 points.";
		public void playCard(int Player) {	
			switch (Player) {
			case 1:
				if (malePlayer == false && maleAi == true) {
					playerWins(1);
				}
				else {
					winPoints(1);
				}
				break;
			case 2:
				if (malePlayer == true && maleAi == false) {
					playerWins(2);
				}
				else {
					winPoints(2);
				}
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
		public int getScore() {
			if (malePlayer == true && maleAi == false) {
				return 100;
			}
			
			else if (winPoints - player2points <= 5) {
				return 100;
			}

			else if (winPoints - player2points <= 10) {
				return 75;
			}

			else if (winPoints - player2points <= 13) {
				return 50;
			}

			else {
				return 30;
			}
		}
	}
	
	public class cardCheater implements playable {
		static final String name = "Cheater";
		static final String text = "Take an extra turn. Draw 2 cards.";
		public void playCard(int Player) {
			extraTurn = true;
			Draw(Player, 2);				
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
		public int getScore() {
			return 90;
		}
	}
	
	public class cardMadTeaParty implements playable {
		static final String name = "Mad Tea Party";
		static final String text = "Switch seats with you opponent. Take an extra turn in your new posision";
		public void playCard(int Player) {	
			ArrayList<playable> testArray=new ArrayList<playable>();
			testArray = player1Hand;
			player1Hand = player2Hand;
			player2Hand = testArray;
			testArray = player1Battlefield;
			player1Battlefield = player2Battlefield;
			player2Battlefield = testArray;
			updateButtons();
			extraTurn = true;
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
		
		public int getScore() {
			return 30;
		}
	}
	
	public class cardExtraLife implements playable {
		static final String name = "Extra Life";
		static final String text = "If you would lose instead you don't. Or if you didn't lose, draw 2 cards.";
		public void playCard(int Player) {	
			Draw(Player, 2);
		}
		public void battleEffect(int Player) {

		}
		public String getName() {
			return name;
		}
		public String getText() {
			return text;
		}
		
		public int getScore() {
			return 23;
		}
	}
	
	/* Make an Object for each card/class */
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
	cardYouWinMonth kaartYouWinMonth = new cardYouWinMonth();
	cardYouWinGirl kaartYouWinGirl = new cardYouWinGirl();
	cardYouWinHeight kaartYouWinHeight = new cardYouWinHeight();
	cardYouWinBlue kaartYouWinBlue = new cardYouWinBlue();
	cardMadTeaParty kaartMadTeaParty = new cardMadTeaParty();
	cardCheater kaartCheater = new cardCheater();
	cardExtraLife kaartExtraLife = new cardExtraLife();
	
	/* Makes variablelen, bottons, labels and arraylists */
	ArrayList<playable> player1Hand=new ArrayList<playable>();
	ArrayList<playable> player2Hand=new ArrayList<playable>();
	ArrayList<playable> library=new ArrayList<playable>(); 
	ArrayList<String> Prompts = new ArrayList<String>();
	ArrayList<playable> cards = new ArrayList<playable>(); /* Contains all cards */
	ArrayList<playable> totalBattlefield = new ArrayList<playable>();
	ArrayList<playable> player1Battlefield = new ArrayList<playable>();
	ArrayList<playable> player2Battlefield = new ArrayList<playable>();
	ArrayList<playable> aiChoices = new ArrayList<playable>();
	String returnFunction = "";
	int player1points = 0;
	int player2points = 0;
	int theEndTimer = 2;
	int winPoints = 15;
	boolean Drawing = true;
	String lastAiCard;
	boolean comicSans = false; /* For now */
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
	JLabel lblNewLabel = new JLabel("History + Chat");
	JTextField chatText = new JTextField();
	
	boolean gameEnd = false;
	boolean extraTurn= false;
	Choice prompt = new Choice();
	JButton confirm = new JButton("Confirm");
	JButton chatConfirm = new JButton("->");
	
	int heightPlayer;
	boolean malePlayer;
	boolean bluePlayer;
	String monthPlayer;
	
	int heightAi;
	boolean maleAi;
	boolean blueAi;
	String monthAi;
	
	JPanel startpanel = new JPanel();
	JButton bConfirmQuestions = new JButton("Confirm!");
	JTextField tHeight = new JTextField();
	JLabel lWelcome = new JLabel("Welcome to We Didn't Playtest This at All! First, a few questions.");
	JLabel lLength = new JLabel("How tall are you? (in cm)");
	JRadioButton rGenderMale = new JRadioButton("Male");
	JRadioButton rGenderFemale = new JRadioButton("Female");
	JLabel lGender = new JLabel("What gender are you?");
	
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
	private JTextField tLength;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JLabel lBlue = new JLabel("Are you wearing blue right now?");
	private final JRadioButton bYes = new JRadioButton("Yes");
	private final JRadioButton bNo = new JRadioButton("No");
	private final JLabel lMonth = new JLabel("What month were you born in?");
	private final JComboBox cbMonth = new JComboBox();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	JLabel lAIMonth = new JLabel("");
	JLabel lAIBlue = new JLabel("");
	JLabel lAIHeight = new JLabel("");
	JLabel lAIGender = new JLabel("");
	
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
			int random;			for (int i=0; i<amount; i++) {
				random = (int) (Math.random()*library.size());
				switch (player) {
					case 1: player1Hand.add(0, library.get(random));
							updateButtons();
							break;
					case 2: player2Hand.add(0, library.get(random));
				}
			}
		}
		/* If the card No Drawing has been played this will happen */
		else {
			/* Checks if the player drawing cards has no cards in hand, if the don't they lose */
			if (player == 1 && player1Hand.size() == 0) {
				playerLoses(1);
			}

			if (player == 2 && player2Hand.size() == 0) {
				playerLoses(2);
			}
		}
	}
	
	public static String getMonth() {
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];

        return month;
    }
	
	/* Fill the player's starting hand with empty card to check against*/
	public void fillHand() {
		/* Fills all list with cards that do nothing and make things invisible. */
		/* This is to prevent Index out of bounds errors */
		for (int i=0; i<20; i++) {
			player1Hand.add(kaartNone);
			player2Hand.add(kaartNone);
			player1Battlefield.add(kaartNone);
			player2Battlefield.add(kaartNone);
			totalBattlefield.add(kaartNone);
		}
	}
	
	public void addHistory(String text) {
		if (!(gameEnd == true && text.matches("player(.*)has(.*)the game(.*)"))) {
			history.add(text);
		}
	}
	
	/* Set all text to a font */
	public void textToFont(String font) {
		b0.setFont(new Font(font, Font.PLAIN, 11));
		b1.setFont(new Font(font, Font.PLAIN, 11));
		b2.setFont(new Font(font, Font.PLAIN, 11));
		b3.setFont(new Font(font, Font.PLAIN, 11));
		b4.setFont(new Font(font, Font.PLAIN, 11));
		history.setFont(new Font(font, Font.PLAIN, 11));
		questionHeader.setFont(new Font(font, Font.PLAIN, 17));
		lblNewLabel.setFont(new Font(font, Font.PLAIN, 17));
		chatText.setFont(new Font(font, Font.PLAIN, 11));
		prompt.setFont(new Font(font, Font.PLAIN, 11));
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		addHistory("Your opponent chose " + choice + ".  ");
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
	
	public void winPoints(int Player) {
		switch (Player) {
		case 1 :	player1points += 5;
					player1Battlefield.add(kaartYouWinMonth);
					if (player1points >= winPoints) {
						playerWins(1);
					}
					break;
		case 2 :	player2points += 5;
					player2Battlefield.add(kaartYouWinMonth);
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
		addHistory("Your opponent played: " + lastAiCard + ". ");
		for (int i=0; i<player2Battlefield.size(); i++) {
			playable testObject = player2Battlefield.get(i);
			testObject.battleEffect(2);
		}
		if (extraTurn) {
			AIPlaysCard();
		}
		else if (gameEnd) {
			b0.setEnabled(false);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			prompt.setEnabled(false);
			confirm.setEnabled(false);
			chatConfirm.setEnabled(false);
	}
		else {
			b0.setEnabled(true);
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);


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
	
	public void confirmQuestions() {
		startpanel.setVisible(false);
		b0.setVisible(true);
		b1.setVisible(true);
		b2.setVisible(true);
		confirm.setVisible(true);
		chatConfirm.setVisible(true);
		heightPlayer = Integer.parseInt(tHeight.getText());
		monthPlayer = (String)cbMonth.getSelectedItem();
		if (rGenderMale.isSelected()) {
			malePlayer = true;
		}
		else {
			malePlayer = false;
		}
		if (bYes.isSelected()) {
			bluePlayer = true;
		}
		else {
			bluePlayer = false;
		}
		
	}
	
	public void updateButtons() {
		b0.setText("<html> <b>" + player1Hand.get(0).getName() + "</b> <br />" + player1Hand.get(0).getText() + "  </html>");
		b1.setText("<html> <b>" + player1Hand.get(1).getName() + "</b> <br />" + player1Hand.get(1).getText() + "  </html>");
		b2.setText("<html> <b>" + player1Hand.get(2).getName() + "</b> <br />" + player1Hand.get(2).getText() + "  </html>");
		b3.setText("<html> <b>" + player1Hand.get(3).getName() + "</b> <br />" + player1Hand.get(3).getText() + "  </html>");
		b4.setText("<html> <b>" + player1Hand.get(4).getName() + "</b> <br />" + player1Hand.get(4).getText() + "  </html>");
		
		if (maleAi) {
			lAIGender.setText("The enemy is male.");
		}
		else {
			lAIGender.setText("The enemy is female.");
		}
		if (blueAi) {
			lAIBlue.setText("The enemy is wearing blue.");
		}
		else {
			lAIBlue.setText("The enemy is not wearing blue.");
		}
		lAIHeight.setText("The enemy is " + String.valueOf(heightAi) + " cm tall.");
		lAIMonth.setText("The enemy was born in " + monthAi + ".");
		
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
		addHistory("Your opponent played: " + lastAiCard + ". ");
		for (int i=0; i<player2Battlefield.size(); i++) {
			playable testObject = player2Battlefield.get(i);
			testObject.battleEffect(2);
		}
		if (extraTurn) {
			AIPlaysCard();
		}
		else if (gameEnd) {
			b0.setEnabled(false);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			prompt.setEnabled(false);
			confirm.setEnabled(false);
			chatConfirm.setEnabled(false);
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
		addHistory("Player " + Integer.toString(player) + " has lost the game.");
		switch (player) {
		case 1:
			if (player1Hand.contains(kaartExtraLife)) {
				addHistory("But player 1 used an extra life.");
				for (int i=0; i<player1Hand.size(); i++) {
					playable testObject = player1Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player1Hand.remove(i);
						break;
					}
				}
			}
			else {
				gameEnd = true;
			}
			break;
		case 2:
			if (player2Hand.contains(kaartExtraLife)) {
				addHistory("But player 2 used an extra life.");				for (int i=0; i<player2Hand.size(); i++) {
					playable testObject = player2Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player2Hand.remove(i);
						break;
					}
				}
			}
			else {
				gameEnd = true;
			}
			break;
		case 3:
			if (player2Hand.contains(kaartExtraLife) && player1Hand.contains(kaartExtraLife)) {
				addHistory("But both players used an extra life.");
				for (int i=0; i<player1Hand.size(); i++) {
					playable testObject = player1Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player1Hand.remove(i);
						break;
					}
				}
				for (int i=0; i<player2Hand.size(); i++) {
					playable testObject = player2Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player2Hand.remove(i);
						break;
					}
				}
			}
			else if (player2Hand.contains(kaartExtraLife)) {
				addHistory("But players 2 used an extra life.");
				addHistory("So player 2 wins.");
				for (int i=0; i<player2Hand.size(); i++) {
					playable testObject = player2Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player2Hand.remove(i);
						break;
					}
				}
				gameEnd = true;
			}
			else if (player1Hand.contains(kaartExtraLife)) {
				addHistory("But players 1 used an extra life.");
				addHistory("So player 1 wins.");
				gameEnd = true;
				for (int i=0; i<player1Hand.size(); i++) {
					playable testObject = player1Hand.get(i);
					String name = testObject.getName();
					if ("Extra Life" == name) {
						player1Hand.remove(i);
						break;
					}
				}
			}
			else {
				addHistory("Both players lost the game.");
				gameEnd = true;
			}
		}
	}
	
	/* Makes a player wins the game */
	public void playerWins(int player) {
		if (player == 3) {
			addHistory("player 1 has won the game.  ");
			addHistory("player 2 has won the game.  ");
		}
		else {
			addHistory("player " + player + " has won the game.  ");
		}
		gameEnd = true;
	}
	
	/* calls all functions that have to happen at the start of the game */
	public void startOfGame() {
		fillLibrary(10);
		fillHand();
		int random = (int) (Math.random() * 2);
		switch (random) {
		case 0: maleAi = true;
				break;
		case 1: maleAi = false;
		}
		random = (int) (Math.random() * 2);
		switch (random) {
		case 0: blueAi = true;
				break;
		case 1: blueAi = false;
		}
		random = (int) (Math.random() * 100 + 120);
		heightAi = random;
		random = (int) (Math.random() * 11);
		String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
		monthAi = monthName[random];
		confirm.setVisible(true);
	}
	
	/* If you give this a cardname it will activate that cards effect */
	public void runCard(String Name, int Player, boolean special) {
		if (gameEnd == true) {
			return;
		}
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
			addHistory("You played: " + Name + ". ");
			for (int i=0; i<player1Battlefield.size(); i++) {
				playable testObject = player1Battlefield.get(i);
				testObject.battleEffect(1);
			}
			if (extraTurn && special == true) {
				extraTurn = false;
				Draw(1,1);
				updateButtons();
			}
			else if (gameEnd) {
				b0.setEnabled(false);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				prompt.setEnabled(false);
				confirm.setEnabled(false);
				chatConfirm.setEnabled(false);
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
	
	/* Does the Ai's turn */
	public void AIPlaysCard() {
		Draw(2, 1);
		if (comicSans == true) {
			addHistory("Comic Sans is awesome");
		}
		if (zombies == true) {
			addHistory("AHH! Zombies!");
		}
		aiChoices.clear();
		int maxScore = 0;
		for (int i=0; i<player2Hand.size(); i++) {
			if (player2Hand.get(i).getScore() > maxScore) {
				aiChoices.clear();
				aiChoices.add(player2Hand.get(i));
				maxScore = player2Hand.get(i).getScore();
			}
			if (player2Hand.get(i).getScore() == maxScore) {
				aiChoices.add(player2Hand.get(i));
			}
		}
		int random = (int) Math.random() * aiChoices.size();
		lastAiCard = aiChoices.get(random).getName();
		runCard(aiChoices.get(random).getName(), 2, true);
		/* Only happens if the AI's turn ends here */
		if (prompt.isVisible() == false) { 
			addHistory("Your opponent played: " + lastAiCard + ". ");
			for (int i=0; i<player2Battlefield.size(); i++) {
				playable testObject = player2Battlefield.get(i);
				testObject.battleEffect(2);
			}
			if (extraTurn) {
				extraTurn = false;
				AIPlaysCard();
			}
			else if (gameEnd) {
					b0.setEnabled(false);
					b1.setEnabled(false);
					b2.setEnabled(false);
					b3.setEnabled(false);
					b4.setEnabled(false);
					prompt.setEnabled(false);
					confirm.setEnabled(false);
					chatConfirm.setEnabled(false);
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
	/* bruh bruh stopper */
	
	
	
	/*Front End (Mostly) */
	public DidntPlaytest() {
		
		
		confirm.setBounds(893, 673, 113, 37);
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
		cards.add(kaartYouWinMonth);
		cards.add(kaartYouWinGirl);
		cards.add(kaartYouWinHeight);
		cards.add(kaartYouWinBlue);
		cards.add(kaartCheater);
		cards.add(kaartMadTeaParty);
		cards.add(kaartExtraLife);
		startOfGame();
		Draw(1, 3);
		Draw(2, 2);
		updateButtons();
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
		prompt.setBounds(883, 647, 137, 20);
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
		contentPane.setLayout(null);
		

		b0.setVisible(false);
		b1.setVisible(false);
		b2.setVisible(false);
		confirm.setVisible(false);
		chatConfirm.setVisible(false);
		
		
		
		startpanel.setBounds(0, 0, 1394, 965);
		contentPane.add(startpanel);
		startpanel.setLayout(null);
		
		
		bConfirmQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmQuestions();
			}
		});
		bConfirmQuestions.setBounds(643, 340, 89, 23);
		startpanel.add(bConfirmQuestions);
		
	
		tHeight.setBounds(521, 238, 86, 20);
		startpanel.add(tHeight);
		tHeight.setColumns(10);
		
		
		lWelcome.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lWelcome.setBounds(362, 147, 643, 43);
		startpanel.add(lWelcome);
		
		
		lLength.setBounds(507, 213, 161, 14);
		startpanel.add(lLength);
		
		
		buttonGroup.add(rGenderMale);
		rGenderMale.setBounds(375, 237, 109, 23);
		startpanel.add(rGenderMale);
		
		
		buttonGroup.add(rGenderFemale);
		rGenderFemale.setBounds(375, 268, 109, 23);
		startpanel.add(rGenderFemale);
		
		
		
		
		lGender.setBounds(347, 213, 137, 14);
		startpanel.add(lGender);
		lBlue.setBounds(873, 215, 212, 14);
		
		startpanel.add(lBlue);
		buttonGroup_1.add(bYes);
		bYes.setBounds(932, 240, 109, 23);
		
		startpanel.add(bYes);
		buttonGroup_1.add(bNo);
		bNo.setBounds(932, 271, 109, 23);
		
		startpanel.add(bNo);
		lMonth.setBounds(678, 215, 185, 14);
		
		startpanel.add(lMonth);
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonth.setBounds(703, 238, 110, 20);
		
		startpanel.add(cbMonth);
		contentPane.add(b0);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(prompt);
		contentPane.add(confirm);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(883, 300, 221, 46);
		contentPane.add(lblNewLabel);
		
		history.setBounds(883, 352, 221, 232);
		contentPane.add(history);
		
		questionHeader.setHorizontalAlignment(SwingConstants.CENTER);
		questionHeader.setFont(new Font("Tahoma", Font.PLAIN, 17));
		questionHeader.setBounds(305, 208, 275, 37);
		contentPane.add(questionHeader);
		
		chatText.setBounds(883, 590, 165, 20);
		contentPane.add(chatText);
		chatText.setColumns(10);
		
		
		chatConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addHistory("P1: " + chatText.getText());
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
				if (chatText.getText().toLowerCase().equals("/aihand")) {
					for (int i = 0; i < player2Hand.size(); i++) {
						String cardName = player2Hand.get(i).getName();
						if (cardName.equals("nothing")) {
							break;
						}
						history.add("Console: " + cardName);
					}
				}
				
				if (chatText.getText().toLowerCase().equals("/aihandsize")) {
					int handSize = 0;
					for (int i = 0; i < player2Hand.size(); i++) {
						if (player2Hand.get(i).getName().equals("nothing")) {
							break;
						}
						handSize++;
					}
					history.add("Console: Handsize = " + handSize);
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
		chatConfirm.setBounds(1058, 590, 46, 23);
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
		
		
		lAIMonth.setBounds(189, 66, 343, 20);
		contentPane.add(lAIMonth);
		lAIBlue.setBounds(189, 86, 343, 20);
		
		contentPane.add(lAIBlue);
		lAIHeight.setBounds(189, 47, 343, 20);
		
		contentPane.add(lAIHeight);
		lAIGender.setBounds(189, 27, 343, 20);
		
		contentPane.add(lAIGender);
		
		
		
		// main game loop //
		textToFont("Tahoma");
	}
}

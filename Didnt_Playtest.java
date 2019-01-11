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

/* Part of Eclipse */
public class Didnt_Playtest extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Didnt_Playtest frame = new Didnt_Playtest();
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
		public String getName();
		public String getText();
	}
	
	/* Make all the cards ass classes*/
	public class cardNone implements playable {
		public void playCard(int Player) {
			
		}
		public String getName() {
			return "nothing";
		}
		public String getText() {
			return "nothing";
		}
	}
	
	public class cardPc implements playable {
		/* the name and card text */
		static final String name = "PC";
		static final String text = "Everybody wins";
		/* the effect of the card */
		public void playCard(int Player) {
			playerWins(1);
			playerWins(2);
		}
		/* the way to find the name and text of the card */
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
	
	/* Variablelen aanmaken */
	 ArrayList<playable> player1Hand=new ArrayList<playable>();
	 ArrayList<playable> player2Hand=new ArrayList<playable>();
	 ArrayList<playable> library=new ArrayList<playable>(); 
	 ArrayList<String> Prompts = new ArrayList<String>();
	 ArrayList<playable> cards = new ArrayList<playable>();
	 String returnFunction = "";
		
	/* Alles objecten predifineren */
	JLabel l1 = new JLabel("");
	JButton b0 = new JButton("");
	JButton b1 = new JButton("");
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	
	Choice prompt = new Choice();
	JButton confirm = new JButton("Confirm");
	private final JButton btnTestprompt = new JButton("TESTPROMPT");
	private JTextField test;
	
	/* Basis Functies */
	
	/* Adds cards from the library to the hand */
	public void Draw(int player, int amount) {
		int random;
		for (int i=0; i<amount; i++) {
			random = (int) (Math.random()*library.size());
			switch (player) {
				case 1: player1Hand.add(library.get(random));
				case 2: player2Hand.add(library.get(random));
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
	
	/* The function all the Battle! cards call to do their effect */
	public void RockPaperScissors(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("Rock");
		Prompts.add("Paper");
		Prompts.add("Scissors");
		returnFunction = Loses;
		callPrompt();
	}
	
	/* The function all the Numbers cards call to do their effect */
	public void numbers(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("1");
		Prompts.add("2");
		Prompts.add("3");
		Prompts.add("4");
		Prompts.add("5");
		returnFunction = Loses;
		callPrompt();
	}
	
	/* the function the confirm button calls for Battle! cards */
	public void RockPaperScissorsDone(String Loses, String Picked) {
		if (Loses == Picked) {
			playerLoses(1);
		}
	}
	
	public void numbersDone(String Loses, String Picked) {
		if (Loses == "Even" && (Picked == "2" || Picked == "4")) {
			playerLoses(1);
		}
		if (Loses == "Odd" && (Picked == "1" || Picked == "3" || Picked == "5")) {
			playerLoses(1);
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
		l1.setText(l1.getText() + "player " + player + " has lost the game.  ");
	}
	
	/* Makes a player wins the game */
	public void playerWins(int player) {
		l1.setText(l1.getText() + player + " has won the game.  ");
		System.exit(0);
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
	}
	
	/* If you give this a card-name it will activate that cards effect */
	public void AIPlaysCard() {
		 int random = (int) Math.random() * player2Hand.size();
		 runCard(player2Hand.get(random).getName(), 2);
		 player2Hand.remove(random);
	}
	
	/*Front End (Mostly) */
	public Didnt_Playtest() {
		confirm.setBounds(382, 301, 113, 37);
		confirm.setVisible(false);
		cards.add(kaartPc);
		cards.add(kaartILose);
		cards.add(kaartBattleRock);
		cards.add(kaartBattlePaper);
		cards.add(kaartBattleScissors);
		player1Hand.add(kaartBattleRock);
		player1Hand.add(kaartBattlePaper);
		player1Hand.add(kaartBattleScissors);
		player1Hand.add(kaartILose);
		player1Hand.add(kaartILose);
		startOfGame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		b0.setBounds(30, 514, 125, 139);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(0).getName(), 1);
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
		b1.setBounds(200, 514, 125, 139);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(1).getName(), 1);
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
		b2.setBounds(370, 514, 125, 139);
		

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(2).getName(), 1);
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
		b3.setBounds(540, 514, 125, 139);
		

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(3).getName(), 1);
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
		b4.setBounds(710, 514, 125, 139);
		

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(4).getName(), 1);
			}
		});
		String cardInHand4 = player1Hand.get(4).getName();
		b4.setText(player1Hand.get(4).getName());
		
		JLabel Display = new JLabel("New label");
		Display.setBounds(59, 164, 583, 52);
		
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
			}
		});
		btnTestprompt.setBounds(96, 130, 89, 23);
		btnTestprompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callPrompt();
			}
		});
		contentPane.setLayout(null);
		l1.setBounds(10, 21, 768, 74);
		contentPane.add(l1);
		contentPane.add(b0);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		contentPane.add(Display);
		contentPane.add(prompt);
		contentPane.add(confirm);
		contentPane.add(btnTestprompt);
		
		
	}
}

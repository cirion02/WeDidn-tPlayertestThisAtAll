

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

public class Didnt_Playtest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	
	/**
	 * Create the frame.
	 */
	
	
	public interface playable {
		public void playCard(int player);
		public String getName();
		public String getText();
	}
	

	String returnFunction = "";
	ArrayList<playable> cards=new ArrayList<playable>();
	
	
	
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
		static final String name = "PC";
		static final String text = "Everybody wins";
		public void playCard(int Player) {
			playerWins(1);
			playerWins(2);
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
	
	cardPc kaartPc = new cardPc();
	cardILose kaartILose = new cardILose();
	cardNone kaartNone = new cardNone();
	cardBattleRock kaartBattleRock = new cardBattleRock();
	
	/* Variablelen aanmaken */
	 ArrayList<playable> player1Hand=new ArrayList<playable>();
	 ArrayList<playable> player2Hand=new ArrayList<playable>();
	 ArrayList<playable> library=new ArrayList<playable>(); 
	 ArrayList<String> Prompts = new ArrayList<String>();

	/* Alles predifineren */
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
	
	public void fillHand() {
		for (int i=0; i<20; i++) {
			player1Hand.add(kaartNone);
			player2Hand.add(kaartNone);
		}
	}
	
	public void callPrompt() {
		prompt.setVisible(true);
		for (int i=0; i<Prompts.size(); i++) {
			String choice = Prompts.get(i);
			prompt.add(choice);
		}
		confirm.setVisible(true);
	}
	
	public void RockPaperScissors(String Loses, int Player) {
		Prompts.clear();
		Prompts.add("Rock");
		Prompts.add("Paper");
		Prompts.add("Scissors");
		returnFunction = Loses;
		callPrompt();
	}
	
	public void RockPaperScissorsDone(String Loses, String Picked) {
		if (Loses == Picked) {
			playerLoses(1);
		}
	}
	
	public void fillLibrary(int amount) {
		for (int i=0; i<amount; i++) {
			for (int t=0; t<cards.size(); t++) {
				library.add(cards.get(t));
			}
		}
	}
	
	public void playerLoses(int player) {
		l1.setText(l1.getText() + "player " + player + " has lost the game.  ");
	}
	
	public void playerWins(int player) {
		l1.setText(l1.getText() + player + " has won the game.  ");
	}
	
	public void startOfGame(){
		fillLibrary(10);
		fillHand();
	}
	
	public void runCard(String Name, int Player) {
		for (int i=0; i<cards.size(); i++) {
			playable testObject = cards.get(i);
			String name = testObject.getName();
			if (Name == name) {
				testObject.playCard(Player);
			}
		}
	}
	
	public void AIPlaysCard() {
		 int random = (int) Math.random() * player2Hand.size();
		 runCard(player2Hand.get(random).getName(), 2);
		 player2Hand.remove(random);
	}
	
	public Didnt_Playtest() {
		confirm.setVisible(false);
		cards.add(kaartPc);
		cards.add(kaartILose);
		cards.add(kaartBattleRock);
		player1Hand.add(kaartBattleRock);
		player1Hand.add(kaartILose);
		player1Hand.add(kaartILose);
		player1Hand.add(kaartILose);
		player1Hand.add(kaartILose);
		startOfGame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		l1.setBounds(10, 21, 768, 74);
		contentPane.add(l1);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(0).getName(), 1);
			}
		});
		String cardInHand0 = player1Hand.get(0).getName();
		b0.setText(player1Hand.get(0).getName());
		contentPane.add(b0);
		b0.setBounds(30, 514, 125, 139);
		
		switch (cardInHand0) {
		case "nothing": b0.setVisible(false);
						break;
		default: 		b0.setVisible(true);	
						break;
		}
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(1).getName(), 1);
			}
		});
		String cardInHand1 = player1Hand.get(1).getName();
		b1.setText(player1Hand.get(1).getName());
		contentPane.add(b1);
		b1.setBounds(200, 514, 125, 139);
		
		switch (cardInHand1) {
		case "nothing": b1.setVisible(false);
						break;
		default: 		b1.setVisible(true);	
						break;
		}
		

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(2).getName(), 1);
			}
		});
		String cardInHand2 = player1Hand.get(2).getName();
		b2.setText(player1Hand.get(2).getName());
		contentPane.add(b2);
		b2.setBounds(370, 514, 125, 139);
		
		switch (cardInHand2) {
		case "nothing": b2.setVisible(false);
						break;
		default: 		b2.setVisible(true);	
						break;
		}
		

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(3).getName(), 1);
			}
		});
		String cardInHand3 = player1Hand.get(3).getName();
		b3.setText(player1Hand.get(3).getName());
		contentPane.add(b3);
		b3.setBounds(540, 514, 125, 139);
		
		switch (cardInHand3) {
		case "nothing": b3.setVisible(false);
						break;
		default: 		b3.setVisible(true);	
						break;
		}
		

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runCard(player1Hand.get(4).getName(), 1);
			}
		});
		String cardInHand4 = player1Hand.get(4).getName();
		b4.setText(player1Hand.get(4).getName());
		contentPane.add(b4);
		b4.setBounds(710, 514, 125, 139);
		
		JLabel Display = new JLabel("New label");
		Display.setBounds(59, 164, 583, 52);
		contentPane.add(Display);
		
		switch (cardInHand4) {
		case "nothing": b4.setVisible(false);
						break;
		default: 		b4.setVisible(true);	
						break;
		}
		
		prompt.setBounds(382, 275, 113, 40);
		contentPane.add(prompt);
		prompt.setVisible(false);
		


		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String finalChoice = prompt.getSelectedItem();
				if (returnFunction == "Rock" || returnFunction == "Paper" || returnFunction == "Scissors") {
					RockPaperScissorsDone(returnFunction, finalChoice);
				}
				test.setText(finalChoice);
			}
		});
		confirm.setBounds(382, 301, 113, 37);
		contentPane.add(confirm);
		btnTestprompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callPrompt();
			}
		});
		btnTestprompt.setBounds(96, 130, 89, 23);

		contentPane.add(btnTestprompt);
		
		
	}
}

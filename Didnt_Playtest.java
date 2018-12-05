import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Didnt_Playtest.cardILose;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.awt.event.ActionEvent;

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
	
	
	ArrayList<Object> cards=new ArrayList<Object>();
	
	public class cardPc {
		static final String name = "PC";
		static final String text = "Everybody wins";
		public void playCard(String Player) {
			playerWins("Player 1");
			playerWins("Player 2");
		}
		public String getName() {
			return name;
		}
	}
	
	public class cardILose {
		static final String name = "I Lose";
		static final String text = "You Lose";
		public void playCard(String Player) {
			playerLoses(Player);
		}
		public String getName() {
			return name;
		}
	}
	
	cardPc kaartPc = new cardPc();
	cardILose kaartILose = new cardILose();
	
	/* Variablelen aanmaken */
	 ArrayList<String> player1Hand=new ArrayList<String>();
	 ArrayList<String> player2Hand=new ArrayList<String>();

	/* Alles predifineren */
	JLabel l1 = new JLabel("");
	JButton b1 = new JButton("PC");
	
	
	/* Basis Functies */
	public void playerLoses(String player) {
		l1.setText(l1.getText() + player + " has lost the game.  ");
	}
	
	public void playerWins(String player) {
		l1.setText(l1.getText() + player + " has won the game.  ");
	}
	
	/* Kaarten */
	public void cardPc(String player) {
		playerWins("Player 1");
		playerWins("Player 2");
	}
	
	public void cardILose(String player) {
		playerLoses(player);
	}
	
	
	public void startOfGame(){
		int random = (int) (Math.random()*2+1);
		if (random == 1) {
			b1.setText("PC");
		}
		if (random == 2) {
			b1.setText("I Lose");
		}
	}
	
	public void runCard(String Name, String Player) {
		for (int i=0; i<cards.size(); i++) {
			Object testObject = cards.get(i);
			String name = ((Component) testObject).getName();
			//if (Name == name) {
			//	testObject.playCard(Player);
			//}
		}
	}
	
	/* Put the Cards in the Deck */
	
	
	
	public Didnt_Playtest() {
		cards.add(kaartPc);
		cards.add(kaartILose);
		kaartPc.playCard("Me");
		Object testObject = kaartPc;
		testObject.playCard("Me");
		startOfGame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runCard("PC", "Me");
			}
		});
		b1.setBounds(10, 514, 125, 139);
		contentPane.add(b1);
		l1.setBounds(10, 21, 768, 74);
		contentPane.add(l1);
		
		
	
		
		
	}
	
}


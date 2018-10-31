import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
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
	/* Alles predifineren */
	JLabel l1 = new JLabel("");
	
	
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
	
	
	public Didnt_Playtest() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("PC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPc("Me");
			}
		});
		btnNewButton.setBounds(90, 420, 125, 139);
		contentPane.add(btnNewButton);
		l1.setBounds(10, 21, 768, 74);
		contentPane.add(l1);
		
	
		
		
	}
	
}


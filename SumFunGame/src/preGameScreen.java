import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class preGameScreen extends JFrame {

	private JPanel mainPanel;
	private JButton btnUntimed;
	private JButton btnTimed;
	private JTextField txtName;
	private JLabel lblName;

	public preGameScreen() {
		mainPanel = new JPanel();
		// GridLayout mainLayout = new GridLayout(2,2);
		// mainPanel.setLayout(mainLayout);

		btnUntimed = new JButton("Start Untimed Game");
		btnUntimed.addActionListener(new untimedListener());
		btnTimed = new JButton("Start Timed Game");
		btnTimed.addActionListener(new timedListener());
		lblName = new JLabel("Name: ");
		txtName = new JTextField("");
		txtName.setColumns(15);

		mainPanel.add(lblName);
		mainPanel.add(txtName);
		mainPanel.add(btnUntimed);
		mainPanel.add(btnTimed);

		add(mainPanel);
		setSize(350, 100);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Sum Fun Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class untimedListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(txtName.getText().length() > 0){
				try {
					GameBoard firstGame = new UntimedGame(txtName.getText());
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				preGameScreen.this.dispose();
			}
		}
	}

	private class timedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(txtName.getText().length() > 0){
				try {
					GameBoard firstGame = new TimedGame(txtName.getText());
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				preGameScreen.this.dispose();
			}
		}
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}
}

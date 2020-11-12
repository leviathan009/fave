import java.awt.BorderLayout;

import Datenbank.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	private JFrame mainFrame;
	
	public GUI(DataModel dm) {
		
		//** North
		JPanel northPanel = new JPanel(new GridBagLayout());
		northPanel.setLayout(new GridBagLayout());
		GridBagConstraints northGbc = new GridBagConstraints();
		JLabel titleLabel = new JLabel("FaVe - Fahrradverwaltung");
		titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		northGbc.insets = new Insets(20,0,20,0);
		northPanel.add(titleLabel, northGbc);
		
		//** Center
		//Search bar
		JPanel searchPanel = new JPanel();
		JLabel searchLabel = new JLabel("Suchen");
		JTextField searchTF = new JTextField();
		searchPanel.add(searchLabel);
		searchPanel.add(searchTF);
		
		//List
		JList list = new JList();
		list.setPreferredSize(new Dimension(400,200));
		
		//Buttons
		JPanel buttonPanel = new JPanel();
		
		JButton releaseBtn = new JButton("Freigeben");
		releaseBtn.addActionListener(new ReleaseListener());
		buttonPanel.add(releaseBtn);
		
		JButton setBtn = new JButton("Besetzen");
		setBtn.addActionListener(new SetListener());
		buttonPanel.add(setBtn);
		
		JButton accountsBtn = new JButton("Stammdaten");
		accountsBtn.addActionListener(new AccountsListener());
		buttonPanel.add(accountsBtn);
		
		//list info
		JPanel infoPanel = new JPanel();
		JLabel infoTitle = new JLabel("Details:");
		infoTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13 ));
		infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
		infoPanel.add(infoTitle);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.weightx = 1;
		gbc.gridy = 1;
		centerPanel.add(list, gbc);
		gbc.gridy = 2;
		centerPanel.add(buttonPanel, gbc);
		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridheight =2;
		centerPanel.add(infoPanel, gbc);
		
		mainFrame = new JFrame();
		
		mainFrame.getContentPane().add(BorderLayout.NORTH, northPanel);
		mainFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		
		mainFrame.setTitle("FaVe");
		mainFrame.pack();
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
	private class ReleaseListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class SetListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class AccountsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class DetailsPanel extends JPanel {
		private String description, value;
		private JPanel idPnl = new JPanel(), descriptionPnl = new JPanel(), statePnl = new JPanel();
		public DetailsPanel() {
			super();
			this.setLayout(new GridLayout(3,3));
			this.add(new JLabel("ID:"));
			this.add(new JLabel("Beschreibung:"));
			this.add(new JLabel("Status:"));
			this.add(idPnl);
			this.add(descriptionPnl);
			this.add(statePnl);
		}
		
		public void updateInformation(String idArg) {
			
		}
	}
	
}

package fave;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Datenbank.Customer;
import Datenbank.DataModel;

public class GUI {
	private JFrame mainFrame;
	private JList list;
	private DefaultListModel<String> listModel;
	private DataModel dataModel;
	private DetailsPanel detailsPanel;
	private Vector<Integer> ids;
	
	public GUI(DataModel dm) {
		dataModel = dm;
		
		//** Setup
		ids = new Vector<Integer>();
		
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
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.addListSelectionListener(new MyListSelectionListener());
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jsp = new JScrollPane();
		jsp.getViewport().setView(list);
		jsp.setPreferredSize(new Dimension(400,200));
		
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
		detailsPanel = new DetailsPanel();
		infoTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13 ));
		infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
		infoPanel.add(infoTitle);
		infoPanel.add(detailsPanel);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.weightx = 1;
		gbc.gridy = 1;
		centerPanel.add(jsp, gbc);
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
		updateView();
	}
	
	public void updateView() {
		listModel.clear();
		ids.clear();
		Customer c;
		for(Integer id : dataModel.getAllCustomers().keySet()) {
			c = dataModel.getCustomerByID(id);
			listModel.addElement(c.getFullName());
			ids.add(c.getId());
		}
	}
	
	private class MyListSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			detailsPanel.updateView();
		}
		
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
		private JLabel idLbl = new JLabel(), descriptionLbl = new JLabel(), stateLbl = new JLabel(), firstNameLbl = new JLabel(), lastNameLbl = new JLabel();
		public DetailsPanel() {
			super();
			this.setLayout(new GridLayout(5,5));
			this.add(new JLabel("ID:"));
			this.add(idLbl);
			this.add(new JLabel("Vorname:"));
			this.add(firstNameLbl);
			this.add(new JLabel("Nachname:"));
			this.add(lastNameLbl);
			this.add(new JLabel("Beschreibung:"));
			this.add(descriptionLbl);
			this.add(new JLabel("Status:"));
			this.add(stateLbl);
		}
		
		public void updateView() {
			Customer c;
			c = dataModel.getCustomerByID(ids.elementAt(list.getSelectedIndex()));
			idLbl.setText("" + c.getId());
			firstNameLbl.setText(c.getFirstName());
			lastNameLbl.setText(c.getLastName());
			mainFrame.pack();
		}
	}
	
}

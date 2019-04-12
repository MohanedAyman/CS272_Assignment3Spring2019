package busStation;

import java.awt.EventQueue;

import javax.naming.ldap.ManageReferralControl;
import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.ComboBoxEditor;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;

public class Gui {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTable table;
	private JTextField textField;
	private int current=-1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_13;
	private JTextField textField_12;
	private JTextField textField_14;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActions.ticketsReadFromFile();
					AdminActions.userReadFromFile();
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_362727705009796");
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_362977959886803");
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(51, 13, 99, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(51, 71, 112, 14);
		panel.add(lblPassword);
		
		JRadioButton rdbtnPassenger = new JRadioButton("Passenger");
		rdbtnPassenger.setBounds(51, 115, 109, 23);
		panel.add(rdbtnPassenger);
		
		JRadioButton rdbtnEmployee = new JRadioButton("Driver");
		rdbtnEmployee.setBounds(51, 141, 109, 23);
		panel.add(rdbtnEmployee);
		
		passwordField = new JPasswordField();
		passwordField.setText("");
		passwordField.setBounds(51, 88, 185, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(246, 39, 109, 46);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnManger = new JRadioButton("Manger");
		rdbtnManger.setBounds(51, 167, 109, 23);
		panel.add(rdbtnManger);
		 ButtonGroup group = new ButtonGroup();
		    group.add(rdbtnManger);
		    group.add(rdbtnEmployee);
		    group.add(rdbtnPassenger);
		JButton btnCreatePassengerAccount = new JButton("Create passenger account");
		
		
		
		btnCreatePassengerAccount.setBounds(50, 197, 209, 23);
		panel.add(btnCreatePassengerAccount);
		
		textField = new JTextField();
		textField.setBounds(49, 38, 187, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setText(null);
				textField.setText(null);
			}
		});
		btnReset.setBounds(246, 115, 109, 46);
		panel.add(btnReset);
		
		JLabel lblWelcomeToRoad = new JLabel("Welcome to Road Trip!");
		lblWelcomeToRoad.setFont(new Font("Segoe Script", Font.PLAIN, 25));
		lblWelcomeToRoad.setBounds(86, 301, 328, 89);
		panel.add(lblWelcomeToRoad);
		
		
		
		String[][] data = AdminActions.ticketsRet(); 
		
		
		String[] columnNames = { "ticketNo","vehicle","type","seats","price","source","destination","date","time","drivername"}; 
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 191, 653, 234);
        panel_1.add(scrollPane);
   
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowSelectionAllowed(true);
        JLabel lblNewLabel = new JLabel("NAME:");
        lblNewLabel.setBounds(51, 29, 46, 14);
        panel_1.add(lblNewLabel);
        //
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(data, columnNames);
     
        
        //
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(51, 54, 124, 14);
        panel_1.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("CREATE ");
        btnNewButton_1.setBounds(412, 25, 89, 23);
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("DELETE");
        btnNewButton_2.setBounds(535, 25, 89, 23);
        panel_1.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("CREATE NEW ACCOUNTS");
        btnNewButton_3.setBounds(412, 128, 212, 23);
        panel_1.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("UNBOOK");
        btnNewButton_4.setBounds(535, 59, 89, 23);
        panel_1.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("BOOK");
        btnNewButton_5.setBounds(412, 59, 89, 23);
        panel_1.add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton("SAVE");
      
        btnNewButton_6.setBounds(535, 93, 89, 23);
        panel_1.add(btnNewButton_6);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(151, 29, 193, 14);
        panel_1.add(lblNewLabel_2);
        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(412, 93, 89, 23);
        panel_1.add(btnLogout);
        
        JPanel panel_3 = new JPanel();
        frame.getContentPane().add(panel_3, "name_278957989416523");
        panel_3.setLayout(null);
        
        textField_1 = new JTextField();
        textField_1.setBounds(176, 11, 176, 26);
        panel_3.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(176, 48, 176, 26);
        panel_3.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(176, 85, 176, 26);
        panel_3.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(176, 122, 176, 26);
        panel_3.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(176, 159, 176, 26);
        panel_3.add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(176, 196, 176, 26);
        panel_3.add(textField_6);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(176, 233, 176, 26);
        panel_3.add(textField_7);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(176, 307, 176, 26);
        panel_3.add(textField_9);
        
        JLabel lblTicket = new JLabel("Ticket #");
        lblTicket.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTicket.setBounds(46, 18, 92, 19);
        panel_3.add(lblTicket);
        
        JLabel lblVehicle = new JLabel("Vehicle");
        lblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblVehicle.setBounds(46, 54, 92, 19);
        panel_3.add(lblVehicle);
        
        JLabel lblSource = new JLabel("Source");
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSource.setBounds(46, 91, 92, 19);
        panel_3.add(lblSource);
        
        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDestination.setBounds(46, 128, 92, 19);
        panel_3.add(lblDestination);
        
        JLabel lblType = new JLabel("Type");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblType.setBounds(46, 161, 92, 19);
        panel_3.add(lblType);
        
        JLabel lblSeats = new JLabel("Seats");
        lblSeats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSeats.setBounds(46, 202, 92, 19);
        panel_3.add(lblSeats);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrice.setBounds(46, 239, 92, 19);
        panel_3.add(lblPrice);
        
        JLabel lblTicket_1 = new JLabel("Date");
        lblTicket_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTicket_1.setBounds(46, 276, 92, 19);
        panel_3.add(lblTicket_1);
        
        JLabel lblDriverName = new JLabel("Driver Name");
        lblDriverName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDriverName.setBounds(46, 313, 106, 19);
        panel_3.add(lblDriverName);
        
        JLabel lblTimeHm = new JLabel("Time H/M");
        lblTimeHm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTimeHm.setBounds(46, 347, 92, 19);
        panel_3.add(lblTimeHm);
        
        JButton btnNewButton_7 = new JButton("Return");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		panel_3.setVisible(false);
				panel_1.setVisible(true);
        	}
        });
        btnNewButton_7.setBounds(176, 402, 76, 23);
        panel_3.add(btnNewButton_7);
        
        JButton btnConfirm = new JButton("Confirm");
       
        btnConfirm.setBounds(266, 402, 86, 23);
        panel_3.add(btnConfirm);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBox_1.setBounds(176, 270, 41, 26);
        panel_3.add(comboBox_1);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        comboBox_2.setBounds(227, 270, 41, 26);
        panel_3.add(comboBox_2);
        
        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021"}));
        comboBox_3.setBounds(278, 270, 74, 26);
        panel_3.add(comboBox_3);
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
        comboBox_4.setBounds(176, 344, 74, 26);
        panel_3.add(comboBox_4);
        
        JComboBox comboBox_5 = new JComboBox();
        comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
        comboBox_5.setBounds(278, 344, 74, 26);
        panel_3.add(comboBox_5);
        
        JPanel panel_2 = new JPanel();
        panel_2.setToolTipText("occupation");
        frame.getContentPane().add(panel_2, "name_278905498998818");
        panel_2.setLayout(null);
        
        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewPassword.setBounds(51, 226, 193, 40);
        panel_2.add(lblNewPassword);
        
        JLabel label_1 = new JLabel("New Name");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_1.setBounds(51, 114, 193, 40);
        panel_2.add(label_1);
       
        
        JComboBox comboBox = new JComboBox();
        //comboBox.setModel(new DefaultComboBoxModel(new String[] {"Driver", "Manager"}));
        comboBox.addItem("Driver");
        comboBox.addItem("Manager");
        comboBox.addItem("Passenger");
        comboBox.setSelectedItem("Passenger");
        comboBox.setBounds(380, 311, 121, 23);
        panel_2.add(comboBox);
        
        
        JButton btnConfirm_1 = new JButton("Confirm");
        btnConfirm_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		String user= textField_13.getText();
		        String pass=textField_14.getText();
		        String name= textField_12.getText();
		        String combosel=comboBox.getSelectedItem().toString();
		       int f=-1;
		        if(combosel.equals("Driver")){
		        f=AdminActions.userlist.get(current).createDriverAccount(name, user, pass);
		        if(f==-1)
		        	JOptionPane.showMessageDialog(null, "already exists");
		        else
		        	JOptionPane.showMessageDialog(null, "new driver account created");
		        }else if(combosel.equals("Manager")){
			        f=AdminActions.userlist.get(current).createMangerAccount(name, user, pass);
			        if(f==-1)
			        	JOptionPane.showMessageDialog(null, "already exists");
			        else
			        	JOptionPane.showMessageDialog(null, "new manager account created");
			        } else if(combosel.equals("Passenger")){
				        f=AdminActions.createPassangerAccount(name, user, pass);
				        if(f==-1)
				        	JOptionPane.showMessageDialog(null, "already exists");
				        else
				        	JOptionPane.showMessageDialog(null, "new passenger account created");
				        }
		        
		        
        	}
        });
        btnConfirm_1.setBounds(268, 313, 89, 23);
        panel_2.add(btnConfirm_1);
        
        
        JButton btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		panel_2.setVisible(false);
				panel.setVisible(true);
        	}
        });
        btnReturn.setBounds(151, 313, 89, 23);
        panel_2.add(btnReturn);
        
        JLabel lblNewUsername = new JLabel("New Username");
        lblNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewUsername.setBounds(51, 165, 193, 40);
        panel_2.add(lblNewUsername);
        
        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(325, 116, 176, 42);
        panel_2.add(textField_12);
        
        textField_13 = new JTextField();
        textField_13.setColumns(10);
        textField_13.setBounds(325, 167, 176, 42);
        panel_2.add(textField_13);
        
        textField_14 = new JTextField();
        textField_14.setColumns(10);
        textField_14.setBounds(325, 228, 176, 42);
        panel_2.add(textField_14);
        
        
        btnCreatePassengerAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(true);
				panel.setVisible(false);
			}
		});
        
        
      //  DefaultTableModel contactTableModel = (DefaultTableModel) Table.getModel();
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
    	btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				int i=-2;
				int k=-1;
					if(passwordField.getPassword()!=null&&textField.getText()!=null) {
						String user= textField.getText();
				        String pass=new String(passwordField.getPassword());
				        
					if(rdbtnPassenger.isSelected()) {
						k=1;
						i=AdminActions.verifyAccount(k,user,pass);}
					if(rdbtnEmployee.isSelected()) {
						k=2;
						i=AdminActions.verifyAccount(k,user,pass);
						}
					if(rdbtnManger.isSelected()) {
						k=3;
						i=AdminActions.verifyAccount(k,user,pass);}}
					
	             if(i>-1) {
				panel_1.setVisible(true);
				panel.setVisible(false);
				lblNewLabel_2.setText(AdminActions.userlist.get(i).getName());
				current=i;
				if(k==1) {
				lblNewLabel_1.setText("Passenger");
				btnNewButton_3.setVisible(false);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnNewButton_4.setVisible(true);
				btnNewButton_5.setVisible(true);
				btnNewButton_6.setVisible(true);
				comboBox.setSelectedItem("Passenger");
				comboBox.setVisible(false);
				if(AdminActions.userlist.get(current).getCancelnotifications()>0)
					JOptionPane.showMessageDialog(null, "you have "+AdminActions.userlist.get(current).getCancelnotifications()+" new work notications", "Login Error",JOptionPane.ERROR_MESSAGE);
				AdminActions.userlist.get(current).setCancelnotifications(-1);
				}
				else if(k==2)
				{	lblNewLabel_1.setText("Driver");
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_5.setVisible(false);
				btnNewButton_6.setVisible(false);
				if(AdminActions.userlist.get(current).getNewworknotifications()>0)
					JOptionPane.showMessageDialog(null, "you have "+AdminActions.userlist.get(current).getNewworknotifications()+" new work notications", "Login Error",JOptionPane.ERROR_MESSAGE);
				AdminActions.userlist.get(current).setNewworknotifications(-1);
				if(AdminActions.userlist.get(current).getCancelnotifications()>0)
					JOptionPane.showMessageDialog(null, "you have "+AdminActions.userlist.get(current).getCancelnotifications()+" new work notications", "Login Error",JOptionPane.ERROR_MESSAGE);
				AdminActions.userlist.get(current).setCancelnotifications(-1);
				}
				else if(k==3) {
					lblNewLabel_1.setText("Manger");
				 btnNewButton_4.setVisible(false);
				 	btnNewButton_5.setVisible(false);
				 	btnNewButton_1.setVisible(true);
					btnNewButton_2.setVisible(true);
					btnNewButton_3.setVisible(true);
					btnNewButton_6.setVisible(true);
	             }}
	             else if(i==-1){
	            	 JOptionPane.showMessageDialog(null, "Wrong username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
	            	 passwordField.setText(null);
	            	 textField.setText(null);
	             }
	             else 
	            	 JOptionPane.showMessageDialog(null, "Please write your login info");
			}
		});
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//int column = 0;
        		//int row = table.getSelectedRow();
        		//String value = table.getModel().getValueAt(row, column).toString();
        		
        		panel_3.setVisible(true);
				panel_1.setVisible(false);
        	
        	}
        });
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int column = 0;
        		int i=0;
        		int row = table.getSelectedRow();
        		String value = null;
        		
        		try {
        			value = table.getModel().getValueAt(row, column).toString();
        			i=AdminActions.searchTickets(value);
            		AdminActions.userlist.get(current).cancelTrip(i);
        			//model.removeRow(row);
        			JOptionPane.showMessageDialog(null, "Deleted Succesfully");
        				 
        			
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "please make a selection"," Error",JOptionPane.ERROR_MESSAGE);
				}
        		
        		String[][] data = AdminActions.ticketsRet(); // fills data with new updated tickets
        		model.setDataVector(data, columnNames);// fills tableview with new updated tickets
        	
        	}
        	
        	/*public void actionPerformed(ActionEvent arg0) {
        		int column = 0;
        		int i=0;
        		int row = table.getSelectedRow();
        		String value = null;
        		
        		try {
        			value = table.getModel().getValueAt(row, column).toString();
        			i=AdminActions.searchTickets(value);
            		AdminActions.userlist.get(current).cancelTrip(i);
            		model.removeRow(row);
        			JOptionPane.showMessageDialog(null, "Deleted Succesfully");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "please make a selection");
				}
        		
        		String[][] data = AdminActions.ticketsRet(); // fills data with new updated tickets
        		model.setDataVector(data, columnNames);// fills tableview with new updated tickets
        	
        	}*/
        	
        });
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//int column = 0;
        		//int row = table.getSelectedRow();
        		//String value = table.getModel().getValueAt(row, column).toString();
        		
        		panel_2.setVisible(true);
				panel_1.setVisible(false);
        	
        	}
        });
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int column = 0;
        		int i=0;
        		int row = table.getSelectedRow();
        		String value=null;
        		
        		try {
        			value = table.getModel().getValueAt(row, column).toString();
            		i=AdminActions.searchTickets(value);
            		AdminActions.userlist.get(current).cancelBook(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "please make a selection"," Error",JOptionPane.ERROR_MESSAGE);
				}
        		
        		String[][] data = AdminActions.ticketsRet(); // fills data with new updated tickets
        		model.setDataVector(data, columnNames);// fills tableview with new updated tickets
        		
        	
        	}
        });
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int column = 0;
        		int i=0;
        		int row = table.getSelectedRow();
        		String value=null;
        		
        		try {
        			value = table.getModel().getValueAt(row, column).toString();
            		i=AdminActions.searchTickets(value);
            		AdminActions.userlist.get(current).booktrip(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "please make a selection"," Error",JOptionPane.ERROR_MESSAGE);
				}
        		
        		String[][] data = AdminActions.ticketsRet(); // fills data with new updated tickets
        		model.setDataVector(data, columnNames);// fills tableview with new updated tickets
        	
        	}
        });
        
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AdminActions.ticketsSaveToFile();
        		AdminActions.userSaveToFile();
        		
        	}
        });
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		panel_1.setVisible(false);
				panel.setVisible(true);
        	}
        });
        
        
        
        
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int i=-2;
            	if(textField_1.getText()!=null&&textField_2.getText()!=null&&textField_3.getText()!=null&&textField_4.getText()!=null&&textField_5.getText()!=null&&textField_6.getText()!=null&&textField_7.getText()!=null&&textField_9.getText()!=null) {
    				String ticketNo= textField_1.getText();
    		        String vehicle= textField_2.getText();
    		        String source= textField_3.getText();
    		        String destination= textField_4.getText();
    		        String type= textField_5.getText();
    		        int seats= Integer.parseInt(textField_6.getText()) ;
    		        double price= Double.parseDouble(textField_7.getText());
    		        String date= (comboBox_1.getSelectedItem().toString()+"/"+comboBox_2.getSelectedItem().toString()+"/"+comboBox_3.getSelectedItem().toString());
    		        String drivername= textField_9.getText();
    		        int timeH= Integer.parseInt(comboBox_4.getSelectedItem().toString());
    		        int timeM= Integer.parseInt(comboBox_5.getSelectedItem().toString());
    		     
    		        if(AdminActions.searchTickets(ticketNo)==-1)
    		        i=AdminActions.userlist.get(current).createTicket(ticketNo,vehicle,type,seats,price,source,destination,date,timeH,timeM,drivername);
    		       else
    		    	   JOptionPane.showMessageDialog(null, "ticket number already exist"," Error",JOptionPane.ERROR_MESSAGE);
    		       if(i==-1)
    		    	   JOptionPane.showMessageDialog(null, "invalid info"," Error",JOptionPane.ERROR_MESSAGE);
    		       else if(i>-1)
    		    	   JOptionPane.showMessageDialog(null, "Ticket Confirmed"," Error",JOptionPane.ERROR_MESSAGE);
    		        String[][] data = AdminActions.ticketsRet(); // fills data with new updated tickets
            		model.setDataVector(data, columnNames);// fills tableview with new updated tickets
            		
            		
    	}
        		
        	}
        });
	}
}

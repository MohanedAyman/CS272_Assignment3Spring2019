package busStation;

import java.io.*;
import java.util.*;
import java.sql.*;

public abstract class AdminActions /*extends db*/
{
	 static ArrayList<Tickets> list=new ArrayList<Tickets>();
	 /*static HashMap<String, String> employeeAccounts = new HashMap<>();
	 static HashMap<String, String> passengersAccounts = new HashMap<>();*/
	 static ArrayList<User> userlist=new ArrayList<User>();
	
	
   /* 
    public static ArrayList<Tickets> getList() {return list;}
	public static void setList(ArrayList<Tickets> list) {AdminActions.list = list;}
	public static HashMap<String, String> getEmployeeAccounts() {return employeeAccounts;}
	public static void setEmployeeAccounts(HashMap<String, String> employeeAccounts) {AdminActions.employeeAccounts = employeeAccounts;}
	public static HashMap<String, String> getPassengersAccounts() {return passengersAccounts;}
	public static void setPassengersAccounts(HashMap<String, String> passengersAccounts) {AdminActions.passengersAccounts = passengersAccounts;}
	public static ArrayList<User> getUserlist() {return userlist;}
    public static void setUserlist(ArrayList<User> userlist) {AdminActions.userlist = userlist;}
    */
	 public static int verifyAccount(int accounttype,String user,String pass) {
		 int i=-1;
		 
		 if (accounttype==1){
			/* try {
				 String sql = "select Username,Password from Table1 where Username='"+user+"'Password='"+pass+"'";
				rs=st.executeQuery(sql);
				return ++i;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }*/
		 while(++i<userlist.size()) {
			 if (userlist.get(i) instanceof Passenger)	 
				 if (user.equals(userlist.get(i).getUsername())&&pass.equals(userlist.get(i).getPassword()))
				 return i;
			 }}
		 else if (accounttype==2)
			 /* try {
			 String sql = "select Username,Password from Table2 where Username='"+user+"'Password='"+pass+"'";
			rs=st.executeQuery(sql);
			return ++i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }*/
			 while(++i<userlist.size()) {
				 if (userlist.get(i) instanceof Driver)	 
			 if (user.equals(userlist.get(i).getUsername())&&pass.equals(userlist.get(i).getPassword()))
					 return i;}
		 
		 else if (accounttype==3)
			 /* try {
			 String sql = "select Username,Password from Table3 where Username='"+user+"'Password='"+pass+"'";
			rs=st.executeQuery(sql);
			return ++i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }*/
			 while(++i<userlist.size()) {
				 if (userlist.get(i) instanceof Manger)	
	 if (user.equals(userlist.get(i).getUsername())&&pass.equals(userlist.get(i).getPassword()))
					
		 
		 return i;}
		 return -1;
			 
		 
	 }

	 public static int searchAccounts(String name) {
		 int i=0;
		 while(i<userlist.size()) {	 
		 if (name.equals(userlist.get(i).getName()))
			 return i;
		 else i++;}		
		 return -1;
	 }
	 public static int searchTickets(String tickno) {
		 int i=0;
		 while(i<list.size()) {	 
		 if (tickno.equals(list.get(i).getTicketNo()))
			 return i;
		 else
				 i++;}	
		 
		 return -1;
	 }
	 public static int searchAccountsUser(String user) {
		 int i=0;
		 while(i<userlist.size()) {	 
		 if (user.equals(userlist.get(i).getUsername()))
			 return i;
		 else i++;}		
		 return -1;
	 }

	 public static int searchAccountsDrivers(String user) {
		 int i=0;
		 while(i<userlist.size()) {	 
		 if (user.equals(userlist.get(i).getName())&&userlist.get(i) instanceof Driver)
				 return i;
		 else i++;}		
		 return -1;
	 } 
	 
	 
	 

	public static void ticketsSaveToFile(){
		File file = new File("list.txt");
		 try {
			 
	         FileOutputStream f = new FileOutputStream(file);
	         ObjectOutputStream o = new ObjectOutputStream(f);
	         
	for(int i=0;i<list.size();i++)
	         o.writeObject(list.get(i));
	         o.close();

	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
	 }
	    

	public static void ticketsReadFromFile(){
		File file = new File("list.txt");
		 try {
			 
	         FileInputStream f = new FileInputStream(file);
	         ObjectInputStream o = new ObjectInputStream(f);
	         while(f.available() > 0)
	     list.add((Tickets)o.readObject());
	         o.close();

	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
	 }

	public static void printArrayList() {
		for(int i=0;i<list.size();i++) {
			list.get(i).printAll();
			}}
	

	public static void userSaveToFile(){
		File file = new File("userlist.txt");
		 try {
			 
	         FileOutputStream f = new FileOutputStream(file);
	         ObjectOutputStream o = new ObjectOutputStream(f);
	         
	for(int i=0;i<userlist.size();i++)
	         o.writeObject(userlist.get(i));
	         o.close();

	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
	 }
	    

	public static void userReadFromFile(){
		File file = new File("userlist.txt");
		 try {
			 
	         FileInputStream f = new FileInputStream(file);
	         ObjectInputStream o = new ObjectInputStream(f);
	         while(f.available() > 0)
	     userlist.add((User)o.readObject());
	         o.close();

	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
	 }
	
	public static void userprint(){
		for(int i=0;i<userlist.size();i++) {
			if(userlist.get(i) instanceof User)
			System.out.println(userlist.get(i).getName());
			}}

	public static void userret(){
		for(int i=0;i<userlist.size();i++) {
			if(userlist.get(i) instanceof User)
			System.out.println(userlist.get(i).getName());
			}}

	public static String[][] ticketsRet(){
		String[][] str= new String[10][list.size()];
		for(int i=0;i<list.size();i++) {
		 str[i] =list.get(i).returnAll();
			
			}
	return str;	
	}
	
	public static int roundtripcheck(int current,String name,String source,String destination){
		for(int i=0;i<list.size();i++)
	if(list.get(current).seatReg.contains(name)&&list.get(current).getDestination()==source&&list.get(current).getSource()==destination)
		return 1;
			return -1;
		
	}
	public static int createPassangerAccount(String name,String user,String pass){
		int a=AdminActions.searchAccounts(name);
		 int b=AdminActions.searchAccountsUser(user);
		 if(a==-1&&b==-1) {
			Passenger x=new Passenger(user, pass,name);
			return 1;
		}
		else return -1;
			
	}
}


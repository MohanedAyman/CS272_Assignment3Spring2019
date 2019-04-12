package busStation;

import java.io.Serializable;
import java.util.*;

public class Passenger extends User implements Serializable{
	

	public Passenger(String username, String password, String name) {
		super(username, password, name);
		//AdminActions.passengersAccounts.put(username,password);
		AdminActions.userlist.add(this);	
		System.out.println("passenger set");
		
	}
	
	
	public int booktrip(int x) {
		int a=AdminActions.list.get(x).bookASeat(getName());
		return a;
	}
	public int cancelBook(int x) {
		int a=AdminActions.list.get(x).leaveASeat(getName());
			
		return a;
	}

}

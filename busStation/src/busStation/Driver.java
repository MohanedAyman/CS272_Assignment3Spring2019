package busStation;

import java.io.Serializable;

public class Driver extends User implements Serializable{
	

	public Driver(String username, String password, String name) {
		super(username, password, name);
		//AdminActions.employeeAccounts.put(username,password);
		AdminActions.userlist.add(this);
		System.out.println("driver set");
	}
	
}

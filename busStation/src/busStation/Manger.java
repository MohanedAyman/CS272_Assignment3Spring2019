package busStation;

import java.io.Serializable;
import java.util.*;

public class Manger extends User implements Serializable{

	public Manger(String username, String password, String name) {
		super(username, password, name);
		//AdminActions.employeeAccounts.put(username,password);
		AdminActions.userlist.add(this);
		System.out.println("manger set");
	}
	
public int createTicket(String ticketNo,String vehicle,String type,int seats,double price,String source,String destination,String date,int timeH,int timeM,String drivername) {
   int res=0;
   res=AdminActions.searchAccountsDrivers(drivername);
	if (res!=-1){
		AdminActions.list.add(new Tickets(ticketNo,vehicle,type,seats,price,source,destination,date,timeH,timeM,drivername));
	System.out.println(res);
	AdminActions.userlist.get(res).setNewworknotifications(1);
	return res;
	}
	else return -1;
	
}



public void cancelTrip(int x) {
	int i=0;
	int size =AdminActions.list.get(x).seatReg.size();
	int res;
	for(i=0;i<size;i++) {
	
	res=AdminActions.searchAccounts(AdminActions.list.get(x).seatReg.get(i));
	AdminActions.userlist.get(res).setCancelnotifications(1);
	}
	res=AdminActions.searchAccounts(AdminActions.list.get(x).drivername);
	AdminActions.userlist.get(res).setCancelnotifications(1);	
	AdminActions.list.remove(x);
}

public int createDriverAccount(String name,String user,String pass){
	int a=AdminActions.searchAccounts(name);
	 int b=AdminActions.searchAccountsUser(user);
	 if(a==-1&&b==-1) {
		Driver x=new Driver(user, pass,name);
		return 1;
	}
	else return -1;
		
}
public int createMangerAccount(String name,String user,String pass){
	int a=AdminActions.searchAccounts(name);
	 int b=AdminActions.searchAccountsUser(user);
	if(a==-1&&b==-1) {
		Manger x=new Manger(user, pass,name);
		return 1;
	}
	else return -1;
		
}
public void delAccount(String name){
	int x=AdminActions.searchAccounts(name);
	AdminActions.userlist.remove(x);
}







}

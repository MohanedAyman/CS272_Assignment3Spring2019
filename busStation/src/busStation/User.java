package busStation;
import java.io.*;
import java.util.*;
public abstract class User implements Serializable {

private String username;
private String password;
private String name;
private int cancelnotifications ;
private int newworknotifications ;

public User( String username,String password, String name) {
	this.username = username;
	this.password = password;
	this.name = name;
	System.out.println("user set");
	}



public String getUsername() {
	return username;}



public void setUsername(String username) {
	this.username = username;}



public String getPassword() {
	return password;}



public void setPassword(String password) {
	this.password = password;}



public String getName() {
	return name;}



public void setName(String name) {
	this.name = name;}


public int getCancelnotifications() {
return cancelnotifications;}



public void setCancelnotifications(int cancelnotifications) {
	if(cancelnotifications>0)
	this.cancelnotifications += cancelnotifications;
	else
		this.cancelnotifications =0;
}


public int getNewworknotifications() {
	return newworknotifications;
}

public void setNewworknotifications(int newworknotifications) {
	if(newworknotifications>0)
	this.newworknotifications += newworknotifications;
	else
		this.newworknotifications =0;
}

public void cancelTrip(int c) {}

public int booktrip(int x) {return -1;}

public int cancelBook(int x) {return -1;}

public int createDriverAccount(String name,String user,String pass){
	 return -1;}

public int createTicket(String ticketNo, String vehicle, String type, int seats, double price, String source,
		String destination, String date, int timeH, int timeM, String drivername) {return -1;}

public int createMangerAccount(String name,String user,String pass){
 return -1;
		
}
public void delAccount(String name){
}

}


package busStation;
import java.io.*;
import java.util.*;
public class Tickets implements Serializable {
private String ticketNo;
private String vehicle;
private String licensePlate;
private String source;
private String destination;
private String date;
private int timeH;
private int timeM;
private String type;
private int seats;
ArrayList<String> seatReg=new ArrayList<String>();
 String drivername;
 double price;



public Tickets(String ticketNo,String vehicle,String type,int seats,double price,String source,String destination,String date,int timeH,int timeM,String drivername) {
	this.ticketNo=ticketNo;
	this.vehicle=vehicle;
	this.date=date;
	this.source=source;
	this.destination=destination;
	this.type=type;
	this.seats=seats;
	this.price=price;
	this.timeH=timeH;
	this.timeM=timeM;
	this.drivername=drivername;
	System.out.println("ticket confirmed");
}
public int bookASeat(String x) {
	if(seatReg.contains(x))
	    return 2;
	if(seats!=0) {
		seats-=1; 
		seatReg.add(x);
		return 1;}
		else
			return 0;
	
	}

public int leaveASeat(String x) {
	if(seatReg.contains(x))	{
	    seats+=1; 
		seatReg.remove(x); 
		return 1;}
	else
		return 0;
	}
public void printAll() {
	System.out.println(ticketNo);
	System.out.println(vehicle);
	System.out.println(date);
	System.out.println(source);
	System.out.println(destination);
	System.out.println(type);
	System.out.println(seats);
	System.out.println(price);
	System.out.println(timeH);
	System.out.println(timeM);
	System.out.println(drivername);
	for (int i = 0; i < seatReg.size(); i++) {
		System.out.println(seatReg.get(i));
	}
	
}
public String[] returnAll() {
	String time= (timeH + ":" + timeM);
	String [] s= {ticketNo,vehicle,type,Integer.toString(seats),Double.toString(price),source,destination,date,time,drivername};
	
	return s;
}
public String getTicketNo() {
	return ticketNo;
}
public void setTicketNo(String ticketNo) {
	this.ticketNo = ticketNo;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}





}

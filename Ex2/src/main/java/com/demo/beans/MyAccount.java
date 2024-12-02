package com.demo.beans;

public class MyAccount {
	private int aid;
	private String aname;
	private static  double bal;
	
	
	public MyAccount() {
		super();
	}

  public MyAccount(int aid, String aname, double bal) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.bal = bal;
	}

public int getAid() {
	return aid;
}

public void setAid(int aid) {
	this.aid = aid;
}

public String getAname() {
	return aname;
}

public void setAname(String aname) {
	this.aname = aname;
}

public double getBal() {
	return bal;
}


public void setBal(double bal) {
	this.bal = bal;
}

public  static double deposite() {
	return bal;
	
}

@Override
public String toString() {
	return "MyAccount [aid=" + aid + ", aname=" + aname + ", bal=" + bal + "]";
}
  
	
	

}

package com.demo.service;

import java.util.List;

import com.demo.beans.MyAccount;

public interface CRUD {

	int addAccount(int aid, String aname, int bl);

	int delAcc(int id);

	List<MyAccount> displayALL();


	boolean withdraw(double amount, double currentBalance, int id);

	boolean deposite(double amount, int id);

}

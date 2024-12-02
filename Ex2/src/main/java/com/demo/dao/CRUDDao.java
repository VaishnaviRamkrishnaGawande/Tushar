package com.demo.dao;

import java.util.List;

import com.demo.beans.MyAccount;

public interface CRUDDao {

	int add(int aid, String aname, int bl);

	int delete(int id);

	List<MyAccount> getALL();


	boolean withrawamt(double finalamt, int id);

	boolean deposite(double fBal, int id);

}

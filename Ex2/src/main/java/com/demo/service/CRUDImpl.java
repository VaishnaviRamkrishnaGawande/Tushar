package com.demo.service;

import java.util.List;

import com.demo.beans.MyAccount;
import com.demo.dao.CRUDDao;
import com.demo.dao.CRUDDaoImpl;

public class CRUDImpl implements CRUD{
	
	CRUDDao cDao;
	

	public CRUDImpl() {
		super();
		cDao=new CRUDDaoImpl();
		}
	


	@Override
	public int addAccount(int aid, String aname, int bl) {
		// TODO Auto-generated method stub
		return cDao.add(aid,aname,bl);
	}



	@Override
	public int delAcc(int id) {
		// TODO Auto-generated method stub
		return cDao.delete(id);
	}



	@Override
	public List<MyAccount> displayALL() {
		// TODO Auto-generated method stub
		return cDao.getALL();
	}




	@Override
	public boolean withdraw(double amount, double currentBalance,int id) {
		
		double finalamt=amount-currentBalance;
		return cDao.withrawamt(finalamt,id);
	}



	@Override
	public boolean deposite(double amount, int id) {
		
		double currentbal=MyAccount.deposite();
		double fBal=currentbal+amount;
		return cDao.deposite(fBal,id);
	}

}

package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.MyAccount;

public class CRUDDaoImpl implements CRUDDao{
	
	  static Connection conn;
      static PreparedStatement  add,del,get,withdraw,deposite;
      static {
    	  try {
    		  conn=DBUtil.getMyConnection();
			add=conn.prepareStatement("INSERT INTO account (aid, name, balance) VALUES (?, ?, ?)");
			del=conn.prepareStatement("delete from account where aid=?");
			get=conn.prepareStatement("select * from account");
			withdraw=conn.prepareStatement("update account set balance =? where aid=?");
			deposite=conn.prepareStatement("update account set balance =? where aid=?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

	@Override
	public int add(int aid, String aname, int bl) {
		
		try {
			add.setInt(1, aid);
			add.setString(2, aname);
			add.setInt(3, bl);
			int n=add.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public int delete(int id) {
	   try {
		del.setInt(1, id);
		int n=del.executeUpdate();
		return n;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
		return -1;
	}

	@Override
	public List<MyAccount> getALL() {
		List<MyAccount>lst=new ArrayList<>();
		try {
			ResultSet rS=get.executeQuery();
			while(rS.next())
			{
				lst.add(new MyAccount(rS.getInt(1),rS.getString(2),rS.getDouble(3)));
			}
			if(lst!=null)
				return lst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean withrawamt(double finalamt,int id) {
		try {
			withdraw.setDouble(1, finalamt);
			withdraw.setDouble(2, id);
			int n=withdraw.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deposite(double fBal, int id) {
		try {
			deposite.setDouble(1, fBal);
			deposite.setInt(2, id);
			int n=deposite.executeUpdate();
			if(n>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}



}

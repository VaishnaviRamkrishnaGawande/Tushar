package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class ValidateDaoImpl implements ValidateDao{
      static Connection conn;
      static PreparedStatement  val;
      static {
    	  try {
    		  conn=DBUtil.getMyConnection();
			val=conn.prepareStatement("select * from user where user=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
	@Override
	public MyUser Authe(String uname, String password) {
		 try {
			val.setString(1, uname);
			val.setString(2, password);
			ResultSet rs=val.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

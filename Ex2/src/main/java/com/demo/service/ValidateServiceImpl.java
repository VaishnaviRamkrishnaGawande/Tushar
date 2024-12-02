package com.demo.service;

import java.nio.channels.NonWritableChannelException;

import com.demo.beans.MyUser;
import com.demo.dao.ValidateDao;
import com.demo.dao.ValidateDaoImpl;

public class ValidateServiceImpl implements Validate {
	  ValidateDao vDao;

	public ValidateServiceImpl() {
		vDao =new ValidateDaoImpl();
	}

	@Override
	public MyUser Authenticate(String uname, String password) {
		return vDao.Authe(uname,password);
	}
	  

}

package com.demo.service;

import com.demo.beans.MyUser;

public interface Validate {

	MyUser Authenticate(String uname, String password);

}

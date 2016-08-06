package com.hand.dao;

import java.util.ArrayList;

import com.hand.bean.Customer;

public interface ICustomerDao {
	
	
	public ArrayList<Customer> selectAdminByName(String name);
	

}

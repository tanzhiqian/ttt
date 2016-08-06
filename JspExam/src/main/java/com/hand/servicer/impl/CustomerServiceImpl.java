package com.hand.servicer.impl;

import java.util.ArrayList;

import com.hand.bean.Customer;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.service.ICustomerService;

public class CustomerServiceImpl  implements ICustomerService{

	private CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	public ArrayList<Customer> selectAdminByName(String name) {
		// TODO Auto-generated method stub
		return customerDaoImpl.selectAdminByName(name);
	}
	
}

package com.hand.service;

import java.util.ArrayList;

import com.hand.bean.Customer;

public interface ICustomerService {
	public ArrayList<Customer> selectAdminByName(String name);

}

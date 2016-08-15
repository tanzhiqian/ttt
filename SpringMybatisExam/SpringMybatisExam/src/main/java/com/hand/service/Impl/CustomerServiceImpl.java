package com.hand.service.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Customer;
import com.hand.mapper.CustomerMapper;
import com.hand.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{

	public void insert(Customer c) {
		
		 ApplicationContext ac=new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
		 CustomerMapper cm=(CustomerMapper) ac.getBean("cm");
		 cm.insert(c);
	}

}

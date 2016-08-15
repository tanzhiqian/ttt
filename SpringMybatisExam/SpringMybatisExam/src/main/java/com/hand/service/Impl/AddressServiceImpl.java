package com.hand.service.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Address;
import com.hand.mapper.AddressMapper;
import com.hand.service.IAddressService;

public class AddressServiceImpl implements IAddressService{

	
	
	public boolean getId(int id) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
		AddressMapper am=(AddressMapper) ac.getBean("ac");
		
		Address address=am.getById(id);
		if(address!=null)
		{
			return true;
		}
		return false;
	}

	
	
}

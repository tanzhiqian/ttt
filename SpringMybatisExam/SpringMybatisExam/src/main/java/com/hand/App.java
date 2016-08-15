package com.hand;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Customer;
import com.hand.service.IAddressService;
import com.hand.service.ICustomerService;
import com.hand.service.Impl.AddressServiceImpl;
import com.hand.service.Impl.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac=new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
        Customer customer=(Customer) ac.getBean("customer");
        AddressServiceImpl aService=(AddressServiceImpl) ac.getBean("aService");
        CustomerServiceImpl csi=(CustomerServiceImpl) ac.getBean("cs");
        
        Scanner s=new Scanner(System.in);
        String fName=s.next();
        String lName=s.next();
        String eMail=s.next();
        int addressId=s.nextInt();
        while(!aService.getId(addressId))
        {
        	System.out.println("id不存在，请重新输入");
        	addressId=s.nextInt();
        }
        System.out.println("success");
        Date date=new Date(System.currentTimeMillis());  
        customer.setFirst_name(fName);
        customer.setLast_name(lName);
        customer.setEmail(eMail);
        customer.setStore_id(1);
        customer.setCreate_date(date);
        customer.setAddress_id(addressId);
        
        System.out.println(customer.toString());
        
        csi.insert(customer);
        
        
       
    }
}

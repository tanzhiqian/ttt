package com.hand.dao.impl;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.hand.bean.Customer;
import com.hand.dao.ICustomerDao;
import com.mysql.jdbc.Connection;

import util.Dbutil;

public class CustomerDaoImpl implements ICustomerDao {

	

	public ArrayList<Customer> selectAdminByName(String name) {
		ArrayList<Customer> customer=new ArrayList<Customer>();
		String sql="select * from customer where first_name = ?";
		PreparedStatement psmt=Dbutil.getPreparedStatement(sql);
		try {
			psmt.setObject(1,name);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				Customer a=new Customer();
				a.setFirst_name(rs.getString("First_name"));
				customer.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

	

}

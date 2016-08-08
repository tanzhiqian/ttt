package com.hand.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	
	private ConnectionFactory(){}
	
	private Connection con;
	
	public static ConnectionFactory newInstance(){
		return factory;
	}
	
	//����Դ�ļ�����Դ��������
			static{
				Properties properties = new Properties();
				//��ȡdb��Դ�ļ�������
				InputStream is = ConnectionFactory.class.
						         getClassLoader().getResourceAsStream("jdbc.properties");
				try {
					//������Դ�ļ�
					properties.load(is);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver = properties.getProperty("driver");
				url = properties.getProperty("url");
				user = properties.getProperty("user");
				pass = properties.getProperty("pass");
			}

	public Connection getConnection(){
		try {
			if (con==null||con.isClosed()) {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pass);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}

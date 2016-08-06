package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



/*
 * 
 * 数据库操作工具类
 */
public class Dbutil {
	public static Connection con = null; // 连接对象
	public static PreparedStatement psmt = null;// 预编译对象
	public static ResultSet rs = null; // 结果集对象
	public static CallableStatement csmt = null;// 过程对象

	// 与数据库获得连接的方法
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql:///sakila?characterEncoding=utf-8","root", "mysql");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//获取一条SQL语句的预编译对象方法
	public static PreparedStatement getPreparedStatement(String sql){
		con=getConnection();
		try {
			psmt=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psmt;
	}
	//获取一条SQL语句的结果集对象
	public static ResultSet getResultSet(String sql){
		psmt=getPreparedStatement(sql);
		try {
			rs=psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//绑定参数方法
	public static void bindparams(PreparedStatement psmt,List<Object> params){
		int index=0;
		if(params!=null){
			for(Object p:params){
				try {
					psmt.setObject(index+1,p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;
			}
		}
	}
	//获取一条SQL语句影响结果的方法
	public static int executeUpdate(String sql,List<Object> params){
		int count=0;
		psmt=getPreparedStatement(sql);
		bindparams(psmt,params);
		try {
			count=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	//返回sql查询语句结果集方法
	public static ResultSet executeQuery(String sql,List<Object> params){
		psmt=getPreparedStatement(sql);
		bindparams(psmt, params);
		try {
			rs=psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//关闭数据库连接全部对象方法
		public static void closeAll(){
			
				try {
					if(con!=null){
					con.close();
					}
					if(psmt!=null){
						psmt.close();
					}
					if(rs!=null){
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}


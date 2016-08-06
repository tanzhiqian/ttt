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
 * ���ݿ����������
 */
public class Dbutil {
	public static Connection con = null; // ���Ӷ���
	public static PreparedStatement psmt = null;// Ԥ�������
	public static ResultSet rs = null; // ���������
	public static CallableStatement csmt = null;// ���̶���

	// �����ݿ������ӵķ���
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
	//��ȡһ��SQL����Ԥ������󷽷�
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
	//��ȡһ��SQL���Ľ��������
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
	//�󶨲�������
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
	//��ȡһ��SQL���Ӱ�����ķ���
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
	//����sql��ѯ�����������
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
	//�ر����ݿ�����ȫ�����󷽷�
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


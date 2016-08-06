package com.hand.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hand.bean.Customer;
import com.hand.bean.Film;
import com.hand.dao.IFilmDao;
import com.mysql.jdbc.CallableStatement;

import util.Dbutil;

public class FilmDaoImpl implements IFilmDao{

	public int addFilm(Film film) {
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(film.getFilm_id());
		params.add(film.getName());
		
		return Dbutil.executeUpdate(sql, params);
	}

	public int deleteFilm(int filmid) {
		String sql="delete from film where film_id = ?";
		List<Object> params =new ArrayList<Object>();
		params.add(filmid);
		return Dbutil.executeUpdate(sql, params);
	}

	public int updateFilm(Film film) {
		String sql="update film set title = ?,description=? where film_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(film.getFilm_id());
		params.add(film.getName());
		return Dbutil.executeUpdate(sql, params);
	}

	public ArrayList<Film> selectallFilm() {
		ArrayList<Film> film=new ArrayList<Film>();
		String sql="select film_id,title,description,name from film,language"
				+ " where film.language_id = language.language_id";
		ResultSet rs=Dbutil.executeQuery(sql, null);
		try {
			while(rs.next()){
				Film a=new Film();
			    a.setFilm_id(rs.getInt("filmid"));
				a.setName(rs.getString("name"));
				film.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	public Film selectAdminByadminid(int filmid) {
		Film film=new Film();
		String sql="select *from admin where adminid=?";
		PreparedStatement psmt=Dbutil.getPreparedStatement(sql);
		try {
			psmt.setObject(1,filmid);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				film.setFilm_id(rs.getInt("filmid"));
				film.setName(rs.getString("filmName"));
			   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	public ArrayList<Film> selectAdminByName(String filmName) {
		ArrayList<Film> film=new ArrayList<Film>();
		String sql="";
		PreparedStatement psmt=Dbutil.getPreparedStatement(sql);
		try {
			psmt.setObject(1,filmName);
			ResultSet rs=psmt.executeQuery();
			while(rs.next()){
				Film a=new Film();
			    a.setFilm_id(rs.getInt("filmid"));
				a.setName(rs.getString("name"));
				film.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return film;
	}
}

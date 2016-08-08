package com.hand.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hand.Dao.FilmDao;
import com.hand.DaoImp.FilmDaoImp;
import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.utils.ConnectionFactory;

public class FilmServiceImp {

	private FilmDao filmDao = new FilmDaoImp();
	
	//��ѯ��Ӱ
	public List<Film> queryFilms(){
		List<Film> films = null;
		Connection con = ConnectionFactory.newInstance().getConnection();
		try {
			films = filmDao.queryFilms(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return films;
	}
	
	
	//ɾ����Ӱ
	public boolean deleteFilm(int film_id) {
		
		Connection con = ConnectionFactory.newInstance().getConnection();
		int i=0;
		try {
			i = filmDao.deleteFilm(con, film_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	//������������
	public List<Language> queryLanguages(){
		
		Connection con = ConnectionFactory.newInstance().getConnection();
		List<Language> languages = null;
		try {
			languages = filmDao.queryLanguages(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		return languages;
	}
	
	
	//��ӵ�Ӱ
	public boolean addFilm(String name, String desc, int lan){
		Connection con = ConnectionFactory.newInstance().getConnection();
		boolean result = false;
		try {
			int i = filmDao.addFilm(con, name, desc, lan);
			if (i>0) {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	//����id��ѯ��Ӱ
	public Film queryFilmById(int id){
		Connection con = ConnectionFactory.newInstance().getConnection();
		Film film = null;
		try {
			film = filmDao.queryFilmById(con, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}
}

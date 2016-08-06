package com.hand.servicer.impl;

import java.sql.*;
import java.util.ArrayList;

import com.hand.bean.*;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.service.IFilmService;

public class FilmServiceImpl implements IFilmService{

	private FilmDaoImpl filmDaoImpl=new FilmDaoImpl();
	public boolean addFilm(Film film) {
		boolean flag=false;
		int count=filmDaoImpl.addFilm(film);
		if (count>0){
			flag=true;
		}
		return flag;
	}

	public boolean deleteFilm(int filmid) {
		boolean flag=false;
		int count=filmDaoImpl.deleteFilm(filmid);
		if (count>0){
			flag=true;
		}
		return flag;
	}

	public boolean updateFilm(Film film) {
		boolean flag=false;
		int count=filmDaoImpl.updateFilm(film);
		if (count>0){
			flag=true;
		}
		return flag;
	}

	public ArrayList<Film> selectallFilm() {
		return filmDaoImpl.selectallFilm();
	}

	public Film selectAdminByadminid(int filmid) {
		// TODO Auto-generated method stub
		return filmDaoImpl.selectAdminByadminid(filmid);
	}

	public ArrayList<Film> selectAdminByName(String filmName) {
		// TODO Auto-generated method stub
		return filmDaoImpl.selectAdminByName(filmName);
	}
	

}

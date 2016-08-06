package com.hand.service;

import java.util.ArrayList;

import com.hand.bean.Film;

public interface IFilmService {
	public boolean addFilm(Film film);//添加一个电影的方法
	public boolean  deleteFilm(int filmid);//删除一个电影的方法
	public boolean  updateFilm(Film film);//修改一个电影的方法
	public ArrayList<Film> selectallFilm();//查询所有电影的方法
	public Film selectAdminByadminid(int filmid);//根据编号查询电影的方法
	public ArrayList<Film> selectAdminByName(String filmName);//根据名字查询电影的方法


}

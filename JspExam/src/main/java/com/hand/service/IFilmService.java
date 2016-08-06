package com.hand.service;

import java.util.ArrayList;

import com.hand.bean.Film;

public interface IFilmService {
	public boolean addFilm(Film film);//���һ����Ӱ�ķ���
	public boolean  deleteFilm(int filmid);//ɾ��һ����Ӱ�ķ���
	public boolean  updateFilm(Film film);//�޸�һ����Ӱ�ķ���
	public ArrayList<Film> selectallFilm();//��ѯ���е�Ӱ�ķ���
	public Film selectAdminByadminid(int filmid);//���ݱ�Ų�ѯ��Ӱ�ķ���
	public ArrayList<Film> selectAdminByName(String filmName);//�������ֲ�ѯ��Ӱ�ķ���


}

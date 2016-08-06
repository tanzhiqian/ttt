package com.hand.dao;

import java.util.ArrayList;

import com.hand.bean.Film;

public interface IFilmDao {
	public int addFilm(Film film);//���һ����Ӱ�ķ���
	public int deleteFilm(int filmid);//ɾ��һ����Ӱ�ķ���
	public int updateFilm(Film film);//�޸�һ����Ӱ�ķ���
	public ArrayList<Film> selectallFilm();//��ѯ���е�Ӱ�ķ���
	public Film selectAdminByadminid(int filmid);//���ݱ�Ų�ѯ��Ӱ�ķ���
	public ArrayList<Film> selectAdminByName(String filmName);//�������ֲ�ѯ��Ӱ�ķ���

}

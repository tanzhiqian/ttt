package com.hand.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.pojo.Film;
import com.hand.pojo.Language;
import com.hand.service.FilmServiceImp;
import com.hand.service.UserServiceImp;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserServiceImp userService = new UserServiceImp();
	private FilmServiceImp filmService = new FilmServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           
		//���ñ���
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		if (type==null||type.equals("query")) {
			this.query(request, response);
		}else if (type.equals("delete")) {
			this.delete(request, response);
		}else if(type.equals("add")){
			this.add(request, response);
		}
	}
	
	//��ѯ��Ӱ������
	protected void query (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Language> languages = filmService.queryLanguages();
		request.setAttribute("languages", languages);
		
		List<Film> films = filmService.queryFilms();
		request.setAttribute("films", films);
		request.getRequestDispatcher("film.jsp").forward(request, response);;
		
	}
	
	//ɾ����Ӱ������
protected void delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String film_id_str = request.getParameter("film_id");
		int film_id = Integer.parseInt(film_id_str);
		
		boolean result = filmService.deleteFilm(film_id);
		if (result) {
			request.setAttribute("result", "ɾ���ɹ�");
		}else{
			request.setAttribute("result", "ɾ��ʧ��");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}


//��ӵ�Ӱ
protected void add (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String lan = request.getParameter("language");
    int language = Integer.parseInt(lan);
    
    boolean result = filmService.addFilm(name, desc, language);
    if (result) {
		request.setAttribute("result", "��Ӱ��ӳɹ�");
	}else{
		request.setAttribute("result", "��Ӱ���ʧ��");
	}
    request.getRequestDispatcher("result.jsp").forward(request, response);
}



	  
}




	
	



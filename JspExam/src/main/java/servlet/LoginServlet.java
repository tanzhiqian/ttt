package servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.hand.bean.*;
import com.hand.servicer.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilmServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CustomerServiceImpl cs=new CustomerServiceImpl();
    private FilmServiceImpl filmServiceImpl=new FilmServiceImpl();
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String first_name = req.getParameter("username");
		
		RequestDispatcher rd = null;
		String forward = null;
		if (first_name == null ) {
			req.setAttribute("msg", "用户名为空");
			rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		} else {
			ArrayList<Customer> b = cs.selectAdminByName("first_name");
			if (b.size()!=0) {
				forward = "success.jsp";
				req.getSession().setAttribute("flag", "success");
			} else {
				req.getSession().setAttribute("flag", "error");
				req.setAttribute("msg", "用户名错误");
				forward = "error.jsp";
			}
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}}
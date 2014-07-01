package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInformationDao;

import pojo.PostInformation;

public class ManageBasePost extends HttpServlet {
	
	
	public ManageBasePost() {
		super();
		
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostInformationDao pdao=new PostInformationDao();
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(type==null){
			type="";
			out.println("参数错误");
			out.flush();
			out.close();
			response.setHeader("refresh", "2;url="+request.getHeader("Referer"));
			return;
		}
		if(type.equals("change")){
			id=new String(id.getBytes("iso-8859-1"),"utf-8");
			String postName=request.getParameter("postName");
			String postSalary=request.getParameter("postSalary");
			String detail=request.getParameter("detail");
			pdao.changeAPost(id, new PostInformation(detail, postName, Double.parseDouble(postSalary)));
			response.sendRedirect("managePost.jsp");
			return ;
		}
		if(type.equals("add")){
			String postName=request.getParameter("postname");
			String postSalary=request.getParameter("postsalary");
			String detail=request.getParameter("detail");
			pdao.addAPost(new PostInformation(detail, postName, Double.parseDouble(postSalary)));
		}
		if(type.equals("del")){
			id=new String(id.getBytes("iso-8859-1"),"utf-8");
			pdao.delPost(id);
		}
		response.setHeader("refresh", "1;url="+request.getHeader("Referer"));
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostInformationDao pdao=new PostInformationDao();
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(type==null){
			type="";
			out.println("参数错误");
			out.flush();
			out.close();
			response.setHeader("refresh", "2;url="+request.getHeader("Referer"));
			return;
		}
		if(type.equals("change")){
			String postName=request.getParameter("postName");
			String postSalary=request.getParameter("postSalary");
			String detail=request.getParameter("detail");
			pdao.changeAPost(id, new PostInformation(detail, postName, Double.parseDouble(postSalary)));
			response.sendRedirect("managePost.jsp");
			return ;
		}
		if(type.equals("add")){
			String postName=request.getParameter("postname");
			String postSalary=request.getParameter("postsalary");
			String detail=request.getParameter("detail");
			pdao.addAPost(new PostInformation(detail, postName, Double.parseDouble(postSalary)));
		}
		if(type.equals("del")){
			pdao.delPost(id);
		}
		response.setHeader("refresh", "1;url="+request.getHeader("Referer"));
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

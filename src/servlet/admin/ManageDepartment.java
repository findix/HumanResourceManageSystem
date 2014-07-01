package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentInformationDao;

import pojo.DepartmentInformation;
import pojo.PostInformation;

public class ManageDepartment extends HttpServlet {
	DepartmentInformationDao dao;
	/**
	 * Constructor of the object.
	 */
	public ManageDepartment() {
		super();
		dao=new DepartmentInformationDao();
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
			String departID=request.getParameter("departID");
			String departName=request.getParameter("departName");
			String officeAddress=request.getParameter("officeAddress");
			dao.changeDepartMentInformation(id, new DepartmentInformation(departName, departID, officeAddress));
			response.sendRedirect("manageDepartments.jsp");
		}
		if(type.equals("add")){
			String departID=request.getParameter("departID");
			String departName=request.getParameter("departName");
			String officeAddress=request.getParameter("address");
			dao.addDepartMent( new DepartmentInformation(departName, departID, officeAddress));
		}
		if(type.equals("del")){
			dao.deleteDepartMentInformation(id);
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
	doGet(request, response);
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

package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentPostRequmentDao;

import pojo.PostInformation;
import pojo.PostRequirement;

public class ManageADepartmentPost extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageADepartmentPost() {
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
		DepartmentPostRequmentDao pdao=new DepartmentPostRequmentDao();
		String type=request.getParameter("type");
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
			String dpID=request.getParameter("dpID");
			String actualNum=request.getParameter("actualNum");
			pdao.changeWorkRequireMentNum(dpID, postName, actualNum);
			response.sendRedirect("manageADepartment.jsp?departId="+dpID);
			return ;
		}
		if(type.equals("add")){
			String postName=request.getParameter("postName");
			String dpID=request.getParameter("dpID");
			String reqNum=request.getParameter("reqNum");
			pdao.addWorkRequireMent(new PostRequirement(dpID, postName, reqNum));
		}
		if(type.equals("del")){
			String postName=request.getParameter("postName");
			String dpID=request.getParameter("departId");
			pdao.removeWorkRequireMent(dpID, postName);
			
		}
		response.setHeader("refresh", "0;url="+request.getHeader("Referer"));
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

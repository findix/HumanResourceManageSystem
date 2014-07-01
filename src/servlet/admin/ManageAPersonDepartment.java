package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainRecordDao;

public class ManageAPersonDepartment extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManageAPersonDepartment() {
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

		String type=request.getParameter("type");
		String pid=request.getParameter("pid");	
		String tid=request.getParameter("tid");
		TrainRecordDao dao=new TrainRecordDao();
		if(type.equals("change")){
			dao.addAPersonTrainRecord(pid, tid);
		}
		if(type.equals("del")){
			dao.deleteAPersonTrainRecord(pid, tid);
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

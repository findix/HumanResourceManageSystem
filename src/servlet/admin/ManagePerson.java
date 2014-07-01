package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDao;
import dao.TrainRecordDao;

import pojo.DepartmentInformation;
import pojo.Person;
import pojo.TrainRecord;

public class ManagePerson extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManagePerson() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		PersonDao dao = new PersonDao();
		if (type == null) {
			type = "";
			out.println("参数错误");
			out.flush();
			out.close();
			response.setHeader("refresh",
					"2;url=" + request.getHeader("Referer"));
			return;
		}
		if (type.equals("change")) {
			String empid = request.getParameter("empid");
			String empname = request.getParameter("empname");
			String sex = request.getParameter("sex");
			String birth = request.getParameter("birth");
			String naplace = request.getParameter("naplace");
			String edubg = request.getParameter("edubg");
			String joworktime = request.getParameter("joworktime");
			String jocomptime = request.getParameter("jocomptime");
			String polistatus = request.getParameter("polistatus");
			String basicwage = request.getParameter("basicwage");
			dao.changePerson(
					empid,new Person(Double.parseDouble(basicwage), Date
							.valueOf(birth), edubg, empid, empname, Date
							.valueOf(jocomptime), Date.valueOf(joworktime),
							naplace, polistatus, sex));
			response.sendRedirect("manageAPersonAllInformation.jsp?empid="
					+ empid);

		}
		if (type.equals("add")) {
			String empid = request.getParameter("empid");
			String empname = request.getParameter("empname");
			String sex = request.getParameter("address");
			String birth = request.getParameter("address");
			String naplace = request.getParameter("address");
			String edubg = request.getParameter("address");
			String joworktime = request.getParameter("address");
			String jocomptime = request.getParameter("address");
			String polistatus = request.getParameter("address");
			String basicwage = request.getParameter("address");
			dao.addPerson(new Person(Double.parseDouble(basicwage), Date
					.valueOf(birth), edubg, empid, empname, Date
					.valueOf(jocomptime), Date.valueOf(joworktime), naplace,
					polistatus, sex));
		}
		if (type.equals("del")) {
			String empid = request.getParameter("empid");
			dao.delPerson(empid);
		}
		response.setHeader("refresh", "1;url=" + request.getHeader("Referer"));

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

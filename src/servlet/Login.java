package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (type == null) {
			type = "";
			out.println("参数错误");
			out.flush();
			out.close();
			response.setHeader("refresh",
					"2;url=" + request.getHeader("Referer"));
			return;
		}
		if (type.equals("admin")) {
			if (name.equals("admin") && password.equals("123456")) {
				request.getSession().setAttribute("AdminName", name);
				response.sendRedirect("admin/index.jsp");
				return;
			}
		}
		if (type.equals("user")) {
			if (password.equals("123456")) {
				request.getSession().setAttribute("empid", name);
				response.sendRedirect("user/index.jsp");
				return;
			}
		}
		response.sendRedirect("login.jsp");

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

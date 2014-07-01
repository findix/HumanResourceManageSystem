package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.PostRequirement;
import tools.DBHelper;
import viewPojo.DepartmentPostInformation;

public class DepartmentPostRequmentDao {
	private DBHelper db=new DBHelper();
	/**
	 * 得到一个部门的所有岗位需求
	 * 
	 * @param departId
	 * @return
	 */
	public DepartmentPostInformation[] getADepartmentAllWorkRequirement(String departId) {
		String sql="select departid,departname,post,reqnum,num,post_salary,detail from departpost where departId=?";
		ResultSet rs = db.executeQuery(sql,departId);
		LinkedList<DepartmentPostInformation> l = new LinkedList<DepartmentPostInformation>();
		try {
			while (rs.next()) {
				String departid = rs.getString("departid");
				String departname = rs.getString("departname");
				String post = rs.getString("post");
				int reqnum = rs.getInt("reqnum");
				int num = rs.getInt("num");
				String post_salary = rs.getString("post_salary");
				String detail = rs.getString("detail");
				l.add(new DepartmentPostInformation(num, reqnum, post, detail, post_salary));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new DepartmentPostInformation[0]);
	}

	/**
	 * 添加一个部门岗位需求
	 * @param wr
	 * @return
	 */
	public boolean addWorkRequireMent(PostRequirement wr) {
		String sql="insert into Postinfo (departId,post,reqnum) values(?,?,?)";
		int k=db.executeUpdate(sql,wr.getDepartmentNum(),wr.getPostName(),wr.getRequestNum());
		db.closeConnection();
		return !(k==0);
	}

	/**
	 * 删除一个部门的岗位需求
	 * 
	 * @param wr
	 * @return
	 */
	public boolean removeWorkRequireMent(String departNum,String postName) {
		String sql="delete from Postinfo where departId=? and post=?";
		int k=db.executeUpdate(sql,departNum,postName);
		db.closeConnection();
		return !(k==0);
	}

	/**
	 * 改变一个部门的岗位需求人数,人数必须大于0
	 * 
	 * @param departNum
	 * @param postNum
	 * @param newRequestNum
	 * @return
	 */
	public boolean changeWorkRequireMentNum(String departNum, String postName,
			String newRequestNum) {
		String sql="update postInfo set reqnum=? where departid=? and post=?";
		int k=db.executeUpdate(sql, newRequestNum,departNum,postName);
		db.closeConnection();
		return !(k==0);
	}

}

package dao;

import java.sql.ResultSet;

import pojo.DepartmentInformation;
import pojo.PostInformation;
import tools.DBHelper;
import viewPojo.PersonAllInformation;

public class StatisticsDao {
	private DBHelper db=new DBHelper();
	/**
	 * 得到公司的所有人数
	 * @return
	 */
	public int getAllPersonNum(){
		String sql="execute total_emp";
		db.executeQuery(sql);
		ResultSet rs = db.executeQuery(sql);
		try {
			rs.next();
			int num = rs.getInt(1);
			return num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 得到一个部门的所有人数
	 * @param dpid
	 * @return
	 */
	public int getDepartmentNum(String dpid){
		String sql="execute depart_num ?";
		db.executeQuery(sql,dpid);
		ResultSet rs = db.executeQuery(sql,dpid);
		try {
			rs.next();
			int num = rs.getInt(1);
			return num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 得到某个部门某个岗位的空闲人数
	 * @param dpid
	 * @return
	 */
	public int getDepartmentPostNull(String dpid,String post){
		String sql="execute dpnull_num ?,?";
		db.executeQuery(sql);
		ResultSet rs = db.executeQuery(sql,dpid,post);
		try {
			rs.next();
			int num = rs.getInt("count");
			return num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 得到某部门的应需人数与实际人数
	 * @param dpid
	 * @return
	 */

	public int getDepartmentReqAndNum(String dpid){
		String sql="execute req_num ?";
		db.executeQuery(sql);
		ResultSet rs = db.executeQuery(sql,dpid);
		try {
			rs.next();
			int num = rs.getInt("count");
			return num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
//	/**
//	 * 得到某个部门的部门信息
//	 * @param dpid
//	 * @return
//	 */
//	public DepartmentInformation getDepartmentInfo(String dpid){
//		String sql="execute departid_info ? ?";
//		return null;
//	}
//	/**
//	 * 得到某个职工的职工信息
//	 * @param dpid
//	 * @return
//	 */
//	public PersonAllInformation getEmpInfo(String empid){
//		String sql="execute emp_info  ?";
//		return null;
//	}
}

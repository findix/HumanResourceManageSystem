package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.DepartmentInformation;
import tools.DBHelper;
import viewPojo.PersonAllInformation;

public class DepartmentInformationDao {
	private DBHelper db=new DBHelper();
	
	public PersonAllInformation[] getAllPersonByDepartment(String departId){
		PersonDao dao = new PersonDao();
		return dao.searchPerson(null, null, null, null, null, null, null,departId);
	}
	/**
	 * 添加一个部门
	 * @param dpi
	 */
	public boolean addDepartMent(DepartmentInformation dpi){
		String sql="insert into departinfo (departId,departname,officeadd) values(?,?,?);";
		int k=db.executeUpdate(sql,dpi.getDepartmentID(),dpi.getDepartmentName(),dpi.getOfficeAddress());
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 得到一个部门
	 * @param dpId 部门ID
	 * @return
	 */
	public DepartmentInformation getDepartMentInformation(String dpId){
		String sql="select departid,departname,officeadd from departinfo where departId=?";
		ResultSet rs = db.executeQuery(sql,dpId);
		try {
			rs.next();
			String departId = rs.getString("departid");
			String departname = rs.getString("departname");
			String officeadd = rs.getString("officeadd");
			db.closeConnection();
			return new DepartmentInformation(departname,departId,  officeadd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到所有部门
	 * @param dpId 部门ID
	 * @return
	 */
	public DepartmentInformation[] getAllDepartMentInformation(){
		String sql="select departId,departname,officeadd from departinfo";
		ResultSet rs = db.executeQuery(sql);
		LinkedList<DepartmentInformation> l = new LinkedList<DepartmentInformation>();
		try {
			while (rs.next()) {
				String departId = rs.getString("departId");
				String departname = rs.getString("departname");
				String officeadd = rs.getString("officeadd");
				l.add(new DepartmentInformation(departname, departId, officeadd));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new DepartmentInformation[0]);
	}
	
	/**
	 * 删除一个部门信息
	 * @param dpId
	 * @return
	 */
	public boolean deleteDepartMentInformation(String dpId){
		String sql="delete from departinfo where departId=?";
		int k=db.executeUpdate(sql, dpId);
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 改变部门信息;
	 * @param dpId
	 * @param dpi
	 * @return
	 */
	public boolean changeDepartMentInformation(String dpId,DepartmentInformation dpi){
		String sql="update departinfo set departId=?,departname=?,officeadd=? where departId=?";
		int k=db.executeUpdate(sql, dpi.getDepartmentID(),dpi.getDepartmentName(),dpi.getOfficeAddress(),dpId);
		db.closeConnection();
		return !(k==0);
	}
}

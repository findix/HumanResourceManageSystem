package pojo;

import java.sql.Date;

/**
 * 任职表，可以是过去的记录也可以是现在的记录
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class WorkRecord {

	/**
	 * 部门号
	 */
	private String departmentID;
	/**
	 * 员工号
	 */
	private String employeID;
	/**
	 * 岗位名
	 */
	private String postName;
	/**
	 * 任职开始时间
	 */
	private Date startTime;

	public WorkRecord(String departmentID, String employeID, String postName,
			Date startTime) {
		super();
		this.departmentID = departmentID;
		this.employeID = employeID;
		this.postName = postName;
		this.startTime = startTime;
	}

	public WorkRecord(){

	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getEmployeID() {
		return employeID;
	}

	public void setEmployeID(String employeID) {
		this.employeID = employeID;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}
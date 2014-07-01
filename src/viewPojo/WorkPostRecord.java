package viewPojo;

import java.sql.Date;

public class WorkPostRecord {
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
	/**
	 * 部门名称
	 */
	private String departmentName;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public WorkPostRecord(String departmentID, String employeID, String postName,
			Date startTime, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.employeID = employeID;
		this.postName = postName;
		this.startTime = startTime;
		this.departmentName = departmentName;
	}
	
}

package viewPojo;

import java.sql.Date;


/**
 * 个人全部信息视图
 * 
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 9:26:19
 */
public class PersonAllInformation {

	public PersonAllInformation(double basicWage, String educationBackground,
			String empid, String empname, Date joinCompanyTime,
			Date joinWorkTime, String polistatus, String departmentName,
			String departmentID, String officeAddress, String detail,
			String postName, double postSalary) {
		super();
		this.basicWage = basicWage;
		this.educationBackground = educationBackground;
		this.empid = empid;
		this.empname = empname;
		this.joinCompanyTime = joinCompanyTime;
		this.joinWorkTime = joinWorkTime;
		this.polistatus = polistatus;
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		this.officeAddress = officeAddress;
		this.detail = detail;
		this.postName = postName;
		this.postSalary = postSalary;
	}

	/**
	 * 基本工资
	 */
	private double basicWage;
	/**
	 * 学历
	 */
	private String educationBackground;
	/**
	 * 职工号
	 */
	private String empid;
	/**
	 * 职工姓名
	 */
	private String empname;
	/**
	 * 进单位时间
	 */
	private Date joinCompanyTime;
	/**
	 * 参加工作时间
	 */
	private Date joinWorkTime;
	/**
	 * 政治面貌
	 */
	private String polistatus;

	/**
	 * 部门名
	 */
	private String departmentName;
	/**
	 * 部门号
	 */
	private String departmentID;
	/**
	 * 办公室地址
	 */
	private String officeAddress;
	
	/**
	 * 岗位描述
	 */
	private String detail;
	/**
	 * 岗位名
	 */
	private String postName;
	/**
	 * 岗位薪水
	 */
	private double postSalary;
	
	public PersonAllInformation() {

	}

	public double getBasicWage() {
		return basicWage;
	}

	public void setBasicWage(double basicWage) {
		this.basicWage = basicWage;
	}

	public String getEducationBackground() {
		return educationBackground;
	}

	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Date getJoinCompanyTime() {
		return joinCompanyTime;
	}

	public void setJoinCompanyTime(Date joinCompanyTime) {
		this.joinCompanyTime = joinCompanyTime;
	}

	public Date getJoinWorkTime() {
		return joinWorkTime;
	}

	public void setJoinWorkTime(Date joinWorkTime) {
		this.joinWorkTime = joinWorkTime;
	}

	public String getPolistatus() {
		return polistatus;
	}

	public void setPolistatus(String polistatus) {
		this.polistatus = polistatus;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public double getPostSalary() {
		return postSalary;
	}

	public void setPostSalary(double postSalary) {
		this.postSalary = postSalary;
	}


}
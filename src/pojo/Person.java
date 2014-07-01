package pojo;

import java.sql.Date;

/**
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class Person {

	/**
	 * 基本工资
	 */
	private double basicWage;
	/**
	 * 出生年月
	 */
	private Date birthday;
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
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 政治面貌
	 */
	private String polistatus;
	/**
	 * 性别
	 */
	private String sex;

	public Person(double basicWage, Date birthday, String educationBackground,
			String empid, String empname, Date joinCompanyTime,
			Date joinWorkTime, String nativePlace, String polistatus, String sex) {
		super();
		this.basicWage = basicWage;
		this.birthday = birthday;
		this.educationBackground = educationBackground;
		this.empid = empid;
		this.empname = empname;
		this.joinCompanyTime = joinCompanyTime;
		this.joinWorkTime = joinWorkTime;
		this.nativePlace = nativePlace;
		this.polistatus = polistatus;
		this.sex = sex;
	}

	public Person(){

	}

	public double getBasicWage() {
		return basicWage;
	}

	public void setBasicWage(double basicWage) {
		this.basicWage = basicWage;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getPolistatus() {
		return polistatus;
	}

	public void setPolistatus(String polistatus) {
		this.polistatus = polistatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
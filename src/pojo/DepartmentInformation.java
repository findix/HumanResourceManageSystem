package pojo;

/**
 * 部门信息
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class DepartmentInformation {

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
	public DepartmentInformation(String departmentName, String departmentID,
			String officeAddress) {
		super();
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		this.officeAddress = officeAddress;
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


}
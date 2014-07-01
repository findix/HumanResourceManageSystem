package viewPojo;

import pojo.DepartmentInformation;

/**
 * 部门需求的职位目前信息
 * 
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 9:26:19
 */
public class DepartmentPostInformation {

	/**
	 * 岗位实际人数
	 */
	private int actualPerson;
	/**
	 * 应需人数
	 */
	private int needPerson;
	/**
	 * 岗位名称
	 */
	private String postName;
	/**
	 * 岗位信息
	 */
	private String postDetial;
	/**
	 * 岗位薪水
	 */
	private String postSalary;

	public DepartmentPostInformation(int actualPerson, int needPerson,
			String postName, String postDetial, String postSalary) {
		super();
		this.actualPerson = actualPerson;
		this.needPerson = needPerson;
		this.postName = postName;
		this.postDetial = postDetial;
		this.postSalary = postSalary;
	}

	public int getActualPerson() {
		return actualPerson;
	}

	public void setActualPerson(int actualPerson) {
		this.actualPerson = actualPerson;
	}

	public int getNeedPerson() {
		return needPerson;
	}

	public void setNeedPerson(int needPerson) {
		this.needPerson = needPerson;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostDetial() {
		return postDetial;
	}

	public void setPostDetial(String postDetial) {
		this.postDetial = postDetial;
	}

	public String getPostSalary() {
		return postSalary;
	}

	public void setPostSalary(String postSalary) {
		this.postSalary = postSalary;
	}
}
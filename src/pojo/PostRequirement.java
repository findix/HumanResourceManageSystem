package pojo;

/**
 * 岗位需求信息
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class PostRequirement {

	/**
	 * 部门号
	 */
	private String departmentNum;
	/**
	 * 岗位名
	 */
	private String postName;
	/**
	 * 应需人数
	 */
	private String requestNum;

	public PostRequirement(String departmentNum, String postName,
			String requestNum) {
		super();
		this.departmentNum = departmentNum;
		this.postName = postName;
		this.requestNum = requestNum;
	}

	public PostRequirement(){

	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}

}
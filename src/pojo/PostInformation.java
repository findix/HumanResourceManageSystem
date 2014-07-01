package pojo;

/**
 * 岗位信息描述类
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class PostInformation {

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

	public PostInformation(String detail, String postName, double postSalary) {
		super();
		this.detail = detail;
		this.postName = postName;
		this.postSalary = postSalary;
	}

	public PostInformation(){

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
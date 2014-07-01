package viewPojo;

import pojo.PostInformation;

public class PostAllInformation {
	/**
	 * 职位基本信息
	 */
	private PostInformation pinfor;
	/**
	 * 职位目前人数
	 */
	private int postNum;
	public PostAllInformation(PostInformation pinfor, int postNum) {
		super();
		this.pinfor = pinfor;
		this.postNum = postNum;
	}
	public PostInformation getPinfor() {
		return pinfor;
	}
	public void setPinfor(PostInformation pinfor) {
		this.pinfor = pinfor;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
}

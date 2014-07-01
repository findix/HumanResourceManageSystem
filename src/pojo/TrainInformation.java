package pojo;

import java.sql.Date;

/**
 * 培训信息
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class TrainInformation {

	/**
	 * 培训内容
	 */
	private String content;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 培训开始时间
	 */
	private Date startTime;
	/**
	 * 培训号
	 */
	private String trainID;

	public TrainInformation(){

	}

	public TrainInformation(String content, Date endTime, Date startTime,
			String trainID) {
		super();
		this.content = content;
		this.endTime = endTime;
		this.startTime = startTime;
		this.trainID = trainID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	

}
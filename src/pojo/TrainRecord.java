package pojo;

/**
 * 个人培训记录
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 0:45:16
 */
public class TrainRecord {

	/**
	 * 职工号
	 */
	private String employeID;
	/**
	 * 培训号
	 */
	private String trainID;

	public TrainRecord(String employeID, String trainID) {
		super();
		this.employeID = employeID;
		this.trainID = trainID;
	}

	public TrainRecord(){

	}

	public String getEmployeID() {
		return employeID;
	}

	public void setEmployeID(String employeID) {
		this.employeID = employeID;
	}

	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}


}
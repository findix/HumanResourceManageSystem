package viewPojo;

/**
 * 薪水视图
 * @author Eric
 * @version 1.0
 * @created 16-一月-2013 9:26:19
 */
public class Wagetab {

	/**
	 * 基本工资
	 */
	private double basicWage;
	/**
	 * 扣除
	 */
	private double delWage;
	/**
	 * 职工号
	 */
	private String employeeID;
	/**
	 * 医疗保险
	 */
	private double medicare;
	/**
	 * 养老金
	 */
	private double pension;
	/**
	 * 岗位工资
	 */
	private double postWage;
	/**
	 * 公积金
	 */
	private double reserveFunds;
	/**
	 * 应发工资
	 */
	private double shouldWage;
	/**
	 * 实发工资
	 */
	private double takehopay;
	/**
	 * 失业保险
	 */
	private double unempinsure;
	
	
	public Wagetab(double basicWage, double delWage, String employeeID,
			double medicare, double pension, double postWage,
			double reserveFunds, double shouldWage, double takehopay,
			double unempinsure) {
		super();
		this.basicWage = basicWage;
		this.delWage = delWage;
		this.employeeID = employeeID;
		this.medicare = medicare;
		this.pension = pension;
		this.postWage = postWage;
		this.reserveFunds = reserveFunds;
		this.shouldWage = shouldWage;
		this.takehopay = takehopay;
		this.unempinsure = unempinsure;
	}


	public Wagetab(){

	}


	public double getBasicWage() {
		return basicWage;
	}


	public void setBasicWage(double basicWage) {
		this.basicWage = basicWage;
	}


	public double getDelWage() {
		return delWage;
	}


	public void setDelWage(double delWage) {
		this.delWage = delWage;
	}


	public String getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}


	public double getMedicare() {
		return medicare;
	}


	public void setMedicare(double medicare) {
		this.medicare = medicare;
	}


	public double getPension() {
		return pension;
	}


	public void setPension(double pension) {
		this.pension = pension;
	}


	public double getPostWage() {
		return postWage;
	}


	public void setPostWage(double postWage) {
		this.postWage = postWage;
	}


	public double getReserveFunds() {
		return reserveFunds;
	}


	public void setReserveFunds(double reserveFunds) {
		this.reserveFunds = reserveFunds;
	}


	public double getShouldWage() {
		return shouldWage;
	}


	public void setShouldWage(double shouldWage) {
		this.shouldWage = shouldWage;
	}


	public double getTakehopay() {
		return takehopay;
	}


	public void setTakehopay(double takehopay) {
		this.takehopay = takehopay;
	}


	public double getUnempinsure() {
		return unempinsure;
	}


	public void setUnempinsure(double unempinsure) {
		this.unempinsure = unempinsure;
	}

}
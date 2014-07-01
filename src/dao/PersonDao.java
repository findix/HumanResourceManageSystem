package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.Person;
import tools.DBHelper;
import viewPojo.PersonAllInformation;
import viewPojo.Wagetab;

public class PersonDao {
	private DBHelper db = new DBHelper();

	/**
	 * 查询个人的基本全部信息
	 * 
	 * @param empid
	 * @return
	 */
	public Person searchPersonBasicInformation(String empid) {
		String sql = "select empid,empname,sex,birth,naplace,edubg,"
				+ "joworktime,jocomptime,polistatus,basicwage "
				+ "from humaninfo where empid=?";
		ResultSet rs = db.executeQuery(sql, empid);
		try {
			rs.next();
			String empId = rs.getString("empid");
			String empname = rs.getString("empname");
			String sex = rs.getString("sex");
			Date birth = rs.getDate("birth");
			Date joworktime = rs.getDate("joworktime");
			Date jocomptime = rs.getDate("jocomptime");
			String polistatus = rs.getString("polistatus");
			String naplace = rs.getString("naplace");
			String edubg = rs.getString("edubg");
			double basicwage = rs.getDouble("basicwage");
			db.closeConnection();
			return new Person(basicwage, birth, edubg, empId, empname,
					jocomptime, joworktime, naplace, polistatus, sex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加一个人
	 * 
	 * @param p
	 * @return
	 */
	public boolean addPerson(Person p) {
		String sql = "insert into humaninfo (empid,empname,sex,birth,naplace,edubg,joworktime,jocomptime,polistatus,basicwage) values(?,?,?,?,?,?,?,?,?,?)";
		int k = db.executeUpdate(sql, p.getEmpid(), p.getEmpname(), p.getSex(),
				p.getBirthday().toString(), p.getNativePlace(), p
						.getEducationBackground(), p.getJoinWorkTime()
						.toString(), p.getJoinCompanyTime().toString(), p
						.getPolistatus(), p.getBasicWage() + "");
		db.closeConnection();
		return !(k == 0);
	}

	/**
	 * 删除一个人
	 * 
	 * @param empid
	 * @return
	 */
	public boolean delPerson(String empid) {
		String sql = "delete from humaninfo where empid=?";
		int k = db.executeUpdate(sql, empid);
		db.closeConnection();
		return !(k == 0);
	}

	/**
	 * 改变一个人的信息,ID不让改
	 * 
	 * @param empid
	 * @param p
	 * @return
	 */
	public boolean changePerson(String empid, Person p) {
		String sql = "update humaninfo set empid=?,empname=?,sex=?,birth=?,naplace=?,edubg=?,joworktime=?,jocomptime=?,polistatus=?,basicwage=? where empid=?";
		int k = db.executeUpdate(sql, p.getEmpid(), p.getEmpname(), p.getSex(),
				p.getBirthday().toString(), p.getNativePlace(), p
						.getEducationBackground(), p.getJoinWorkTime()
						.toString(), p.getJoinCompanyTime().toString(), p
						.getPolistatus(), p.getBasicWage() + "", empid);
		db.closeConnection();
		return !(k == 0);
	}

	/**
	 * 按照ID查找一个人
	 * 
	 * @param empid
	 * @return
	 */
	public PersonAllInformation searchPerson(String empid) {
		String sql = "select empid,empname,edubg,joworktime,jocomptime,"
				+ "polistatus,departId,departname,officeadd,post,basicwage"
				+ ",post_salary,detail from personAllinfo where empid=?";
		ResultSet rs = db.executeQuery(sql, empid);
		try {
			rs.next();
			String empname = rs.getString("empname");
			String edubg = rs.getString("edubg");
			Date joworktime = rs.getDate("joworktime");
			Date jocomptime = rs.getDate("jocomptime");
			String polistatus = rs.getString("polistatus");
			String departId = rs.getString("departId");
			String departname = rs.getString("departname");
			String officeadd = rs.getString("officeadd");
			String post = rs.getString("post");
			double basicwage = rs.getDouble("basicwage");
			double post_salary = rs.getDouble("post_salary");
			String detail = rs.getString("detail");
			db.closeConnection();
			return new PersonAllInformation(basicwage, edubg, empid, empname,
					jocomptime, joworktime, polistatus, departname, departId,
					officeadd, detail, post, post_salary);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按照很多信息去查找一个人
	 * 
	 * @param empid
	 * @return
	 */
	public PersonAllInformation[] searchPerson(String empid, String departName,
			String basicwageUp, String basicwageDown, String post,
			String empname, String edubg, String departId) {
		StringBuilder sql = new StringBuilder(
				"select empid,empname,edubg,joworktime,jocomptime,"
						+ "polistatus,departId,departname,officeadd,post,basicwage"
						+ ",post_salary,detail from personAllinfo where 1=1 ");
		LinkedList<String> sl = new LinkedList<String>();
		if (empid != null && empid.length() > 0) {
			sql.append("and empid=? ");
			sl.add(empid);
		}
		if (departName != null && departName.length() > 0) {
			sql.append("and departName=? ");
			sl.add(departName);
		}
		if (basicwageUp != null && basicwageUp.length() > 1) {
			sql.append("and (post_salary+basicwage)>=? ");
			sl.add(basicwageUp);
		}
		if (basicwageDown != null && basicwageDown.length() > 1) {
			sql.append("and (post_salary+basicwage)<=? ");
			sl.add(basicwageDown);
		}
		if (post != null && post.length() > 0) {
			sql.append("and post=? ");
			sl.add(post);
		}
		if (empname != null && empname.length() > 0) {
			sql.append("and empname Like ? ");
			sl.add(empname);
		}
		if (edubg != null && edubg.length() > 0) {
			sql.append("and edubg=? ");
			sl.add(edubg);
		}
		if (departId != null && departId.length() > 0) {
			sql.append("and departId=? ");
			sl.add(departId);
		}

		ResultSet rs = db.executeQuery(sql.toString(),
				sl.toArray(new String[0]));
		LinkedList<PersonAllInformation> l = new LinkedList<PersonAllInformation>();
		try {
			while (rs.next()) {
				String empId2 = rs.getString("empid");
				String empname2 = rs.getString("empname");
				String edubg2 = rs.getString("edubg");
				Date joworktime = rs.getDate("joworktime");
				Date jocomptime = rs.getDate("jocomptime");
				String polistatus = rs.getString("polistatus");
				String departId2 = rs.getString("departId");
				String departname = rs.getString("departname");
				String officeadd = rs.getString("officeadd");
				String post2 = rs.getString("post");
				double basicwage = rs.getDouble("basicwage");
				double post_salary = rs.getDouble("post_salary");
				String detail = rs.getString("detail");
				l.add(new PersonAllInformation(basicwage, edubg2, empId2,
						empname2, jocomptime, joworktime, polistatus,
						departname, departId2, officeadd, detail, post2,
						post_salary));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new PersonAllInformation[0]);
	}

	/**
	 * 得到一个人的所有工资信息
	 * 
	 * @param pid
	 * @return
	 */
	public Wagetab getAPersonSalaryInformation(String pid) {
		String sql = "select empid,basicwage,"
				+ "post_salary,pay,reservfunds,pension"
				+ ",medicare,unempinsure,Deduct,takehopay"
				+ " from wagetab where empid=?";
		ResultSet rs = db.executeQuery(sql, pid);
		try {
			rs.next();
			String empid = rs.getString("empid");
			double basicwage = rs.getDouble("basicwage");
			double post_salary = rs.getDouble("post_salary");
			double pay = rs.getDouble("pay");
			double reservfunds = rs.getDouble("reservfunds");
			double pension = rs.getDouble("pension");
			double medicare = rs.getDouble("medicare");
			double unempinsure = rs.getDouble("unempinsure");
			double Deduct = rs.getDouble("Deduct");
			double takehopay = rs.getDouble("takehopay");
			db.closeConnection();
			return new Wagetab(basicwage, Deduct, empid, medicare, pension,
					post_salary, reservfunds, pay, takehopay, unempinsure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return null;
	}
}

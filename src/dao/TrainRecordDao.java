package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.Person;
import pojo.TrainInformation;
import tools.DBHelper;

public class TrainRecordDao {
	private DBHelper db=new DBHelper();
	/**
	 * 得到一个人所有的培训记录
	 * @param pid
	 * @return
	 * 新建了selftrain视图显示个人培训信息
	 */
	public TrainInformation[] getAPersonAllTrainRecord(String pid){
		String sql="select trainid,starttime,overtime,content from selftrain where empid=?";
		ResultSet rs = db.executeQuery(sql,pid);
		LinkedList<TrainInformation> l = new LinkedList<TrainInformation>();
		try {
			while (rs.next()) {
				String trainid = rs.getString("trainid");
				Date starttime = rs.getDate("starttime");
				Date overtime = rs.getDate("overtime");
				String contennt = rs.getString("content");
				l.add(new TrainInformation(contennt, overtime, starttime, trainid));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new TrainInformation[0]);
	}
	/**
	 * 增加一个人的培训记录
	 * @param pid
	 * @param trainID
	 * @return
	 */
	public boolean addAPersonTrainRecord(String pid,String trainID){
		String sql="insert into trainoperate (empid,trainid) values (?,?)";
		int k=db.executeUpdate(sql,pid,trainID);
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 删除一个人的培训记录
	 * @param pid
	 * @param trainID
	 * @return
	 */
	public boolean deleteAPersonTrainRecord(String pid,String trainID){
		String sql="delete from trainoperate where empid=? and trainid=?";
		int k=db.executeUpdate(sql, pid,trainID);
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 得到一个培训的所有人
	 * @param pid
	 * @param trainID
	 * @return
	 */
	public Person[] getATrainAllPersonRecord(String trainID){
		String sql="select empid,empname,sex,birth,naplace,edubg,joworktime,jocomptime,polistatus,basicwage from humaninfo where empid in (select empid from trainoperate where trainid=?)";
		ResultSet rs = db.executeQuery(sql,trainID);
		LinkedList<Person> l = new LinkedList<Person>();
		try {
			while (rs.next()) {
				String empid = rs.getString("empid");
				String empname = rs.getString("empname");
				String sex = rs.getString("sex");
				Date birth = rs.getDate("birth");
				String naplace = rs.getString("naplace");
				String edubg = rs.getString("edubg");
				Date joworktime = rs.getDate("joworktime");
				Date jocomptime = rs.getDate("jocomptime");
				String polistatus = rs.getString("polistatus");
				double basicwage = rs.getDouble("basicwage");				
				l.add(new Person(basicwage, birth, edubg, empid, empname, jocomptime, joworktime, naplace, polistatus, sex));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new Person[0]);
	}
}

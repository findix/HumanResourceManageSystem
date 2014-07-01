package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.WorkRecord;
import tools.DBHelper;
import viewPojo.WorkPostRecord;

public class WorkRecordDao {
	private DBHelper db=new DBHelper();
	/**
	 * 得到一个人现在的工作
	 * @param pid
	 * @return
	 */
	public WorkRecord getAPersonNowWorkRecord(String pid){
		String sql="select depart,empid,post,start_time from holdPostInfo where empid=?";
		ResultSet rs = db.executeQuery(sql,pid);
		try {
			rs.next();
			String depart=rs.getString("depart");
			String empid=rs.getString("empid");
			String post=rs.getString("post");
			Date start_time = rs.getDate("start_time");
			db.closeConnection();
			return new WorkRecord(depart, empid, post, start_time);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 设置一个人现在的工作
	 * @param wr
	 * @return
	 */
	public boolean changeAPersonNowWorkRecord(WorkRecord wr ,String empid){
		String sql1="update holdPostinfo set depart=?,post=?,start_time=? where empid=?";
		String sql2="insert into holdPostinfo (depart,post,start_time,empid) values(?,?,? ?)";
		int k=db.executeUpdate(sql1, wr.getDepartmentID(),wr.getPostName(),wr.getStartTime().toString(),empid);
		db.closeConnection();
		if(k==0){
			k=db.executeUpdate(sql2, wr.getDepartmentID(),wr.getPostName(),wr.getStartTime().toString(),empid);
		}
		db.closeConnection();
		return !(k==0);
	}

	/**
	 * 得到一个人曾经的所有工作记录
	 * @param pid
	 * @return
	 */
	public WorkPostRecord[] getAPersonPastWorkRecord(String pid){
		String sql="select departId,departname,servpast,empid,departpatime from selfworkrecord where empid=?";
		ResultSet rs = db.executeQuery(sql,pid);
		LinkedList<WorkPostRecord> l = new LinkedList<WorkPostRecord>();
		try {
			while (rs.next()) {
				String departId = rs.getString("departId");
				String departname = rs.getString("departname");
				String servpast = rs.getString("servpast");
				String empid = rs.getString("empid");
				Date departtime = rs.getDate("departpatime");
				l.add(new WorkPostRecord(departId, empid, servpast, departtime, departname));
			}
			db.closeConnection();
		} catch (Exception e) {
			db.closeConnection();
			e.printStackTrace();
		}
		return l.toArray(new WorkPostRecord[0]);
	}
	
}

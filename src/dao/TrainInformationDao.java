package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.TrainInformation;
import tools.DBHelper;

public class TrainInformationDao {
	private DBHelper db=new DBHelper();
	/**
	 * 添加一条培训
	 * @param train
	 * @return
	 */
	public boolean addATrain(TrainInformation train){
		String sql="insert into traininfo (trainid,starttime,overtime,content) values(?,?,?,?)";
		int k=db.executeUpdate(sql,train.getTrainID(),train.getStartTime().toString(),train.getEndTime().toString(),train.getContent());
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 得到一个培训信息
	 * @param trainID
	 * @return
	 */
	public TrainInformation getATrain(String trainID){
		String sql="select trainid,starttime,overtime,contennt from traininfo where trainid=?";
		ResultSet rs = db.executeQuery(sql,trainID);
		try {
			rs.next();
			Date starttime = rs.getDate("starttime");
			Date overtime = rs.getDate("overtime");
			String contennt = rs.getString("contennt");
			db.closeConnection();
			return new TrainInformation( contennt,starttime, overtime,trainID);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;	
	}
	/**
	 * 删除培训
	 * @param trainID
	 * @return
	 */
	public boolean delATrain(String trainID){
		String sql="delete from traininfo where trainid=?";
		int k=db.executeUpdate(sql, trainID);
		db.closeConnection();
		return !(k==0);
		
	}
	/**
	 * 改变培训信息
	 * @param trainID
	 * @param train
	 * @return
	 */
	public boolean changeATrain(String trainID,TrainInformation train){
		String sql="update traininfo set trainid=?,starttime=?,overtime=?,content=? where trainid=?";
		int k=db.executeUpdate(sql, train.getTrainID(),train.getStartTime().toString(),train.getEndTime().toString(),train.getContent(),trainID);
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 得到所有培训信息
	 * @return
	 */
	public TrainInformation[] getAllTrainInformation(){
		String sql="select trainid,starttime,overtime,content from traininfo";
		ResultSet rs = db.executeQuery(sql);
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
}


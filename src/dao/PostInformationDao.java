package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import pojo.PostInformation;
import tools.DBHelper;
import viewPojo.PostAllInformation;

public class PostInformationDao {
	private DBHelper db=new DBHelper();
	/**
	 * 添加一个岗位
	 * @param post
	 * @return
	 */
	public boolean addAPost(PostInformation post){
		String sql="insert into Postoperate (post,detail,post_salary) values(?,?,?)";
		int k=db.executeUpdate(sql,post.getPostName(),post.getDetail(),post.getPostSalary()+"");
		db.closeConnection();
		return !(k==0);
	}
	/**
	 * 得到岗位信息
	 * @param postName
	 * @return
	 */
	public PostInformation getAPost(String postName){
		String sql="select post,detail,post_salary from Postoperate where post=?";
		ResultSet rs = db.executeQuery(sql,postName);
		try {
			rs.next();
			String post = rs.getString("post");
			String detail = rs.getString("detail");
			double post_salary = rs.getDouble("post_salary");
			db.closeConnection();
			return new PostInformation(post, detail, post_salary);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;		
	}
	/**
	 * 更改岗位信息
	 * @param postid
	 * @param post
	 */
	public boolean changeAPost(String oldPostName,PostInformation newPost){
		String sql="update Postoperate set post=?,detail=?,post_salary=? where post=?";
		int k=db.executeUpdate(sql,newPost.getPostName(),newPost.getDetail(),newPost.getPostSalary()+"",oldPostName);
		db.closeConnection();
		return !(k==0);		
	}
	/**
	 * 得到所有岗位
	 */
	//PostAllInformation
	public PostInformation[] getAllPost(){
		String sql="select post,detail,post_salary from Postoperate";
		ResultSet rs = db.executeQuery(sql);
		LinkedList<PostInformation> l = new LinkedList<PostInformation>();
		try {
			while (rs.next()) {
				String post = rs.getString("post");
				String detail = rs.getString("detail");
				double post_salary = rs.getDouble("post_salary");
				l.add(new PostInformation(detail, post, post_salary));
			}
			db.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return l.toArray(new PostInformation[0]);
	}
	/**
	 * 删除岗位
	 */
	public boolean delPost(String postName){
		String sql="delete from postoperate where post=?";
		int k=db.executeUpdate(sql,postName);
		db.closeConnection();
		return !(k==0);
	}
}

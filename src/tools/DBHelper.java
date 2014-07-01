package tools;

import java.sql.*;

public class DBHelper {
	private Connection con;

	/* 加载驱动程序 */

	public DBHelper() {

	}

	public Connection getConnection() throws SQLException {
		if (con == null || con.isClosed())
			con = JbdcUtils_C3P0.getConnection();
		return con;
	}

	/** 执行增删改操作,完整SQL语句 */
	public int executeUpdate(String sql) {
		int t = -1;
		try {
			Connection con;
			con = getConnection();
			Statement cmd = con.createStatement();
			t=cmd.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}

	/**
	 * 执行增删改操作 ，预存储SQL语句
	 * 
	 * @see java.sql.PreparedStatement.executeUpdate() throws SQLException
	 */
	public int executeUpdate(String sql, String... param) {
		int t = -1;
		try {
			Connection con;
			con = getConnection();
			PreparedStatement cmd = con.prepareStatement(sql);
			for (int i = 1; i <= param.length; i++) {
				cmd.setString(i, param[i - 1]);
			}
			t = cmd.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return t;
	}

	/** 执行查询操作 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection con;
			con = getConnection();
			Statement cmd = con.createStatement();
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	/** 执行查询操作，预存储SQL语句 */
	public ResultSet executeQuery(String sql, String... param) {
		ResultSet rs = null;
		try {
			Connection con;
			con = getConnection();
			PreparedStatement cmd = con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			for (int i = 1; i <= param.length; i++) {
				cmd.setString(i, param[i - 1]);
			}
			rs = cmd.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	/* 执行关闭数据库连接操作 */
	public void closeConnection() {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		closeConnection();
		super.finalize();
	}

}

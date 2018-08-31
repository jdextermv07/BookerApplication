package com.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exercise.bean.FilmBean;
import com.exercise.bean.AccountBean;

public class AccountDao {

	public AccountBean loginDetails(AccountBean logBean) {
		
		AccountBean acctBean = new AccountBean();
		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();

		String sql = "select username, password from accounts where username = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, logBean.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				acctBean.setUsername(rs.getString("username"));
				acctBean.setPassword(rs.getString("password"));
				
				
			}		
		} catch (SQLException e) {
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		return acctBean;

	}
}

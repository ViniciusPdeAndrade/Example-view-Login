package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DB;

public class UserDao {

	public boolean checkLogin(String name, String pass) {

		Connection conn = DB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean check = false;

		try {
			stmt = conn.prepareStatement("SELECT * FROM usuario WHERE nome = ? and passowrd = ?");
			stmt.setString(1, name);
			stmt.setString(2, pass);

			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;

			}
		} catch (SQLException e) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DB.closeConnection();
		}
		return check;
		
	}

}

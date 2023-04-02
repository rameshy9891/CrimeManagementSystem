package com.masai.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exceptions.SomethingWentWrong;

public class Cr_Criminal_DAOImpl implements Cr_Criminal_DAO {

	//========================= ASSIGN CRIMINAL TO CRIME ============================================
	@Override
	public void AssignCriminal(int cr_id, int criminal_id) throws SomethingWentWrong, SQLException {
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "INSERT INTO Crime_Criminal_Records (crime_id, criminal_id) VALUES(?, ?)";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setInt(1, cr_id);
			ps.setInt(2, criminal_id);
			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}

	}
	
	//============================ DELETE CRIMINAL FROM CRIME =========================
	@Override
	public void DeleteCrCriminal(int cr_id, int criminal_id) throws SQLException{
		try {
			Connection cn = DBUtil.establishDBConnection();
			String querry = "DELETE FROM Crime_Criminal_Records where crime_id = ? AND criminal_id = ?";
			PreparedStatement ps = cn.prepareStatement(querry);
			ps.setInt(1, cr_id);
			ps.setInt(2, criminal_id);
			ps.executeUpdate();
			DBUtil.closeConnection(cn);
		} catch (SQLException x) {
			throw new SQLException(x);
		}
	}
}
